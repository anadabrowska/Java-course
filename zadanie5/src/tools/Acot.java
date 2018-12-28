package tools;
/**
 * klasa oblicza arcus cotangens liczby
 */

public class Acot extends Function {
    public Acot(){
        super(1);
    }

    @Override
    public double calculate() throws ExceptionONP {

        if(missingArg() == 0) {
            return (Math.PI/2.0)-Math.atan(args.get(0));
        }else{
            throw new ONP_missingArg();
        }
    }
}
