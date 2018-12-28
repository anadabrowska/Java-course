package calculations;

/**
 * klasa mnoży dwa wyrażenia
 */
public class Mult extends BinaryArg {
    /**
     * konstruktor klasy Mult
     * @param left
     * @param right
     */
    public Mult(Expression left, Expression right){
        super(left, right);
    }

    @Override
    public double calculate() {
        return left.calculate() * right.calculate();
    }

    public String toString(){
        return "(" + left.toString()+" * "+right.toString() + ")";
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
