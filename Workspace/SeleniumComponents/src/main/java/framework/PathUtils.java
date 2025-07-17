package framework;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@UtilityClass
public class PathUtils {

    public String resultpath;

    public String generateResultFolder(){
        File file=new File(System.getProperty("user.dir")+"//Results//"+getCurrentDateTime("dd-MM-yyyy hh-mm-ss-SSS"));
        file.mkdirs();
        resultpath=file.getPath();
        return resultpath;
    }
    @SneakyThrows //To skip explicitly throwing exception
    public void applySleep(long time) {
        Thread.sleep(time);
    }

    //To generate date based on provided format
    public String getCurrentDateTime(String format) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
        Date date = new Date();
        return simpleDateFormat.format(date);
    }

    //To create folder and load screenshots
    public String getScreenshotPath(String... imgname) {
        File file = new File(System.getProperty("user.dir") + "//Screenshot" + getCurrentDateTime("dd-MM-yyyy"));
        file.mkdirs();

        if (imgname.length == 0) {
            return file.getPath() +"//"+ getCurrentDateTime("hh-mm-ss-SSS") + ".png";
        } else {
            return file.getPath() +"//"+ imgname[0] + "_" + getCurrentDateTime("hh-mm-ss-SSS") + ".png";
        }
    }

    public String getDownloadFolder(){
        return System.getProperty("user.dir")+"//Downloads";
    }

    public String getTestDataFolder(){
        return System.getProperty("user.dir")+"//src//test//resources//TestData";
    }

}
