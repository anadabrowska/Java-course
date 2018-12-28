package tools;
/**
 * klasa obsługuje zmienne
 */
import java.util.HashMap;

public class Variable extends Operand {
    public static final Collection variables = new Collection();
    private final String key;

    public Variable(String key) throws ExceptionONP {
        if(key.matches("\\p{Alpha}\\p{Alnum}*")) {
            this.key = key;
        }else{
            throw new ONP_variableException();
        }
    }

    public static void set(String key, Double value){
        variables.put(key,value);
    }

    public String getKey(){
        return key;
    }

    @Override
    public double calculate() throws ExceptionONP {
        if(variables.containsKey(this.key)){
            return variables.get(this.key);
        }
            throw new ONP_variableException();
        
    }
}
