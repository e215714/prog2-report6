package jp.ac.uryukyu.ie.e215703_e215714;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class IgnoreCommentTest {
    @Test
    void ignoreTest() { //ignoreComment()が正しく動作しているか
        String text1 = "+ja-13<!23>?_.dfaj,da()asdk[jhfd]";
        String answer1 = "+-<>.,[]";
        String after1 = IgnoreComment.ignoreComment(text1);
        assertEquals(answer1, after1);

        String text2 = "++++++++++10回ループ[>+++++++>++++++++++>+++++++++++>+++>+++++++++>+<<<<<<-]>++.H>+.e>--.l.l+++.o>++. >---.W<<.o+++.r------.l<-.d>>+.!>>.";
        String answer2 = "++++++++++[>+++++++>++++++++++>+++++++++++>+++>+++++++++>+<<<<<<-]>++.>+.>--..+++.>++.>---.<<.+++.------.<-.>>+.>>.";
        String after2 = IgnoreComment.ignoreComment(text2);
        assertEquals(answer2, after2);
    }
}
