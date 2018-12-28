package tools;
/**
 * klasa oblicza logarytm z liczby przy podanej bazie
 */
public class Log extends Function {
    public Log(){
        super(2);
    }

    @Override
    public double calculate() throws ExceptionONP {
        double result;
        if(missingArg() == 0) {
            result =  Math.log(args.get(0))/Math.log(args.get(1));
            return result;
        }else{
            throw new ONP_missingArg();
        }
    }
}
