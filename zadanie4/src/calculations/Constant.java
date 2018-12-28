package calculations;

import java.util.Objects;

/**
 * klasa obsługująca stałe matematyczne
 */

public class Constant extends Expression {

    public static final Num CONS_PI = new Num(Math.PI);
    public static final Num CONS_E = new Num(Math.E);
    public static final Num CONS_FI = new Num(1+ Math.sqrt(5.0)/2.0);

    public final String name;

    /**
     * konstruktor klasy Constant
     * @param name nazwa stałej
     */
    public Constant(String name){
        if(name.equals("CONS_PI") || name.equals("CONS_E") || name.equals("CONS_FI")) {
            this.name = name;
        }else{
            throw new IllegalArgumentException("Such constant does not exist!");
        }

    }

    @Override
    public double calculate() {
        if(name.equals("CONS_PI")){
            return CONS_PI.calculate();
        }
        else if(name.equals("CONS_E")){
            return CONS_E.calculate();
        }
        else if(name.equals("CONS_FI")){
            return CONS_FI.calculate();
        }
        return 0;
    }

    public String toString(){
        return name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Constant constant = (Constant) o;
        return Objects.equals(name, constant.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
