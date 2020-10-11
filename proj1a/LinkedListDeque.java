public class LinkedListDeque<Type> {

    private static class Node<T> {
        private Node prev;
        private Node next;
        private T item;

        private Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    public Node<Type> sentinel;
    private int size;
//    private Node currentNode;

    public LinkedListDeque() {
          sentinel = new Node(null, null, null);
          sentinel.prev = sentinel;
          sentinel.next = sentinel;
          size = 0;
//          currentNode = sentinel;
    }

    public void addFirst(Type item) {
          Node origNext = sentinel.next;
          sentinel.next = new Node(sentinel, item, sentinel.next);
          origNext.prev = sentinel.next;
          size += 1;

    }

    public void addLast(Type item) {
        Node origPrev = sentinel.prev;
        sentinel.prev = new Node(sentinel.prev, item, sentinel);
        origPrev.next = sentinel.prev;
        size += 1;

    }

    public boolean isEmpty() {
        if (sentinel.next == sentinel && sentinel.prev == sentinel) {
            System.out.println("Is Empty");
            return true;
        } else {
            System.out.println("Not Empty");
            return false;

        }
    }

    public int size() {
        return this.size;
    }

    public void printDeque() {
        Node N = sentinel.next;
        String items = "";
        while(N != sentinel) {
            items += N.item + " ";
            N = N.next;
        }
        items += "\n";
        System.out.println(items);

    }

    public Type removeFirst() {
        Node<Type> firstNode = sentinel.next;
        sentinel.next = firstNode.next;
        firstNode.next.prev = sentinel;
        size -= 1;
        return firstNode == sentinel ? null : (Type) firstNode;
    }

    public Type removeLast() {
        Node lastNode = sentinel.prev;
        sentinel.prev = lastNode.prev;
        lastNode.prev.next = sentinel;
        size -= 1;
        return lastNode == sentinel ? null : (Type) lastNode;
    }

    public Type get(int index) {
        Node N = sentinel.next;
        int i = 0;
        while(i < index) {
            i += 1;
            N = N.next;
            if (N == sentinel) {
                break;
            }
        }
        return N == sentinel ? null : (Type) N.item;
    }

    /**
     *  Recursive get method helper
     * */
    private Type getRecursiveHelper(int index, Node<Type> N) {

        if (index == 0 ) {
            return (Type) N.item;
        } else {
            return (Type) getRecursiveHelper(index - 1, N.next);
        }
    }

    public Type getRecursive(int index) {
        if (index >= size) {
            return null;
        }

        return (Type) getRecursiveHelper(index, sentinel.next);
    }


    public static void main(String[] args) {
        LinkedListDeque<String> L = new LinkedListDeque<>();
        L.isEmpty();
        L.addFirst("b");
        L.addLast("c");
        L.addLast("d");
        L.addLast("e");
        L.addLast("f");
        L.addLast("g");
        L.addFirst("a");
        L.printDeque();
        L.removeFirst();
        L.removeLast();
        L.printDeque(); // 2,3,4,5,6
        System.out.println(L.get(4));
        System.out.println(L.getRecursive(4));
//        Object[] numbers = new Object[]{ "1", "2", 2.31313123};
//        System.out.println(numbers[2] + " " + numbers[1]);
        int[] x = {9, 10, 11, 12, 13};
        int[] y = new int[2];
        int i = 0;
        while (i < x.length) {
            y[i] = x[i];
            i += 1;
        }

//        System.out.println(L.sentinel.next.item); //1
//        System.out.println(L.sentinel.next.next.item); //2
//        System.out.println(L.sentinel.next.next.next.item); //3
//
//        System.out.println(L.sentinel.prev.prev.item); //6
//        System.out.println(L.sentinel.prev.prev.prev.prev.item); //4
//        System.out.println(L.size());
//        System.out.println(L.last.item);
//        System.out.println(L.first.item);
    }
}
