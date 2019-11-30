package main.java.ru.mai.pvk.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.ru.mai.pvk.data.TextToTranslate;
import main.java.ru.mai.pvk.data.TranslatedText;

import java.io.IOException;

import static java.util.Objects.nonNull;

public class TranslateService {
    public static final String API_KEY = "trnsl.1.1.20191130T074829Z.0f279c18175ff42d.f00cd76c6696a2b35816fbff342e650ec3f198e9";
    public static final String URL = "https://translate.yandex.net/api/v1.5/tr.json/translate?";

    public TranslatedText translate(String text) {
        TextToTranslate data = createDataToTranslate(text);
        String request = URL + data.createRequestString();
        ConnectionService reader = new ConnectionService(request);
        String response = reader.readReply();
        if(nonNull(response)) {
            return covnertToTranslatedText(response);
        } else{
            return null;
        }
    }

    private TextToTranslate createDataToTranslate(String text){
        TextToTranslate data = new TextToTranslate();
        data.setKey(API_KEY);
        data.setFormat("plain"); // plain or html
        data.setLang("en-ru"); //откуда -> куда
        data.setOptions("0"); // надо ли автоматически определять язык текста
        data.setText(text);
        return data;
    }

    private TranslatedText covnertToTranslatedText(String response) {
        ObjectMapper mapper = new ObjectMapper();
        try {
            TranslatedText translatedText = mapper.readValue(response, TranslatedText.class);
            System.out.println(translatedText.getText());
            return translatedText;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
