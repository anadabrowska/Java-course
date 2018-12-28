package tools;
/**
 * klasa oblicza minimum z dwóch liczb
 */
public class Min extends Function {
    public Min(){
        super(2);
    }
    @Override
    public double calculate() throws ExceptionONP {
        double result;
        if(missingArg() == 0) {
            result = Math.min(args.get(0),args.get(1));
            return result;
        }else{
            throw new ONP_missingArg();
        }
    }
}
