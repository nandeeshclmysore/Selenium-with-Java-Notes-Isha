package framework;

import lombok.AllArgsConstructor;
import lombok.SneakyThrows;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.nio.file.Files;


@AllArgsConstructor //Create constructor and Initialize all the declared class variables
public class Reports {

    private WebDriver driver = null;

    @SneakyThrows //To automatic handle all exceptions
    public String takeScreenshotMethod(String... imageName) {
        //Takes screenshot
        File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        //System.out.println("Screenshot path is: "+src.getPath());

        File dest = new File(PathUtils.getScreenshotPath(imageName));

        // Copy file from source to destination
        Files.copy(src.toPath(), dest.toPath());

        //Returns path of the screenshot
        return src.getPath();
    }

}
