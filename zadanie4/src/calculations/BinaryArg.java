package calculations;


import java.util.Objects;

/**
 * klasa abstarakcyna dla wyrażeń dwuargumentowych
 */
public abstract class BinaryArg extends UnaryArg {

    protected final Expression right;

    /**
     * konstruktor klasy BianryArg
     * @param left lewe podwyrażenie
     * @param right prawe podwyrażenie
     */
    protected BinaryArg(Expression left, Expression right){
        super(left);
        this.right = right;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        BinaryArg binaryArg = (BinaryArg) o;
        return (Objects.equals(right, binaryArg.right) && Objects.equals(left,binaryArg.left));
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), right);
    }
}
