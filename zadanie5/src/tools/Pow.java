package tools;
/**
 * klasa podnosi liczbę do podanej potęgi
 */
public class Pow extends Function {
    public Pow(){
        super(2);
    }

    @Override
    public double calculate() throws ExceptionONP {
        double result;
        if(missingArg() == 0) {
            result =  Math.pow(args.get(0),args.get(1));
            return result;
        }else{
            throw new ONP_missingArg();
        }
    }
}
