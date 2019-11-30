package main.java.ru.mai.pvk.facade;

import main.java.ru.mai.pvk.data.TranslatedText;
import main.java.ru.mai.pvk.service.TranslateService;

import static java.util.Objects.nonNull;

public class TranslateFacade {
    public String translate(String text) {
        TranslateService translateService = new TranslateService();
        TranslatedText translatedText = translateService.translate(text);
        if(nonNull(translatedText)) {
            return translatedText.getText().get(0);
        } else{
            return "Error of translate: " + text;
        }
    }
}
