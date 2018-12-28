package tools;
/**
 * klasa reprezentuje wyrażenie w postaci ONP
 */
public class Expression implements Calculable {


    private Queue queue;
    // kolejka symboli wyrażenia ONP (elementy typu Symbol)

    private Stack stack;
    // stos z wynikami pośrednimi obliczeń (elementy typu Double)

    private Collection list;
    // lista zmiennych czyli pary klucz-wartość (String-Double)
    public Expression (String onp, Collection zm) throws ExceptionONP {
        queue = new Queue();
        stack = new Stack();
        list = new Collection();
        String[] splited = onp.split("\\s+");
        for (String elem: splited){
            if(elem.equals("+")){
                queue.add(new Add());
            }
            else if(elem.equals("-")){
                queue.add(new Sub());
            }
            else if(elem.equals("*")){
                queue.add(new Mult());
            }
            else if(elem.equals("/")){
                queue.add(new Div());
            }
            else if(elem.equals("min")){
                queue.add(new Min());
            }
            else if(elem.equals("max")){
                queue.add(new Max());
            }
            else if(elem.equals("log")){
                queue.add(new Log());
            }
            else if(elem.equals("pow")){
                queue.add(new Pow());
            }
            else if(elem.equals("abs")){
                queue.add(new Abs());
            }
            else if(elem.equals("sgn")){
                queue.add(new Sgn());
            }
            else if(elem.equals("floor")){
                queue.add(new Floor());
            }
            else if(elem.equals("frac")){
                queue.add(new Frac());
            }
            else if(elem.equals("sin")){
                queue.add(new Sin());
            }
            else if(elem.equals("cos")){
                queue.add(new Cos());
            }
            else if(elem.equals("atan")){
                queue.add(new Atan());
            }
            else if(elem.equals("acot")){
                queue.add(new Acot());
            }
            else if(elem.equals("ln")){
                queue.add(new Ln());
            }
            else if(elem.equals("exp")){
                queue.add(new Exp());
            }
            else if(elem.equals("e")){
                queue.add(new E());
            }
            else if(elem.equals("pi")){
                queue.add(new Pi());
            }
            else if(elem.equals("phi")){
                queue.add(new Phi());
            }
            else if(elem.equals("=")){
                queue.add(new Assign(((Variable)stack.removeLast()).getKey()));
            }
            else{
                try {
                    stack.add(new Number(Double.parseDouble(elem)));
                }catch(Exception e){
                    stack.add(new Variable(elem));
                }
            }
        }
    }

    @Override
    public double calculate() throws ExceptionONP {
        //Symbol symbol;
        Function fun;
        while (!queue.isEmpty()) {
            fun = (Function) queue.removeFirst();
            while (fun.missingArg() > 0) {
                fun.addArg(stack.pop().calculate());
            }
            double result = 0;
            try {
                result = fun.calculate();
            } catch (ExceptionONP exceptionONP) {
                exceptionONP.printStackTrace();
            }
            stack.push(new Number(result));
        }
        return stack.pop().calculate();
    }
}
