package calculations;

import java.util.Objects;

/**
 * klasa obsługuje liczby
 */
public class Num  extends Expression{
    private final double value;

    /**
     * konstruktor klasy Num
     * @param value
     */
    public Num(double value){
        this.value = value;
    }

    @Override
    public double calculate() {
        return value;
    }

    public String toString(){
        return String.valueOf(value);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Num num = (Num) o;
        return Double.compare(num.value, value) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
