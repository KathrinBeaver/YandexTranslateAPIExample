package main.java.ru.mai.pvk.service;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class ConnectionService {
    private String urlString;
    private String replyString = "";

    public ConnectionService(String url)
    {
        urlString = url;
    }

    public String readReply() {
        try {
            URL url = new URL(urlString);
            HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            int responseCode = urlConnection.getResponseCode();

            if (responseCode == HttpURLConnection.HTTP_OK) { // success
                BufferedReader in = new BufferedReader(new InputStreamReader(
                        urlConnection.getInputStream()));
                String inputLine;
                StringBuffer response = new StringBuffer();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // print result
                System.out.println(response.toString());
                replyString = response.toString();
            } else {
                System.out.println("GET request not worked");
                replyString = null;
            }

        } catch (MalformedURLException ex) {
            //Todo: Process exception
        } catch (IOException ex) {
            //Todo: Process exception
        } catch (Exception ex) {
            //Todo: Process exception
        }
        return replyString;
    }
}
