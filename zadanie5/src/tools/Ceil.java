package tools;
/**
 * klasa oblicza sufit z liczby
 */

public class Ceil extends Function {
    public Ceil(){
        super(1);
    }

    @Override
    public double calculate() throws ExceptionONP {
        double result;
        if(missingArg() == 0) {
            result =  Math.ceil(args.get(0));
            return result;
        }else{
            throw new ONP_missingArg();
        }
    }
}
