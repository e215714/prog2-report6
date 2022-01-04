package jp.ac.uryukyu.ie.e215703_e215714;

/**
 * 与えられた文字列から不要な文字を削除するクラス
 * @author Taisei Maetake
 */
public class IgnoreComment {
    /**
     * 与えられた文字列から+-&lt;&gt;.,[]以外の文字を削除するメソッド
     * @param text ありとあらゆる文字列
     * @return +-&lt;&gt;.,[]のみの文字列
     */
    public static String ignoreComment(String text) {
        return text.replaceAll("[^\\+\\-\\<\\>\\.\\,\\[\\]]+", "");
    }
}
