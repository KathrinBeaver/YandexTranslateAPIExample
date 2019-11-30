package main.java.ru.mai.pvk.data;

public class TextToTranslate {
    private String text;
    private String lang;
    private String format;
    private String options;
    private String key;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getOptions() {
        return options;
    }

    public void setOptions(String options) {
        this.options = options;
    }
    public String createRequestString()
    {
        return "key=" + key + "&lang=" + lang +
                "&format=" + format + "&options=" + options +
                "&text=" + text.replace(" ", "%20");
    }
}
