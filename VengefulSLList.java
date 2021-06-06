public class VengefulSLList<T> extends SLList<T> {

    SLList<T> deletedItems;

    public VengefulSLList(){
        super(); // Java will automatically make a call to the superclass's no-argument constructor for us if we don't create it by ourself
        deletedItems = new SLList<>();
    }

    public VengefulSLList(T x){
        super(x); // we must make an explicit call to the correct constructor by passing in the item as a parameter to super
        deletedItems = new SLList<>();
    }

    public void printLostItems(){
        deletedItems.print();
    }

    @Override
    public T removeLast(){
        T x = super.removeLast();
        deletedItems.addLast(x);
        return x;
    }

    public static void main(String[] args){
        VengefulSLList<Integer> L = new VengefulSLList<>();
        L.addLast(1);
        L.addLast(2);
        L.addLast(3);
        System.out.println(L);
        L.removeLast();
        L.removeLast();
        System.out.println(L);
        L.printLostItems();
    }
}
