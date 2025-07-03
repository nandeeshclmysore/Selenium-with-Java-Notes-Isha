package framework;

import lombok.SneakyThrows;
import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.PropertiesConfigurationLayout;

import java.io.FileInputStream;
import java.io.InputStreamReader;

public class PropertiesUtil {

    private InputStreamReader inputStreamReader;
    private PropertiesConfiguration propertiesConfiguration;
    private PropertiesConfigurationLayout propertiesConfigurationLayout;

    @SneakyThrows
    public PropertiesUtil(){
        inputStreamReader=new InputStreamReader(new FileInputStream("C:\\Users\\003J72744\\Desktop\\TestingAcademyAT\\SeleniumIsha\\JavaSeleniumNotes\\Workspace\\SeleniumComponents\\Config.properties"));
        propertiesConfiguration=new PropertiesConfiguration();
        propertiesConfigurationLayout=new PropertiesConfigurationLayout();

        propertiesConfigurationLayout.load(propertiesConfiguration,inputStreamReader);

    }

    private String getProperty(String key){
        return propertiesConfiguration.getString(key,key+" Not Found");
    }

    // ✅ Add all these public getters
    public String getURL() {
        return getProperty("URL");
    }

    public String getIncognitoMode() {
        return getProperty("incognito"); // e.g., yes or no
    }

    public String getHeadlessMode() {
        return getProperty("headless");  // e.g., yes or no
    }

    public String getBrowser() {
        return getProperty("browser");   // e.g., chrome, firefox, edge
    }

//    public String getDownloadFolder() {
//        return getProperty("download.folder");  // optional: custom folder path
//    }




}
