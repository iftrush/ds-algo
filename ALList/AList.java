public class AList{
    private int[] items;
    private int size;

    public AList(){
        items = new int[100];
        size = 0;
    }

    public void addLast(int x){
        items[size] = x;
        size++;
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

    // public static void main(String[] args){
    //     AList lst = new AList();
    //     lst.addLast(1);
    //     lst.addLast(2);
    //     lst.addLast(3);
    //     lst.addLast(4);
    //     lst.removeLast();
    //     System.out.println(lst.size());
    //     System.out.println(lst.get(0));
    //     System.out.println(lst.get(1));
    //     System.out.println(lst.get(2));
    // }
}