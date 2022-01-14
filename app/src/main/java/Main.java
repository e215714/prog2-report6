import jp.ac.uryukyu.ie.e215703_e215714.*;

public class Main {
    public static void main(String[] args) {
        if (args.length == 0) {
            Interact interact = new Interact();
            interact.start();
        } else {
            String code = Utilities.toOneLine(args[0]);
            code = Utilities.ignoreComment(code);
            var interpreter = new Interpreter();
            interpreter.interpret(code);
        }
    }
}
