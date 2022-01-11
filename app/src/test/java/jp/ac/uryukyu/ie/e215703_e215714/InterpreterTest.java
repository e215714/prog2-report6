package jp.ac.uryukyu.ie.e215703_e215714;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
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

    @BeforeEach // タスクごとにoutContentをリセットする
    void resetOut() {
        outContent.reset();
    }

    @Test
    void incDecOutCheck() {
        Interpreter interpreter = new Interpreter();
        String code = "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++.---.+++++++..+++.";
        String ans = "HELLO";
        interpreter.interpret(code); // インタプリタにコードを渡して標準出力する
        assertEquals(ans, outContent.toString()); // ここで確認
    }

    @Test
    void shiftCheck() {
        Interpreter interpreter = new Interpreter();
        String code = "+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++.+.+.>++++++++++.";
        String ans = "ABC\n";
        interpreter.interpret(code);
        assertEquals(ans, outContent.toString());
    }

    @Test
    void inputCheck() {
        System.setIn(new ByteArrayInputStream("abc\n".getBytes())); // "abc"を標準入力に流すため
        Interpreter interpreter = new Interpreter();
        interpreter.interpret(","); // ","を与えて"abc"を流し込む
        System.setIn(System.in); // 標準入力をもとに戻す
        assertEquals("\ninput> ", outContent.toString()); // プロンプトの表示確認
        outContent.reset(); // 一旦リセット
        interpreter.interpret("."); // 読み込んだ内容を出力する
        assertEquals("a", outContent.toString()); // "abc"の最初の1byteで"a"
    }

    @Test
    void loopCheck() {
        Interpreter interpreter = new Interpreter();
        String code = "++++++++++[>+++++++>++++++++++>+++++++++++>+++>+++++++++>+<<<<<<-]>++.>+.>--..+++.>++.>---.<<.+++.------.<-.>>+.>>.";
        String ans = "Hello World!\n";
        interpreter.interpret(code);
        assertEquals(ans, outContent.toString());
    }
}
