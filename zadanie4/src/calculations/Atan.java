package calculations;

/**
 * klasa oblicza arcus tangens wyrażenia
 */
public class Atan extends UnaryArg {
    /**
     * konstruktor klasy Atan
     * @param left lewe podwyrażenie
     */
    public Atan(Expression left){
        super(left);
    }

    @Override
    public double calculate() {
        return Math.atan(left.calculate());
    }

    public String toString(){
        return "Atan(" + left.toString() + ")";
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
