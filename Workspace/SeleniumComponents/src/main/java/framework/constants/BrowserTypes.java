package framework.constants;

public enum BrowserTypes {

    CHROME("chrome"),
    EDGE("edge"),
    FIREFOX("firefox"),
    OPERA("opera");

    private String browser;

    BrowserTypes(String browser) {
        this.browser = browser;
    }

    public String getBrowser() {
        return browser;
    }
}
