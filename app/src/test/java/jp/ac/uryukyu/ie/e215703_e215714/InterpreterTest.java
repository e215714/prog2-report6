package jp.ac.uryukyu.ie.e215703_e215714;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class InterpreterTest {
    private static final ByteArrayOutputStream outContent = new ByteArrayOutputStream(); // 標準出力受け用
    private static final PrintStream origOut = System.out; // 標準出力をもとに戻す用

    @BeforeAll // タスクを行う前に標準出力をリダイレクト
    static void setUpStream() {
        System.setOut(new PrintStream(outContent));
    }

    @AfterAll // すべてのタスクの終了後標準出力をSystem.outに戻す
    static void restoreStream() {
        System.setOut(origOut);
    }

    @Test
    void incDecOutCheck() {
        Interpreter interpreter = new Interpreter();
        String code = "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++.---.+++++++..+++.";
        String ans = "HELLO";
        interpreter.interpret(code); // インタプリタにコードを渡して標準出力する
        assertEquals(ans, outContent.toString()); // ここで確認
    }
}
