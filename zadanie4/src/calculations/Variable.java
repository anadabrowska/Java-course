package calculations;

import java.util.HashMap;
import java.util.Objects;

/**
 * klasa obsługuje zmienne za pomocą HashMap
 */
public class Variable extends Expression {
    private static final HashMap<String,Double> variables = new HashMap<String,Double>();
    private final String key;

    /**
     * konstruktor klasy Variable
     * @param key klucz
     */
    public Variable(String key) {
        this.key = key;
    }

    /**
     * metoda ustawia wartość zmiennej o danym kluczu
     * @param key klucz
     * @param value wartość
     */
    public static void set(String key, Double value){
        variables.put(key,value);
    }

    @Override
    public double calculate() {
        if(variables.containsKey(this.key)){
            return variables.get(this.key);
        }else{
            throw new IllegalArgumentException("Variable does not exist!");
        }
    }

    public String toString(){
        return key;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Variable variable = (Variable) o;
        return Objects.equals(key, variable.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(key);
    }
}
