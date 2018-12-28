package tools;
/**
 * klasa oblicza logarytm naturalny z liczby
 */
public class Ln extends Function {
    public Ln(){
        super(1);
    }

    @Override
    public double calculate() throws ExceptionONP {

        if(missingArg() == 0) {
            return Math.log(args.get(0));
        }else{
            throw new ONP_missingArg();
        }
    }
}