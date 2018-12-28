package tools;
/**
 * klasa oblicza signum z liczby
 */
public class Sgn extends Function {
    public Sgn(){
        super(1);
    }

    @Override
    public double calculate() throws ExceptionONP {
        double result;
        if(missingArg() == 0) {
            result =  Math.signum(args.get(0));
            return result;
        }else{
            throw new ONP_missingArg();
        }
    }
}
