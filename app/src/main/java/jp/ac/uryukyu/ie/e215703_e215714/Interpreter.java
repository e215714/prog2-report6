package jp.ac.uryukyu.ie.e215703_e215714;

public class Interpreter {
    private MemArray mem;

    public Interpreter() {
        mem = new MemArray();
    }

    public void interpret(String code) {
        for (int i = 0; i < code.length(); i++) {
            char nowChar = code.charAt(i);
            if (nowChar == '+') {
                mem.increment();
            } else if (nowChar == '-') {
                mem.decrement();
            } else if (nowChar == '.') {
                System.out.print((char) mem.getValue());
            }
        }
    }
}
