package framework;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.stream.Collectors;


public class FileUtils {

    @SneakyThrows
    public void writeDataToFile(String filePath, String data) {
        File file = new File(filePath);
        FileWriter fileWriter = new FileWriter(filePath, file.exists());

        fileWriter.write(data);
        fileWriter.close();

    }

    @SneakyThrows
    public String readDataFromFile(String filePath) {

        FileReader fileReader=new FileReader(filePath);
        BufferedReader bufferedReader=new BufferedReader(fileReader);

        return bufferedReader.lines().collect(Collectors.joining("\n"));

    }
}
