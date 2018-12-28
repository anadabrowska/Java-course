package tools;
/**
 * kinterfejs dostarczający metody:
 * arity()
 * missingArg()
 * addArg()
 */
public interface Functional extends Calculable{
    /**
     * metoda oblicza arność funkcji
     * @return int
     */
    int argNum();

    /**
     * oblicza ilość brakujących argumentów
     * @return int
     */
    int missingArg ();

    /**
     * dodaje arguemnt do funkcji
     * @param arg
     * @throws ExceptionONP
     */
    void addArg (double arg) throws ExceptionONP;
}
