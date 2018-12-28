package tools;
/**
 * klasa reprezentuje stałą Pi
 */
public class Pi extends Function{
    public Pi(){
        super(0);
    }

    @Override
    public double calculate() throws ExceptionONP {
        return Math.PI;
    }
}
