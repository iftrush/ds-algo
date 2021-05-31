public class SLList {
    public static class IntNode{
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n){
            item = i;
            next = n;
        }
    }
    private IntNode sentinel; //The sentinel node will hold a value, which we won't care about.
    private int size;

    /** A SLList with a sentinel node has at least the following invariants:
     * The sentinel reference always points to a sentinel node.
     * The front item (if it exists), is always at sentinel.next.item
     * The size variable is always the total number of items that have been added.
     */

    //empty list
    public SLList(){
        sentinel = new IntNode(777, null);
        size = 0;
    }

    public SLList(int x){
        sentinel = new IntNode(777, null);
        sentinel.next = new IntNode(x, null);
        size = 1;
    }

    public void addFirst(int x){
        size++;
        sentinel.next = new IntNode(x, sentinel.next);
    }

    public int getFirst(){
        return sentinel.next.item;
    }

    public int size(){
        return size;
    }

    public void addLast(int x){
        size++;
        IntNode p = sentinel;
        while(p.next != null){
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }
    
    public int getLast(){
        IntNode p = sentinel;
        while(p.next != null){
            p = p.next;
        }
        return p.item;
    }
    
    public static void main(String[] args){
        SLList L = new SLList();
        L.addLast(1);
        L.addLast(2);
        L.addLast(3);
        System.out.println(L.size());
        System.out.println(L.getFirst());
        System.out.println(L.getLast());
    }
}
