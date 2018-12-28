package calculations;

/**
 * klasa oblicza wartość bezwzględną wyrażenia
 */
public class Abs extends UnaryArg {

    /**
     * konstruktor klasy Abs
     * @param left lewe podwyrażenie
     */
    public Abs(Expression left) {
        super(left);
    }

    @Override
    public double calculate() {
        return Math.abs(left.calculate());
    }

    public String toString() {

        return "Abs(" + left.toString() + ")";
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
