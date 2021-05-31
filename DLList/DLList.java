public class DLList{ // No sentinel
    public static class IntNode{
        public IntNode prev;
        public IntNode next;
        public int item;
        public IntNode(){
            item = 0;
            prev = null;
            next = null;
        }
        public IntNode(int x){
            item = x;
            prev = null;
            next = null;
        }
    }
    private IntNode head;
    private IntNode tail;
    private int size;

    public DLList(){
        head = null;
        tail = null;
        size = 0;
    }

    public DLList(int x){
        head = tail = new IntNode(x);
        size = 1;
    }

    public void insertFront(int x){
        if(size == 0){
            head = tail = new IntNode(x);
        }
        else{
            head.prev = new IntNode(x);
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

    public void insertLast(int x){
        if(size == 0){
            head = tail = new IntNode(x);
        }else{
            tail.next = new IntNode(x);
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
        IntNode curr = head;
        while(curr != null){
            result += curr.item + " ";
            curr = curr.next;
        }
        return result + "]";
    }

    // public static void main(String[] args){
    //     DLList lst = new DLList(3);
    //     lst.insertFront(2);
    //     lst.insertFront(1);
    //     System.out.println(lst);
    //     System.out.println(lst.size());
    //     lst.removeFront();
    //     lst.removeFront();
    //     System.out.println(lst);
    //     System.out.println(lst.size());
    //     lst.insertLast(4);
    //     lst.insertLast(5);
    //     System.out.println(lst);
    //     System.out.println(lst.size());
    //     lst.removeLast();
    //     lst.removeLast();
    //     System.out.println(lst);
    //     System.out.println(lst.size());
    // }
}