package constants;

public enum Urls {
    STARTSEITE ("https://www.spiegel.de/"),
    ABOUT ("https://www.spiegel.de/");

    public String url;
    Urls(String url) {
        this.url = url;
    }

    public String getUrl()
    {
        return url;
    }
}
