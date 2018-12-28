package calculations;

/**
 * klasa oblicza cosinus wyrażenia
 */
public class Cos extends UnaryArg {
    /**
     * konstruktor klasy Cos
     * @param left lwew podwyrażenie
     */
    public Cos(Expression left){
        super(left);
    }

    @Override
    public double calculate() {
        return Math.cos(left.calculate());
    }

    public String toString(){
        return "Cos(" + left.toString() + ")";
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
