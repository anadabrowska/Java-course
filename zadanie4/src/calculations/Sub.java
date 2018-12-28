package calculations;

/**
 * klasa odejmuje od siebie dwa wyrażenia
 */
public class Sub extends BinaryArg {
    /**
     * konstruktor klasy Sub
     * @param left lewe podwyrażenie
     * @param right prawe podwyrażenie
     */
    public Sub(Expression left, Expression right){
        super(left, right);
    }

    @Override
    public double calculate() {
        return left.calculate() - right.calculate();
    }
    public String toString(){
        return "(" + left.toString()+" - "+right.toString() + ")";
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
