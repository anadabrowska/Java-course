package calculations;

/**
 * klasa podnosi wyrażenie do podanej potęgi
 */
public class Pow extends BinaryArg {
    /**
     * konstruktor klasy Pow
     * @param left lewe podwyrażenie
     * @param right prawe podwyrażenie
     */
    public Pow(Expression left, Expression right){
        super(left,right);
    }

    @Override
    public double calculate() {
        return Math.pow(left.calculate(),right.calculate());
    }

    public String toString(){
        return "Pow("+left.toString()+","+right.toString()+")";
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
