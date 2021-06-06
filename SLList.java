public class SLList<T> implements List<T>{
    public class Node{
        public T item;
        public Node next;
        public Node(T i, Node n){
            item = i;
            next = n;
        }
    }
    private Node sentinel; //The sentinel node will hold a value, which we won't care about.
    private int size;

    /** A SLList with a sentinel node has at least the following invariants:
     * The sentinel reference always points to a sentinel node.
     * The front item (if it exists), is always at sentinel.next.item
     * The size variable is always the total number of items that have been added.
     */

    //empty list
    public SLList(){
        sentinel = new Node(null, null);
        size = 0;
    }

    public SLList(T x){
        sentinel = new Node(null, null);
        sentinel.next = new Node(x, null);
        size = 1;
    }

    @Override
    public void addFirst(T x){
        size++;
        sentinel.next = new Node(x, sentinel.next);
    }

    @Override
    public T getFirst(){
        return sentinel.next.item;
    }

    @Override
    public int size(){
        return size;
    }

    @Override
    public void insert(T item, int position){
        Node p = sentinel;
        while(position > 0 && p.next != null){
            p = p.next;
            position--;
        }
        Node n = new Node(item, p.next);
        p.next = n;
    }

    @Override
    public T get(int i){
        return get(i, sentinel.next);
    }

    private T get(int i, Node p){
        if(i == 0){
            return p.item;
        }
        return get(i - 1, p.next);
    }

    @Override
    public void addLast(T x){
        size++;
        Node p = sentinel;
        while(p.next != null){
            p = p.next;
        }
        p.next = new Node(x, null);
    }
    
    @Override
    public T getLast(){
        Node p = sentinel;
        while(p.next != null){
            p = p.next;
        }
        return p.item;
    }

    private Node getLastNode(){
        Node p = sentinel;
        while(p.next != null){
            p = p.next;
        }
        return p;
    }

    @Override
    public T removeLast(){
        Node back = getLastNode();
        if(back == sentinel){
            return null;
        }
        Node p = sentinel;
        while(p.next != back){
            p = p.next;
        }
        p.next = null;
        size--;
        return back.item;
    }

    public T removeFirst(){
        Node first = sentinel.next;
        sentinel.next = first.next;
        size--;
        return first.item;
    }

    public static String longest(SLList<String> list){
        int maxDex = 0;
        for(int i = 0; i < list.size; i++){
            String longestString = list.get(maxDex);
            String currString = list.get(i);
            if(currString.length() > longestString.length()){
                maxDex = i;
            }
        }
        return list.get(maxDex);
    }

    public String toString(){
        String ret = "[ ";
        Node p = sentinel.next;
        while(p != null){
            ret += p.item + " ";
            p = p.next;
        }
        return ret + "]";
    }

    @Override
    public void print(){
        Node p = sentinel.next;
        while(p != null){
            System.out.print(p.item + " ");
            p = p.next;
        }
        System.out.println();
    }


    public static void main(String[] args){
        SLList<Integer> L = new SLList<>();
        L.addLast(1);
        L.addLast(2);
        L.addLast(3);
        System.out.println(L.size());
        System.out.println(L.getFirst());
        System.out.println(L.getLast());
        L.removeLast();
        System.out.println(L.getLast());
        System.out.println(L.size());
        SLList<String> L2 = new SLList<>();
        L2.addLast("I");
        L2.addLast("am");
        L2.addLast("so");
        L2.addLast("happy");
        L2.addLast("Fuck");
        System.out.println(L2);
        L2.removeLast();
        System.out.println(L2);
        System.out.println(longest(L2));
        L2.insert("Fucking", 3);
        System.out.println(L2);
    }
}
