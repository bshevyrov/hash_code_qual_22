package ua.com.hashcode.sancho;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class OutputFromAss {

    public static void out(List<String> result, Path path) {

        if (Files.exists(path)) {
            try {
                Files.delete(path);
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                Files.createFile(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try {
            for (String s : result) {

                s+=" ";
                Files.write(path, s.getBytes(), StandardOpenOption.APPEND);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
