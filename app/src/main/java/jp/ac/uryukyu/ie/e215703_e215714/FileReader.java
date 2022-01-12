package jp.ac.uryukyu.ie.e215703_e215714;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * ファイルを読み込むクラス
 * @author Taisei Maetake
 */
public class FileReader {

    /**
     * ファイルを読み込んで1行のStringにするメソッド
     * @param path ファイルパス
     * @return 1行のString
     */
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
