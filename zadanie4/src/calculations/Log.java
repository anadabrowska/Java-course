package calculations;

/**
 * klasa oblicza logarytm z wyrażenia przy podanej bazie
 */
public class Log extends BinaryArg {
    /**
     * konstruktor klasy Log
     * @param left
     * @param right
     */
    public Log(Expression left, Expression right){
        super(left, right);
    }

    @Override
    public double calculate() {
        return Math.log(left.calculate())/Math.log(right.calculate());
    }

    public String toString(){
        return"Log("+left.toString()+","+right.toString()+")";
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
