package Java.LinkedList;

// import Java.LinkedList.DoublyLinked;

public class DoubleLinkedList {
    Nerd head;
    Nerd tail;
    int size;

    public static void main(String[] args) {
        DoubleLinkedList nerdList = new DoubleLinkedList(10);

        nerdList.addToTail(9).addToTail(8).addToTail(7).addToTail(6).addToTail(5);

        nerdList.addToFront(11);

        nerdList.deleteAtIndex(3);

        nerdList.insertAtIndex(8, 3);

        // nerdList.getTail().printReverse();

        // nerdList.tail
        // nerdList.reverse();

        // nerdList.print();

    }

    void reverse() {
        Nerd current = head;
        while (current != null) {
            Nerd temp = current.next;
            current.next = current.prev;
            current.prev = temp;
            System.out.println(current);
            if (current.prev == null)
                break;
            current = temp;
        }
    }

    void print() {
        Nerd current = head;
        System.out.println(" < List > ");
        while (current.next != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    void printReverse() {
        Nerd current = tail;
        while (current.prev != null) {
            System.out.println(current);
            current = current.prev;
        }

    }

    public DoubleLinkedList addToTail(int data) {
        Nerd newNerd = new Nerd(data);
        if (tail == null) {
            tail = newNerd;
            // head = newNerd;
        }
        tail.next = newNerd;
        newNerd.prev = tail;
        tail = newNerd;
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

    public void insertAtIndex(int nerdiness, int index) {
        Nerd current = head;
        int currIdx = 0;
        while (currIdx < index) {
            current = current.next;
            currIdx++;
        }

        Nerd newNerd = new Nerd(nerdiness);
        newNerd.next = current;
        newNerd.prev = current.prev;
        current.prev.next = newNerd;
        current.prev = newNerd;

    }

    public void deleteAtIndex(int index) {

        /**
         * Go to index Set node's prev to be the old node's prev set next to be the old
         * node
         * 
         */

        Nerd current = head;
        int currIdx = 0;
        while (currIdx < index) {
            current = current.next;
            currIdx++;
        }

        current.prev.next = current.next;
        current.next.prev = current.prev;

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