package tools;
/**
 * klasa reprezentuje funkcję eksponującą
 */
public class Exp extends Function {
    public Exp(){
        super(1);
    }

    @Override
    public double calculate() throws ExceptionONP {

        if(missingArg() == 0) {
            return Math.exp(args.get(0));
        }else{
            throw new ONP_missingArg();
        }
    }
}
