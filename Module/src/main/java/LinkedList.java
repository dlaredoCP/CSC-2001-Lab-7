public class LinkedList<T> {
    private T first;
    private LinkedList<T> rest;

    public LinkedList(T first, LinkedList<T> rest){
        this.first = first;
        this.rest = rest;
    }

    public int size() {
        if (first == null) {
            return 0;
        } else if (rest == null) {
            return 1;
        } else {
            return 1 + rest.size();
        }
    }

    public void add(T another){
        if (first == null){
            first = another;
            rest = null;
        } else
        if (rest == null) {
            rest = new LinkedList<>(another, null);
        } else {
            rest.add(another);
        }
    }

    public T getFirst(){
        return first;
    }

    public LinkedList getRest(){
        return rest;
    }
}
