package calculations;

/**
 * klasa oblicza sinus wyrażenia
 */
public class Sin extends UnaryArg {
    /**
     * konstruktor klasy Sin
     * @param left lewe podwyrażenie
     */
    public Sin(Expression left){
        super(left);
    }

    @Override
    public double calculate() {
        return Math.sin(left.calculate());
    }

    public String toString(){
        return "Sin("+left.toString()+")";
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
