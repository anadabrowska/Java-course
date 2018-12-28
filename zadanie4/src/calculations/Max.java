package calculations;

/**
 * klasa oblicza maximum z dwóch wyrażeń
 */
public class Max extends BinaryArg {
    /**
     * konstruktor klasy Max
     * @param left
     * @param right
     */
    public Max(Expression left, Expression right){
        super(left, right);
    }

    @Override
    public double calculate() {
        return Math.max(left.calculate(),right.calculate());
    }

    public String toString(){
        return "Max("+left.toString()+","+right.toString()+")";
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
