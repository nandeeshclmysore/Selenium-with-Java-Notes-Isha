package framework;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.util.HashMap;
import java.util.Map;

public class OptionsManager {

    private final PropertiesUtil prop = new PropertiesUtil();

    // ✅ Chrome Options
    public ChromeOptions getChromeOptions() {
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");

        // Disable "Chrome is being controlled" message
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.setExperimentalOption("useAutomationExtension", false);

        // Preferences
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.default_directory", PathUtils.getDownloadFolder()); // custom folder from config
        prefs.put("download.prompt_for_download", false);
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);

        // Handle incognito and headless mode
        if (prop.getIncognitoMode().equalsIgnoreCase("yes")) {
            options.addArguments("--incognito");
        }

        if (prop.getHeadlessMode().equalsIgnoreCase("yes")) {
            options.addArguments("--headless=new");
        }

        return options;
    }

    // ✅ Firefox Options
    public FirefoxOptions getFirefoxOptions() {
        FirefoxOptions options = new FirefoxOptions();

        if (prop.getIncognitoMode().equalsIgnoreCase("yes")) {
            options.addArguments("-private");
        }

        if (prop.getHeadlessMode().equalsIgnoreCase("yes")) {
            options.addArguments("-headless");
        }

        return options;
    }

    // ✅ Edge Options
    public EdgeOptions getEdgeOptions() {
        EdgeOptions options = new EdgeOptions();

        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");

        Map<String, Object> prefs = new HashMap<>();
        prefs.put("profile.default_content_settings.popups", 0);
        prefs.put("download.default_directory", PathUtils.getDownloadFolder());
        prefs.put("download.prompt_for_download", false);
        prefs.put("profile.default_content_setting_values.notifications", 2);
        options.setExperimentalOption("prefs", prefs);

        if (prop.getIncognitoMode().equalsIgnoreCase("yes")) {
            options.addArguments("--inprivate");
        }

        if (prop.getHeadlessMode().equalsIgnoreCase("yes")) {
            options.addArguments("--headless=new");
        }

        return options;
    }
}
