import java.util.Comparator;

public class Dog implements Comparable<Dog>{
    private String name;
    private int size;

    public Dog(String n, int s){
        name = n;
        size = s;
    }

    public void Bark(){
        System.out.println(name + " says: bark");
    }

    @Override
    public int compareTo(Dog uddaDog){ //callback function(helping function) for Maximizer.max
        //since compareTo takes in any arbitrary Object o, we have to cast the input to a Dog to make our comparison using the size instance variable
        /**
         * return negative number if diff < 0
         * return 0 if diff == 0
         * return positive number if diff > 0
         */
        return this.size - uddaDog.size;
    }

    private static class NameComparator implements Comparator<Dog>{
        public int compare(Dog a, Dog b){
            return a.name.compareTo(b.name);
        }
    }

    public static Comparator<Dog> getNameComparator(){
        return new NameComparator();
    }

    public static void main(String[] args){
        Dog d1 = new Dog("Apple", 30);
        Dog d2 = new Dog("Bob", 40);
        Dog d3 = new Dog("Cat", 10);
        Dog[] dogs = new Dog[]{d1, d2, d3};
        Dog d = (Dog) Maximizer.max(dogs);
        System.out.println(d.name);
        Comparator<Dog> nc = Dog.getNameComparator();
        System.out.println(nc.compare(d1, d3) > 0 ? d1.name : d3.name);
    }
}
