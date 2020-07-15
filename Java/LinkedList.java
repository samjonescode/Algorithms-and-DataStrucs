package Java;

public class LinkedList<E> {
    int data;
    LinkedList<E> next;
    LinkedList<E> prev;

    public LinkedList(int data) {
        this.data = data;
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>(6);
        list.next = new LinkedList(7);
        list.prev = new LinkedList(5);

        LinkedList pointer = list.prev;

        while (pointer != null) {
            System.out.println(pointer.data);
            pointer = pointer.next;
        }

        pointer = list.next;

        while (pointer != null) {
            System.out.println(pointer.data);
            pointer = pointer.prev;
        }

    }

    void addFirst(E node) {
        node.next = 

    }

}