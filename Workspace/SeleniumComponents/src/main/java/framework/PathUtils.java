package framework;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

@UtilityClass
public class PathUtils {


    @SneakyThrows //To skip explicitly throwing exception
    public void applySleep(long time) {
        Thread.sleep(time);
    }

}
