package structures;

 /**
 * Klasa tworzy zbiór statyczny przechowujący pary.
 */
public class CollectionOnTable extends Collection{ 
    private final static int minSize = 2;

    /**
     * konstruktos tworzy zbiór o zadanej pojemności
     */
    public CollectionOnTable(int size){
        if(size < minSize)
            throw new IllegalArgumentException("Minimum size is 2!");
        
        array = new Pair[size];
        this.size = size;
        index = 0;
    }

    public Pair search(String k) {
        for(int i=0; i < index; i++){
            if(k.equals(array[i].key))
                return array[i];
        }
        throw new IllegalArgumentException("No pair with that key!");
    }

    public void insert (Pair p){
        for (int i=0; i < index; i++) {
            if(array[i].equals(p))
                throw new IllegalArgumentException("This key already exists!");
        }
        
        if(index == size)
            throw new IllegalArgumentException("Not enough place in array!");

        array[index] = p;
        index++;
    }

    public double read (String k){
        for (int i=0; i < index; i++) {
            if(k.equals(array[i].key))
                return array[i].getValue();
        }
        throw new IllegalArgumentException("No pair with that key!");
    }

    public  void set (Pair p){
        boolean changed=true;
        for (int i=0; i < index ; i++){
            if(array[i].equals(p)){
                array[i].setValue(p.getValue());
                changed = false;
            }
        }
        if (changed)
            insert(p);
    }

    public void clear (){
        array = new Pair[size];
        index = 0;
    }

    public int howMany(){
        return index;
    }

}