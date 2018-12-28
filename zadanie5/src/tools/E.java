package tools;
/**
 * klasa reprezentuje stałą E
 */
public class E extends Function{

    protected E() {
        super(0);
    }

    @Override
    public double calculate() throws ExceptionONP {
        return Math.E;
    }
}
