package calculations;

/**
 * abstrakcyjna klasa służąca budowaniu wyrażeń
 */
public abstract class Expression implements Calculable {

    protected static final double sumInit = 0;
    protected static final double sroductInit = 1;

    /** metoda sumująca wyrażenia */
    public static double sum (Expression... expr) {
        double result = sumInit;
        for(int i = 0; i < expr.length; i++){
            result += expr[i].calculate();
        }
        return result;
    }

    /** metoda mnożąca wyrażenia */
    public static double product (Expression... expr) {
        double result = sroductInit;
        for(int i = 0; i < expr.length; i++){
            result *= expr[i].calculate();
        }
        return result;
    }
}
