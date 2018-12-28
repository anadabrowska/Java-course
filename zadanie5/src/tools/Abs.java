package tools;
/**
 * klasa oblicza wartość bezwzględną liczby
 */
public class Abs extends Function {
    public Abs(){
        super(1);
    }

    @Override
    public double calculate() throws ExceptionONP {
        double result;
        if(missingArg() == 0) {
            result =  Math.abs(args.get(0));
            return result;
        }else{
            throw new ONP_missingArg();
        }
    }
}
