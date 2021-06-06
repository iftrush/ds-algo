public class Maximizer {
    /**interfaces in Java provide us with the ability to make callbacks 
     * a function needs the help of another function that might not have been written yet
     * ex: max needs compareTo
     * A callback function is the helping function (in the scenario, compareTo)
    */
    public static Comparable max(Comparable[] items){
        int maxDex = 0;
        for(int i = 0; i < items.length; i++){
            int cmp = items[i].compareTo(items[maxDex]);
            if(cmp > 0){
                maxDex = i;
            }
        }
        return items[maxDex];
    }
}
