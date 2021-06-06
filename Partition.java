public class Partition {
    public static IntList[] partition(IntList lst, int k){
        IntList[] array = new IntList[k];
        int index = 0;
        IntList L = lst.reverse();
        while(L != null){
            IntList next = L.rest;
            IntList prevAtIndex = array[index];
            array[index] = L;
            array[index].rest = prevAtIndex;
            L = next;
            index = (index + 1) % k;
        }
        return array;
    }
}
