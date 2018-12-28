package calculations;

/**
 * klasa dzieli dwa wyrażenia
 */
public class Div extends BinaryArg {
    /**
     * konstruktor klasy div
     * @param left  lewe podwyrażenie
     * @param right prawe podwyrażenie
     */
    public Div(Expression left, Expression right){
        super(left, right);
    }

    @Override
    public double calculate() {
        return left.calculate() / right.calculate();
    }

    public String toString(){ return "(" + left.toString() + " / " + right.toString() + ")";
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
