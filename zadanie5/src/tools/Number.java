package tools;
/**
 * klasa obsługuje liczby
 */
public class Number extends Operand {
    private final double value;

    public Number(double value) {
        this.value = value;
    }

    @Override
    public double calculate() throws ExceptionONP {
        return value;
    }
}
