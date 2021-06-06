public class WordUtils {
    public static String longest(List<String> list) {
        int maxDex = 0;
        for (int i = 0; i < list.size(); i += 1) {
           String longestString = list.get(maxDex);
           String thisString = list.get(i);
           if (thisString.length() > longestString.length()) {
              maxDex = i;
           }
        }
        return list.get(maxDex);
     }

     public static void main(String[] args){
         List<String> L = new SLList<>();
         L.addLast("I");
         L.addLast("am");
         L.addLast("so");
         L.addLast("happy");
         System.out.println(longest(L));
     }
}
