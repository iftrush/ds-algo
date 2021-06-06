import java.util.Iterator;

public class ArraySet<T> implements Iterable<T>{

    private T[] items;
    private int size;

    public ArraySet() {
        items = (T[]) new Object[100];
        size = 0;
    }

    /* Returns true if this map contains a mapping for the specified key.
     */
    public boolean contains(T x) {
        for(int i = 0; i < size; i++){
            if(items[i].equals(x)){ //If the value at items[i] is null, then we are calling null.equals(x) -> NullPointerException
                return true;
            }
        }
        return false;
    }

    /* Associates the specified value with the specified key in this map. 
       Throws an IllegalArgumentException if the key is null. */
    public void add(T x) {
        if(x == null){
            return;
            //throw new IllegalArgumentException("cannot add null"); // the program will crash if throwing new exception
        }
        if(contains(x)){
            return;
        }
        items[size] = x;
        size++;
    }

    /* Returns the number of key-value mappings in this map. */
    public int size() {
        return size;
    }

    public Iterator<T> iterator(){
        return new ArraySetIterator();
    }

    private class ArraySetIterator implements Iterator<T>{
        private int pos;
        public ArraySetIterator(){
            pos = 0;
        }
        public boolean hasNext(){
            return pos < size;
        }
        public T next(){
            T returnItem = items[pos];
            pos++;
            return returnItem;
        }
    }

    @Override
    public String toString(){
        /**
         * This is incredibly inefficient because creating a new string object takes time too! 
         * Specifically, linear in the length of the string.
         */
        // String ret = "{";
        // for(int i = 0; i < size - 1; i++){
        //     ret += items[i] + ", ";
        // }
        // return ret + items[size - 1] + "}";
        StringBuilder sb = new StringBuilder("{");
        for(int i = 0; i < size - 1; i++){
            sb.append(items[i]);
            sb.append(", ");
        }
        sb.append(items[size - 1]);
        sb.append("}");
        return sb.toString();
    }

    @Override
    public boolean equals(Object other){
        /**
         * 1. equals must be an equivalence relation(reflexive, symmetric, transitive)
         * 2. It must take an Object argument, in order to override the original .equals() method
         * 3. It must be consistent if x.equals(y), then as long as x and y remain unchanged: x must continue to equal y
         * 4. It is never true for null x.equals(null) must be false
         */
        if(this == other){
            return true;
        }
        if(other == null){
            return false;
        }
        if(other.getClass() != this.getClass()){
            return false;
        }
        ArraySet<T> o = (ArraySet<T>) other;
        if(o.size() != this.size()){
            return false;
        }
        for(T item : this){
            if(!o.contains(item)){
                return false;
            }
        }
        return true;
    }

    public static <K> ArraySet<K> of(K... stuffs){
        ArraySet<K> rSet = new ArraySet<>();
        for(K x : stuffs){
            rSet.add(x);
        }
        return rSet;
    }


    // public static void main(String[] args) {
    //     ArraySet<String> s = new ArraySet<>();
    //     s.add(null);
    //     s.add("horse");
    //     s.add("fish");
    //     s.add("house");
    //     s.add("fish");        
    //     System.out.println(s.contains("horse"));        
    //     System.out.println(s.size());      
        
    //     ArraySet<Integer> aset = new ArraySet<>();
    //     aset.add(5);
    //     aset.add(23);
    //     aset.add(42);
    //     // Iterator<Integer> iter = aset.iterator();
    //     // while(iter.hasNext()){
    //     //     System.out.println(iter.next());
    //     // }
    //     for(int x : aset){
    //         System.out.println(x);
    //     }
    //     System.out.println(aset);
    //     ArraySet<Integer> aset2 = ArraySet.of(42, 23, 5);

    //     System.out.println(aset.equals(aset2));
    // }

}