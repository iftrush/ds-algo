public class AList<T>{
    private T[] items;
    private int size;

    public AList(){
        //Java does not allow us to create an array of generic objects due to an obscure issue with the way generics are implemented
        items = (T[]) new Object[100]; // instantiate an array of Object with size 100 and cast it with (T[]) 
        size = 0;
    }

    public void addLast(T x){
        if(size == items.length){
            resize(size << 1);
        }
        items[size] = x;
        size++;
    }

    private void resize(int capacity){
        T[] a = (T[]) new Object[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }
    

    public T getLast(){
        return items[size - 1];
    }

    public T get(int i){
        return items[i];
    }

    public int size(){
        return size;
    }

    public T removeLast(){
        T x = items[size - 1];
        items[size - 1] = null; //avoid "loitering": If we fail to null out the reference, then Java will not garbage collect the objects that have been added to the list
        size--;
        return x;
    }

    public static void main(String[] args){
        AList<Integer> lst = new AList<>();
        for(int i = 1; i <= 100; i++){
            lst.addLast(i);
        }
        System.out.println(lst.getLast());
        lst.addLast(101);
        System.out.println(lst.getLast());
    }
}