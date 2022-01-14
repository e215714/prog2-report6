import jp.ac.uryukyu.ie.e215703_e215714.*;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            Interact interact = new Interact();
            interact.start();
        } else if (args[0].equals("-h") || args[0].equals("--help")) {
            System.out.println("usage: [-h | filename]\n-h : print this help message and exit (also --help)\nIf no args, you can enter the Interactive mode.\n");
        } else {
            String code = Utilities.toOneLine(args[0]);
            code = Utilities.ignoreComment(code);
            var interpreter = new Interpreter();
            interpreter.interpret(code);
        }
    }
}
