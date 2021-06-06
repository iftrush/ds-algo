public class IntList {
    public int first;
    public IntList rest;
    public IntList(int f, IntList r){
        first = f;
        rest = r;
    }
    public int size(){
        if(rest == null){
            return 1;
        }
        return 1 + rest.size();
    }

    public int iterativeSize(){
        // IntList p = this;
        // int size = 0;
        // while(p != null){
        //     p = p.rest;
        //     size++;
        // }
        int size = 0;
        for(IntList p = this; p != null; p = p.rest){
            size++;
        }
        return size;
    }

    public int get(int i){
        if(i == 0){
            return first;
        }
        return rest.get(i - 1);
    }

    public int iterativeGet(int i){
        IntList p = this;
        while(i != 0){
            p = p.rest;
            i--;
        }
        return p.first;
    }


    // public static void main(String[] args){
    //     IntList L = new IntList(5, null);
    //     L.rest = new IntList(10, null);
    //     L.rest.rest = new IntList(15, null);
    //     System.out.println(L.size());
    //     System.out.println(L.iterativeSize());
    //     System.out.println(L.get(1));
    //     System.out.println(L.iterativeGet(0));
    //     System.out.println(L.iterativeGet(1));
    //     System.out.println(L.iterativeGet(2));
    // }
}
