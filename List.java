public interface List<T> {
    public void addFirst(T x);
    public void addLast(T x);
    public T getFirst();
    public T getLast();
    public T removeLast();
    public T get(int i);
    public void insert(T x, int position);
    public int size();
    default public void print(){
        for(int i = 0; i < size(); i++){
            System.out.print(get(i) + " ");
        }
        System.out.println();
    }
}
