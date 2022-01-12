package jp.ac.uryukyu.ie.e215703_e215714;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileReader {
    public static String toOneLine(String path) {
        Path file = Paths.get(path);
        String result = "";
        try (
                BufferedReader br = Files.newBufferedReader(file)) {
            String text;

            while ((text = br.readLine()) != null) {
                result += text;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
