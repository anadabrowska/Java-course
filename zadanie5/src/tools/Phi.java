package tools;
/**
 * klasa reprezentuje stałą Phi
 */
public class Phi extends Function {
    public Phi(){
        super(0);
    }

    @Override
    public double calculate() throws ExceptionONP {
        return 1+ Math.sqrt(5.0)/2.0;
    }
}
