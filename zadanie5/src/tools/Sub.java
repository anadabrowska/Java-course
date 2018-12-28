package tools;
/**
 * klasa odejmuje od siebie dwie liczby
 */
public class Sub extends Function {
    public Sub(){
        super(2);
    }

    @Override
    public double calculate() throws ExceptionONP {
        double result;
        if(missingArg() == 0) {
            result = args.get(0) - args.get(1);
            return result;
        }else{
            throw new ExceptionONP();
        }
    }
}
