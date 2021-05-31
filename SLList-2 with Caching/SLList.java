public class SLList {
    public static class IntNode{
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n){
            item = i;
            next = n;
        }
    }
    private IntNode first;
    private int size;

    public SLList(int x){
        first = new IntNode(x, null);
        size = 1;
    }

    public void addFirst(int x){
        first = new IntNode(x, first);
        size++;
    }

    public int getFirst(){
        return first.item;
    }

    public int size(){
        return size;
    }

    public void addLast(int x){
        size++;
        if(first == null){
            first = new IntNode(x, null);
            return;
        }
        IntNode p = first;
        while(p.next != null){
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    public int getLast(){
        IntNode p = first;
        while(p.next != null){
            p = p.next;
        }
        return p.item;
    }

    public static void main(String[] args){
        SLList lst = new SLList(2);
        lst.addLast(3);
        lst.addFirst(1);
        System.out.println(lst.size());
        System.out.println(lst.getFirst());
        System.out.println(lst.getLast());
    }
}
