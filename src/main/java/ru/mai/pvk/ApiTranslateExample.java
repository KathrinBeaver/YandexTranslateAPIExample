package main.java.ru.mai.pvk;

import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import main.java.ru.mai.pvk.data.TextToTranslate;
import main.java.ru.mai.pvk.data.TranslatedText;
import main.java.ru.mai.pvk.facade.TranslateFacade;

public class ApiTranslateExample {

    public static void main(String[] args) {
        TranslateFacade translate = new TranslateFacade();
        System.out.println(translate.translate("Travel is adventure"));
    }
}
