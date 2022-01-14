package jp.ac.uryukyu.ie.e215703_e215714;

import java.util.Scanner;

public class Interact {
    private Scanner scanner;
    private MemArray mem;
    private Interpreter interpreter;

    public Interact() {
        scanner = new Scanner(System.in);
        mem = new MemArray();
        interpreter = new Interpreter(mem);
    }

    public void start() {
        System.out.println("\u001b[00;36m" + "Brainfuck Interpreter\n" + "\u001b[00m"
                + "@author Taiga & Taisei\n  $bye - インタラクティブモードを終了\n  $next - メモリをクリアし、ポインタ位置を0に戻す");
        interact();
    }

    public void interact() {
        String line = "";
        String prompt = "\n>>> ";
        while (true) {
            System.out.print(prompt);
            int nest = 0;
            line += scanner.nextLine();
            if (line.equals("$bye")) {
                break;
            } else if (line.equals("$next")) {
                mem.clear();
            }
            for (int i = 0; i < line.length(); i++) {
                if (line.charAt(i) == '[') {
                    nest++;
                } else if (line.charAt(i) == ']') {
                    nest--;
                }
            }
            if (nest == 0) {
                interpreter.interpret(line);
                line = "";
                prompt = "\n>>> ";
            } else {
                prompt = "\n(" + nest + ")... ";
            }
        }
    }
}
