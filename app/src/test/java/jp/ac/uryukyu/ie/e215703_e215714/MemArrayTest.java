package jp.ac.uryukyu.ie.e215703_e215714;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MemArrayTest {
    @Test
    void memValueCheck() { // 正しく値の操作ができるか
        MemArray mem = new MemArray();
        int incrementCount = 5;
        for (int i=0; i<incrementCount; i++) { // 5回インクリメントさせてメモリの状態が5と一致するか
            mem.increment();
        }
        assertEquals(incrementCount, mem.getValue());

        mem.decrement(); // 1回デクリメントしてメモリの状態が5-1と一致するか
        assertEquals(incrementCount-1, mem.getValue());
    }

    @Test
    void memPtrCheck() { // 正しくポインタの操作ができるか
        MemArray mem = new MemArray();
        mem.increment(); // メモリ0番地を1にする
        mem.rightShift(); // ポインタをメモリ1番地へ移動
        mem.increment(); // メモリ1番地を1にする
        mem.increment(); // メモリ1番地を2にする
        mem.leftShift(); // メモリ0番地へ移動
        assertEquals(1, mem.getValue()); // 0番地が1と一致するか
        mem.rightShift(); // メモリ1番地へ移動
        assertEquals(2, mem.getValue()); // 1番地が2と一致するか
    }

    @Test
    void memSetCheck() { // 正しくメモリに代入できるか
        MemArray mem = new MemArray();
        char a = 'a';
        mem.setValue((byte)a);
        assertEquals((byte)a, mem.getValue());
    }
}
