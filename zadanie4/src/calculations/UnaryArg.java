package calculations;


import java.util.Objects;

/**
 * klasa abstarakcyna dla wyrażeń jednoargumentowych
 */
public abstract class UnaryArg extends Expression{
    /**
     * konstruktor klasy UnaryArg
     */
    protected final Expression left;


    protected UnaryArg(Expression left) {
        this.left = left;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnaryArg unaryArg = (UnaryArg) o;
        return Objects.equals(left, unaryArg.left);
    }

    @Override
    public int hashCode() {
        return Objects.hash(left);
    }
}
