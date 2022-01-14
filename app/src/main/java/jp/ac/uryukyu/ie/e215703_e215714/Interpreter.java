package jp.ac.uryukyu.ie.e215703_e215714;

import java.util.Scanner;

/**
 * Brainfuckのインタプリタクラス
 *  MemArray mem 疑似メモリインスタンス
 *  Scanner scanner 標準入力受付用
 * @author Taiga Ogawa
 */
public class Interpreter {
    private MemArray mem;
    private Scanner scanner;

    /**
     * コンストラクタ
     * MemArrayインスタンスを用意
     * 入力受付用のScannerを用意
     */
    public Interpreter() {
        mem = new MemArray();
        scanner = new Scanner(System.in);
    }

    /**
     * コンストラクタ
     * 入力受付用のScannerを用意
     * @param _mem 使用したいメモリ配列
     */
    public Interpreter(MemArray _mem){
        mem = _mem;
        scanner = new Scanner(System.in);
    }

    /**
     * インタプリタメソッド <br>
     * <code>+</code> ポインタが指す値をインクリメント <br>
     * <code>-</code> ポインタが指す値をデクリメント <br>
     * <code>&gt;</code> ポインタをインクリメント <br>
     * <code>&lt;</code> ポインタをデクリメント <br>
     * <code>.</code> ポインタが指す値を標準入力へ <br>
     * <code>,</code> 入力から1byte読み込んでポインタが指す先へ代入 <br>
     * <code>[</code> ポインタが指す値が0なら，対応する<code>]</code>の直後のジャンプ <br>
     * <code>]</code> ポインタが指す値が0でないなら，対応する<code>[</code>の直後にジャンプ <br>
     * @param code brainfuckのコード
     */
    public void interpret(String code) {
        for (int i = 0; i < code.length(); i++) {
            char nowChar = code.charAt(i);
            if (nowChar == '+') {
                mem.increment();
            } else if (nowChar == '-') {
                mem.decrement();
            } else if (nowChar == '>') {
                mem.rightShift();
            } else if (nowChar == '<') {
                mem.leftShift();
            } else if (nowChar == '.') {
                System.out.print((char) mem.getValue());
            } else if (nowChar == ',') {
                System.out.print("\ninput(Only the first character will be read.)> ");
                mem.setValue((byte) scanner.next().charAt(0));
            } else if (nowChar == '[') {
                if (mem.getValue() == 0) {
                    int nest = 0; // ネストを数える変数
                    while (true) {
                        i++;
                        if (code.charAt(i) == '[') {
                            nest++;
                        } else if (code.charAt(i) == ']') {
                            if (nest == 0) {
                                break;
                            } else {
                                nest--;
                            }
                        }
                    }
                }
            } else if (nowChar == ']') {
                if (mem.getValue() != 0) {
                    int nest = 0;
                    while (true) {
                        i--;
                        if (code.charAt(i) == '[') {
                            if (nest == 0) {
                                break;
                            } else {
                                nest--;
                            }
                        } else if (code.charAt(i) == ']') {
                            nest++;
                        }
                    }
                }
            }
        }
    }
}
