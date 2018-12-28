package tools;
/**
 * klasa oblicza sinus liczby
 */
public class Sin extends Function {
    public Sin(){
        super(1);
    }

    @Override
    public double calculate() throws ExceptionONP {
        if(missingArg() == 0) {
            return Math.sin(args.get(0));
        }else{
            throw new ONP_missingArg();
        }
    }
}
