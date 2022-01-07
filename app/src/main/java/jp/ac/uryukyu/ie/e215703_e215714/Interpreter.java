package jp.ac.uryukyu.ie.e215703_e215714;

import java.util.Scanner;

public class Interpreter {
    private MemArray mem;
    private Scanner scanner;

    public Interpreter() {
        mem = new MemArray();
        scanner = new Scanner(System.in);
    }

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
                System.out.print("\ninput> ");
                mem.setValue((byte) scanner.next().charAt(0));
            }
        }
    }
}
