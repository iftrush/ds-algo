public class SLList {

    /** If the nested class has no need to use any of the instance methods or variables of SLList, you may declare the nested class static, as follows. 
     * Declaring a nested class as static means that methods inside the static class can not access any of the members of the enclosing class. 
     * This saves a bit of memory, because each IntNode no longer needs to keep track of how to access its enclosing SLList.*/
    public static class IntNode{
        public int item;
        public IntNode next;
        public IntNode(int i, IntNode n){
            item = i;
            next = n;
        }
    }
    
    private IntNode first;
    public SLList(int x){
        first = new IntNode(x, null);
    }
    public void addFirst(int x){
        first = new IntNode(x, first);
    }
    public int getFirst(){
        return first.item;
    }
    
    public void addLast(int x){
        IntNode p = first;
        while(p.next != null){
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }
    
    //recursively
    /**Two methods with the same name but different signatures are overloaded*/
    // private static int size(IntNode p){
    //     if(p.next == null){
    //         return 1;
    //     }
    //     return 1 + size(p.next);
    // }

    // public int size(){
    //     return size(first);
    // }

    //iteratively
    public int size(){
        IntNode p = first;
        int size = 0;
        while(p != null){
            p = p.next;
            size++;
        }
        return size;
    }
    public static void main(String[] args){
        SLList L = new SLList(1);
        L.addLast(2);
        L.addLast(3);
        System.out.println(L.size());
    }
}
