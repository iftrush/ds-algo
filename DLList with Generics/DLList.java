public class DLList<T>{ // No sentinel
    public class TNode{
        public TNode prev;
        public TNode next;
        public T item;
        public TNode(){
            item = null;
            prev = null;
            next = null;
        }
        public TNode(T x){
            item = x;
            prev = null;
            next = null;
        }
    }
    private TNode head;
    private TNode tail;
    private int size;

    public DLList(){
        head = null;
        tail = null;
        size = 0;
    }

    public DLList(T x){
        head = tail = new TNode(x);
        size = 1;
    }

    public void insertFront(T x){
        if(size == 0){
            head = tail = new TNode(x);
        }
        else{
            head.prev = new TNode(x);
            head.prev.next = head;
            head = head.prev;
        }
        size++;

    }

    public void removeFront(){
        if(size == 0){
            return;
        }
        else if(size == 1){
            head = tail = null;
            size--;
        }
        else{
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void insertLast(T x){
        if(size == 0){
            head = tail = new TNode(x);
        }else{
            tail.next = new TNode(x);
            tail.next.prev = tail;
            tail = tail.next;
        }
        size++;
    }

    public void removeLast(){
        if(size == 0){
            return;
        }else if(size == 1){
            head = tail = null;
            size--;
        }else{
            tail = tail.prev;
            tail.next = null;
            size--;
        }
    }

    public int size(){
        return size;
    }

    public String toString(){
        String result = "[ ";
        TNode curr = head;
        while(curr != null){
            result += curr.item + " ";
            curr = curr.next;
        }
        return result + "]";
    }

    public static void main(String[] args){
        DLList<Integer> lst = new DLList<>(3);
        lst.insertFront(2);
        lst.insertFront(1);
        System.out.println(lst);
        System.out.println(lst.size());
        lst.removeFront();
        lst.removeFront();
        System.out.println(lst);
        System.out.println(lst.size());
        lst.insertLast(4);
        lst.insertLast(5);
        System.out.println(lst);
        System.out.println(lst.size());
        lst.removeLast();
        lst.removeLast();
        System.out.println(lst);
        System.out.println(lst.size());
    }
}