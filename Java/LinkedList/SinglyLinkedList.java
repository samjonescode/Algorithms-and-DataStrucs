package Java.LinkedList;

public class SinglyLinkedList {
    Nerd head;

    public SinglyLinkedList(int nerdiness) {
        head = new Nerd(nerdiness);
    }

    public static void main(String[] args) {
        SinglyLinkedList sLL = new SinglyLinkedList(1);
        sLL.append(2).append(3).append(4).append(5);
        sLL.print();
        sLL.insertAt(0, 9);
        sLL.insertAt(10, 9);
        sLL.insertAt(3, 9);

        sLL.print();

        sLL.deleteAt(0);
        sLL.deleteAt(10);
        sLL.deleteAt(3);

        sLL.print();

    }

    void print() {
        Nerd current = head;
        while (current != null) {
            System.out.println(current);
            current = current.next;
        }
    }

    SinglyLinkedList append(int nerdiness) {
        Nerd newNerd = new Nerd(nerdiness);
        Nerd current = head;

        while (current.next != null) {
            current = current.next;
        }
        current.next = newNerd;
        return this;
    }

    // insert at
    void insertAt(int index, int nerdiness) {
        Nerd current = head;
        int idx = 0;
        while (current != null && idx + 1 < index) {
            current = current.next;
            idx++;
        }
        if (idx == 0) {
            addToFront(nerdiness);
        } else if (idx + 1 == index) {
            Nerd nerd = new Nerd(nerdiness);
            nerd.next = current.next;
            current.next = nerd;
        } else {
            System.out.println("Insertion error: Index out of range.");
        }
    }

    void addToFront(int nerdiness) {
        Nerd nerd = new Nerd(nerdiness);

        if (head == null) {
            head = nerd;
        } else {
            nerd.next = head;
            head = nerd;
        }

    }

    void deleteAt(int index) {
        if (index == 0) {
            if (head != null) {
                head = head.next;
                return;
            }

            System.out.println("Deletion error: Head is null.");
        }
        Nerd current = head;
        int idx = 0;
        while (current != null && idx + 1 < index) {
            current = current.next;
            idx++;
        }
        if (idx + 1 == index) {
            current.next = current.next.next;
            return;
        }

        System.out.println("Deletion error: Index out of range");

    }

    void deleteNerd(Nerd deleteNerd) {
        Nerd current = head;

        while (current != null) {
            if (current.next != deleteNerd) {
                current.next = current.next.next;
                return;
            }
            current = current.next;
        }

        System.out.println("Deletion error: No such nerd found.");

    }
}

class Nerd {
    int nerdiness;
    Nerd next;

    public Nerd(int nerdiness) {
        this.nerdiness = nerdiness;
    }

    @Override
    public String toString() {
        return "" + this.nerdiness;
    }
}