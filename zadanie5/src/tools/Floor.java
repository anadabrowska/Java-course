package tools;
/**
 * klasa oblicza podłogę z liczby
 */
public class Floor extends Function {
    public Floor(){
        super(1);
    }

    @Override
    public double calculate() throws ExceptionONP {
        double result;
        if(missingArg() == 0) {
            result =  Math.floor(args.get(0));
            return result;
        }else{
            throw new ONP_missingArg();
        }
    }
}
