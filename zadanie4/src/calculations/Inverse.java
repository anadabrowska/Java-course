package calculations;

/**
 * klasa oblicza odwrotność wyrażenia
 */
public class Inverse extends UnaryArg {
    /**
     * konstruktor klasy Inverse
     * @param left
     */
    public Inverse(Expression left){
        super(left);
    }


    @Override
    public double calculate() {
        return 1/ left.calculate();
    }

    public String toString(){
        return "1 / "+left.toString();
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
