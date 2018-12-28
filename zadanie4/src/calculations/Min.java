package calculations;

/**
 * klasa oblicza minimum z dwóch wyrażeń
 */
public class Min extends BinaryArg {
    /**
     * Konstruktor klasy Min
     * @param left
     * @param right
     */
    public Min(Expression left, Expression right){
        super(left, right);
    }

    @Override
    public double calculate() {
        return Math.min(left.calculate(),right.calculate());
    }

    public String toString(){
        return "Min("+left.toString()+","+right.toString()+")";
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
