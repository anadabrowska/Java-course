package tools;
/**
 * klasa oblicza maximum z dwóch liczb
 */
public class Max extends Function {
    public Max(){
        super(2);
    }
    @Override
    public double calculate() throws ExceptionONP {
        double result;
        if(missingArg() == 0) {
            result = Math.max(args.get(0),args.get(1));
            return result;
        }else{
            throw new ONP_missingArg();
        }
    }
}