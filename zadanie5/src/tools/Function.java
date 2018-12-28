package tools;

import java.util.ArrayList;
import java.util.List;
/**
 * klasa abstrakcujna reprezentuje funkcję
 */
public abstract class Function extends Symbol implements Functional {
    protected List<Double> args;
    private int argCount;

    protected Function(int argc){
        args = new ArrayList<>();
        argCount = argc;
    }

    @Override
    public int argNum() {
        return argCount;
    }
    @Override
    public int missingArg() {
        return argNum() - args.size();
    }

    @Override
    public void addArg(double arg) throws ExceptionONP
    {
        if(missingArg() > 0){
            args.add(arg);
        }
        else{
            throw new ONP_argExcepiton();
        }

    }

}
