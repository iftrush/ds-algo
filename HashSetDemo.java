import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class HashSetDemo {
    public static void main(String[] args){
        Set<String> s = new HashSet<>();
        s.add("Tokyo");
        s.add("Lagos");
        System.out.println(s);
        System.out.println(s.contains("Tokyo"));
        // for(String city : s){
        //     System.out.println(city);
        // }
        Iterator<String> iter = s.iterator();
        while(iter.hasNext()){
            System.out.println(iter.next());
        }
    }
}
