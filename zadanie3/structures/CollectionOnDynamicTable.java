package structures;

/**
 * Klasa tworzy zbiór dynamiczny przechowujący pary
 */
public class CollectionOnDynamicTable extends CollectionOnTable{

    /**
     * konstruktor tworzy zbiór o pczątkowej pojemności
     */
    public CollectionOnDynamicTable(){
        super(2);
        array = new Pair[size];
    }

    public void insert (Pair p){
        for (int i=0; i < index ; i++) {
            if(array[i].equals(p))
                throw new IllegalArgumentException("This key already exists!");
        }

        if(index == size){
            size *= 2;
            Pair[] newArray = new Pair[size];
            System.arraycopy(array, 0, newArray, 0, size/2);
            array = newArray;
        }
        array[index] = p;
        index++;

    }
}