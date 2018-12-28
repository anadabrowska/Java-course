package structures;

/**
 * Klasa Pair tworzy strukturę pary(String,double)
 */

public class Pair {
    public final String key;
    private double value;

    /**
     * konstruktor tworzy obiekt pary.
     * @param key klucz typu String
     * @param value wartość typu double
     */
    public Pair(String key, double value){
        if(key==null || key.equals(""))
            throw new IllegalArgumentException("Wrong key!");

        this.key = key;
        this.value = value;
    }
    /**
     * metoda zwraca wartość z pary
     * @return double - wartość z pary
     */
    public double getValue(){
        return value;
    }
    /**
     * metoda ustawia wartość w parze
     */
    public void setValue(double val){
        value= val;
    }
    /**
     * metoda konwertuje parę do stringa
     * @return String - "[key,value]"
     */
    public String toString(){
        return ("[" + key + "," + value + "]");
    }
    /**
     * metoda porównuje dwie pary na podstawie klucza
     * @param p para z którą porównujemy
     * @return boolean - czy są takie same
     */
    public boolean equals(Pair p){
        return (p.key.equals(this.key));
    }
}