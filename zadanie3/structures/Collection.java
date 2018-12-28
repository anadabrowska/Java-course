package structures;

public abstract class Collection{

        protected int size,index;
        protected Pair[] array;
        /** metoda ma szukać pary z określonym kluczem
         * @param k klucz według którego szukamy pary
         * @return Pair - szukana para
        */
        public abstract Pair search (String k) throws Exception;
        /** metoda ma wstawiać do zbioru nową parę 
         * @param p para do wstawienia
        */
        public abstract void insert (Pair p) throws Exception;
        /** metoda ma odszukać parę i zwrócić wartość związaną z kluczem 
         * @param k klucz do którego wartości szukamy
         * @return double - wartość
        */
        public abstract double read (String k) throws Exception;
        /** metoda ma wstawić do zbioru nową albo zaktualizować parę 
         * @param p para do aktualizacji
        */
        public abstract void set (Pair p) throws Exception;
        /** metoda ma usunąć wszystkie pary ze zbioru*/
        public abstract void clear ();
        /** metoda ma podać ile par jest przechowywanych w zbiorze 
         * @return int - ilość elementów
        */
        public abstract int howMany ();
}