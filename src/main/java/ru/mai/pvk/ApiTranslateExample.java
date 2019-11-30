package main.java.ru.mai.pvk;

import java.io.IOException;
import java.io.StringWriter;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.ru.mai.pvk.data.TextToTranslate;
import main.java.ru.mai.pvk.data.TranslatedText;

public class ApiTranslateExample {

    public static final String API_KEY = "trnsl.1.1.20191130T074829Z.0f279c18175ff42d.f00cd76c6696a2b35816fbff342e650ec3f198e9";
    public static final String URL = "https://translate.yandex.net/api/v1.5/tr.json/translate?";

//    public String createJsonString(TextToTranslate textToTranslate) {
//        StringWriter writer = new StringWriter();
//        ObjectMapper mapper = new ObjectMapper();
//        try {
//            mapper.writeValue(writer, textToTranslate);
//        } catch (IOException ex) {
//
//        }
//       return writer.toString();
//    }

    public static void main(String[] args) {
        TextToTranslate text = new TextToTranslate();
        text.setKey(API_KEY);
        text.setFormat("plain"); // plain or html
        text.setLang("en-ru"); //откуда -> куда
        text.setOptions("0"); // надо ли автоматически определять язык текста
        text.setText("Travel is adventure");

        String request = URL + text.createRequestString();
        URLConnectionReader reader = new URLConnectionReader(request);
        String response = reader.readReply();

        ObjectMapper mapper = new ObjectMapper();

        try {
            TranslatedText translatedText = mapper.readValue(response, TranslatedText.class);
            System.out.println(translatedText.getText());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
