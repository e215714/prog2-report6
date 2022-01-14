package jp.ac.uryukyu.ie.e215703_e215714;

/**
 * 擬似的なメモリ配列を再現するクラス
 * byte[] mem 疑似メモリ配列
 * int ptr ポインタの位置を示す変数 0-base
 * int cap メモリの容量
 * 
 * @author Taiga Ogawa
 */
public class MemArray {
    private byte[] mem;
    private int ptr;
    private int cap = 30000;

    /**
     * コンストラクタ(引数なし)
     * ptrを0で初期化
     * mem容量を30000(cap)で初期化
     */
    public MemArray() {
        ptr = 0; // 位置0で初期化
        mem = new byte[cap];
    }

    /**
     * コンストラクタ
     * ptrを0で初期化
     * 受け取った引数でメモリ容量を指定して初期化
     * 
     * @param cap 設定したいメモリ容量
     */
    public MemArray(int cap) {
        ptr = 0;
        this.cap = cap;
        mem = new byte[cap];
    }

    /**
     * ポインタの位置を右にずらす(インクリメントする)メソッド
     */
    public void rightShift() {
        ptr++;
    }

    /**
     * ポインタの位置を左にずらす(デクリメントする)メソッド
     */
    public void leftShift() {
        ptr--;
    }

    /**
     * ポインタの位置のメモリの値をインクリメントするメソッド
     */
    public void increment() {
        mem[ptr]++;
    }

    /**
     * ポインタの位置のメモリの値をデクリメントするメソッド
     */
    public void decrement() {
        mem[ptr]--;
    }

    /**
     * ポインタの位置のメモリの値を返すメソッド
     * 
     * @return ポインタの位置のメモリの値
     */
    public byte getValue() {
        return mem[ptr];
    }

    /**
     * ポインタの位置のメモリに値を設定するメソッド
     * 
     * @param b 設定したい値
     */
    public void setValue(byte b) {
        mem[ptr] = b;
    }

    /**
     * メモリの状態を初期化するメソッド
     */
    public void clear() {
        ptr = 0;
        mem = new byte[cap];
    }
}
