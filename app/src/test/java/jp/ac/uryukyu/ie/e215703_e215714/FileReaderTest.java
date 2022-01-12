package jp.ac.uryukyu.ie.e215703_e215714;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

public class FileReaderTest {
    @Test
    void fileReaderTest() { //読み込んだファイルが1行のStringになっているか
        try {
            String fileName = getClass().getClassLoader().getResource("HelloWorld.bf").getFile();
            String answerFile = getClass().getClassLoader().getResource("HelloWorldOneLine").getFile();
            Path file = Paths.get(answerFile);
            String answer = Files.readString(file);
            String after = FileReader.toOneLine(fileName);
            assertEquals(answer, after);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
