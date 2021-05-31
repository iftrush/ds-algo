public class SelectionSort{

    public static int findSmallest(String[] x, int start){
        int minIndex = start;
        for(int i = start; i < x.length; i++){
            int cmp = x[i].compareTo(x[minIndex]);
            if(cmp < 0){
                minIndex = i;
            }
        }
        return minIndex;
    }

    public static void swap(String[] x, int i, int j){
        String temp = x[i];
        x[i] = x[j];
        x[j] = temp;
    }

    public static void sort(String[] x){
        sort(x, 0);
    }

    private static void sort(String[] x, int start){
        if(start == x.length){
            return;
        }
        int min = findSmallest(x, start);
        swap(x, start, min);
        sort(x, start + 1);
    }

    public static void main(String[] args){
        String[] input = {"i", "have", "an", "egg"};
        sort(input);
        for(String s : input){
            System.out.print(s + " ");
        }
    }
}