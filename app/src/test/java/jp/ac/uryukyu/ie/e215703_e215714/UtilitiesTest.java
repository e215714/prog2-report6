package jp.ac.uryukyu.ie.e215703_e215714;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.jupiter.api.Test;

public class UtilitiesTest {
    @Test
    void fileReaderTest() { // 読み込んだファイルが1行のStringになっているか
        try {
            String fileName = getClass().getClassLoader().getResource("HelloWorld.bf").getFile();
            String answerFile = getClass().getClassLoader().getResource("HelloWorldOneLine").getFile();
            Path file = Paths.get(answerFile);
            String answer = Files.readString(file);
            String after = Utilities.toOneLine(fileName);
            assertEquals(answer, after);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    void ignoreTest() { // ignoreComment()が正しく動作しているか
        String text1 = "+ja-13<!23>?_.dfaj,da()asdk[jhfd]";
        String answer1 = "+-<>.,[]";
        String after1 = Utilities.ignoreComment(text1);
        assertEquals(answer1, after1);

        String text2 = "++++++++++10回ループ[>+++++++>++++++++++>+++++++++++>+++>+++++++++>+<<<<<<-]>++.H>+.e>--.l.l+++.o>++. >---.W<<.o+++.r------.l<-.d>>+.!>>.";
        String answer2 = "++++++++++[>+++++++>++++++++++>+++++++++++>+++>+++++++++>+<<<<<<-]>++.>+.>--..+++.>++.>---.<<.+++.------.<-.>>+.>>.";
        String after2 = Utilities.ignoreComment(text2);
        assertEquals(answer2, after2);
    }
}
