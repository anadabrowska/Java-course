package tools;

import java.util.Stack;
/**
 * klasa dodaje do siebie dwie liczby
 */

public class Add extends Function {
    //private Stack<Double> args = new Stack<Double>();

    public Add(){
        super(2);
    }

    @Override
    public double calculate() throws ExceptionONP
    {
        double result;
        if(missingArg() == 0) {
            result = args.get(0) + args.get(1);
            return result;
        }else{
            throw new ONP_missingArg();
        }
    }
}
