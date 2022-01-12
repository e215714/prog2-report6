import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MainTest {
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
    void fileInterpret() { //コマンドラインからファイルを読み込み、出力結果をテスト
        String fileName = getClass().getClassLoader().getResource("HelloWorld.bf").getFile();
        String[] args = { fileName };
        try {
            Main.main(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertEquals("Hello World!\n", outContent.toString());
    }
}
