package jp.ac.uryukyu.ie.e215703_e215714;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 便利メソッド集
 * toOneLine - ファイルを読み込んで1行のStringにするメソッド
 * ignoreComment - コメントを削除するメソッド
 */
public class Utilities {
    /**
     * ファイルを読み込んで1行のStringにするメソッド
     * 
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

    /**
     * 与えられた文字列から+-&lt;&gt;.,[]以外の文字を削除するメソッド
     * 
     * @param text ありとあらゆる文字列
     * @return +-&lt;&gt;.,[]のみの文字列
     */
    public static String ignoreComment(String text) {
        return text.replaceAll("[^\\+\\-\\<\\>\\.\\,\\[\\]]+", "");
    }
}
