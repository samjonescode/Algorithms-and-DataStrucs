package Java.LinkedList;

// import Java.LinkedList.DoublyLinked;

public class DoubleLinkedList {
    Nerd head;
    Nerd tail;
    int size;

    public static void main(String[] args) {
        DoubleLinkedList nerdList = new DoubleLinkedList(10);

        nerdList.addToTail(9).addToTail(8).addToTail(7).addToTail(6).addToTail(5);

        nerdList.print();

        nerdList.addToFront(11);

        nerdList.print();

    }

    void print() {
        Nerd current = head;
        System.out.println(" < List > ");
        while (current.next != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    public DoubleLinkedList addToTail(int data) {
        Nerd node = new Nerd(data);
        Nerd current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
        node.prev = current;
        current = current.next;
        return this;
    }

    public void addToFront(int nerdiness) {
        Nerd newNerd = new Nerd(nerdiness);

        if (head == null) {
            tail = newNerd;
        } else {
            head.prev = newNerd;
            newNerd.next = head;

        }
        head = newNerd;
        size++;
    }

    public void deleteAtIndex(int index) {
    }

    public void deleteNerd(Nerd deletedNerd) {
    }

    public void deleteNerdsByNerdiness(int nerdinessLevel) {

    }

    public Nerd addAtIndex(int nerdiness, int index) {
        return new Nerd(-1);
    }

    public DoubleLinkedList(int nerdiness) {
        this.head = new Nerd(nerdiness);
    }
}

class Nerd {
    int nerdiness;
    Nerd next;
    Nerd prev;

    public Nerd(int nerdiness) {
        this.nerdiness = nerdiness;
    }

    @Override
    public String toString() {
        return "" + this.nerdiness;
    }
}