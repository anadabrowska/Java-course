package tools;
/**
 * klasa obliczba częśc ułamkową z liczby
 */
public class Frac extends Function {
    public Frac(){
        super(1);
    }

    @Override
    public double calculate() throws ExceptionONP {
        if(missingArg() == 0) {
            int iPart = args.get(0).intValue();
            double fPart = args.get(0) - iPart;
            return fPart;
        }else{
            throw new ONP_missingArg();
        }
    }
}