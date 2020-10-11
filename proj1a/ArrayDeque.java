public class ArrayDeque<T> {
    T[] List;
    int size;
    int initialLength = 100;

    public ArrayDeque () {
        List = (T[])new Object[initialLength];
        size = 0;
    }

    public void addFirst(T x) {
        T[] newList = (T[]) new Object[List.length];
        System.arraycopy(List, 0, newList, 1, size);
        newList[0] = x;
        List = newList;
        size += 1;
    }

    public void addLast(T x) {
        List[size] = x;
        size += 1;
    }

    public void printDeque() {
        for(int i = 0; i < size; i++) {
            System.out.println(List[i]);
        }
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    public int size() {
        return size;
    }

    public T removeFirst() {
        T removed = List[0];
        T[] newArr = (T[]) new Object[List.length];
        size -= 1;
        System.arraycopy(List, 1, newArr, 0, size );
        List = newArr;
        return removed;
    }

    public T removeLast() {
        T removed = List[size];
        List[size] = null;
        size -= 1;
        return removed;
    }

    public T get(int position) {
        if (position > (size - 1)) {
            System.out.println("to big");
            return null;
        }
        return List[position];
    }

    public static void main(String[] args) {
        ArrayDeque<Integer> L = new ArrayDeque();
        L.addFirst(3);
        L.addFirst(2);
        L.addFirst(1);
        L.addLast(4);
        L.printDeque();
        System.out.println("Removed : " + L.removeFirst());
        L.printDeque();
        L.removeLast();
        L.printDeque();
        L.get(2);
        System.out.println(L.get(1));

    }


}
