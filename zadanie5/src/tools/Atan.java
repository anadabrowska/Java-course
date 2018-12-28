package tools;
/**
 * klasa oblicza argus tangens liczby
 */

public class Atan extends Function {
    public Atan(){
        super(1);
    }

    @Override
    public double calculate() throws ExceptionONP {
        if(missingArg() == 0) {
            return  Math.atan(args.get(0));
        }else{
            throw new ONP_missingArg();
        }
    }
}
