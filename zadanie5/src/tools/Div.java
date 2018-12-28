package tools;
/**
 * klasa dzieli dwie liczby
 */
public class Div extends Function {
    public Div(){
        super(2);
    }
    @Override
    public double calculate() throws ExceptionONP {
        double result;
        if(missingArg() == 0) {
            if(args.get(1) == 0){
                throw new ONP_divisionBy0();
            }
            result = args.get(0) / args.get(1);
            return result;
        }else{
            throw new ONP_missingArg();
        }
    }
}
