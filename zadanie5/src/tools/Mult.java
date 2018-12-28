package tools;
/**
 * klasa mnoży dwie liczby
 */
public class Mult extends Function {

    public Mult(){
        super(2);
    }

    @Override
    public double calculate() throws ExceptionONP {
        double result;
        if(missingArg() == 0) {
            result = args.get(0) * args.get(1);
            return result;
        }else{
            throw new ONP_missingArg();
        }
    }
}
