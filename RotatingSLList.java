public class RotatingSLList<T> extends SLList<T>{
    /**
     * By using the extends keyword, subclasses inherit all members of the parent class.
     * "Members" includes:
     * All instance and static variables
     * All methods
     * All nested classes
     * Note that "constructors" are not inherited, and private members cannot be directly accessed by subclasses.
     */
    public void rotateRight(){
        T x = removeLast();
        addFirst(x);
    }

    public void rotateLeft(){
        T x = removeFirst();
        addLast(x);
    }

    public static void main(String[] args){
        RotatingSLList<Integer> L = new RotatingSLList<>();
        L.addLast(1);
        L.addLast(2);
        L.addLast(3);
        L.addLast(4);
        L.rotateRight();
        System.out.println(L);
        System.out.println(L.size());
        L.rotateLeft();
        System.out.println(L);
        System.out.println(L.size());
    }
}
