package calculations;

/**
 * klasa dodaje do siebie dwa wyrażenia
 */

public class Add extends BinaryArg {
    /**
     * konstruktor klasy Add
     * @param left lewe podwyrażenie
     * @param right prawe podwyrażenie
     */
    public Add(Expression left, Expression right){
        super(left,right);
    }

    @Override
    public double calculate() {
        return left.calculate() + right.calculate();
    }

    @Override
    public String toString(){
        return "(" + left.toString() + " + " + right.toString() + ")";
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
