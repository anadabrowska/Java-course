package tools;
/**
 * klasa oblicza cosinus liczby
 */
public class Cos extends Function {
    public Cos(){
        super(1);
    }

    @Override
    public double calculate() throws ExceptionONP {
        if(missingArg() == 0) {
            return Math.cos(args.get(0));
        }else{
            throw new ONP_missingArg();
        }
    }
}
