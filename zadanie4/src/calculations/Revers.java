package calculations;

/**
 * klasa oblicza przeciwieństwo wyrażenia
 */
public class Revers extends UnaryArg {
    /**
     * konstruktor klasy Revers
     * @param left lewe podwyrażenie
     */
    public Revers(Expression left){
        super(left);
    }

    @Override
    public double calculate() {
        return -left.calculate();
    }

    public String toString(){
        return "(-"+left.toString()+")";
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
