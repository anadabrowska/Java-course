package tools;

/**
 * klasa przypisuje wyrażenie do zmiennej
 */

public class Assign extends Function {

    private String var_name;

    protected Assign(String var_name) {
        super(1);
        this.var_name = var_name;
    }

    @Override
    public double calculate() throws ExceptionONP {
        Variable.set(var_name, args.get(0));
        return args.get(0);
    }
}
