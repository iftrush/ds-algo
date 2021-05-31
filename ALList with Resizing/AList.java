public class AList{
    private int[] items;
    private int size;

    public AList(){
        items = new int[100];
        size = 0;
    }

    public void addLast(int x){
        if(size == items.length){
            resize(size << 1);
        }
        items[size] = x;
        size++;
    }

    private void resize(int capacity){
        int[] a = new int[capacity];
        System.arraycopy(items, 0, a, 0, size);
        items = a;
    }
    

    public int getLast(){
        return items[size - 1];
    }

    public int get(int i){
        return items[i];
    }

    public int size(){
        return size;
    }

    public int removeLast(){
        int x = items[size - 1];
        items[size - 1] = 0;
        size--;
        return x;
    }

    public static void main(String[] args){
        AList lst = new AList();
        for(int i = 1; i <= 100; i++){
            lst.addLast(i);
        }
        System.out.println(lst.getLast());
        lst.addLast(101);
        System.out.println(lst.getLast());
    }
}