// creating a doubly linked list with only a "node" class and no container "linkedlist" class.
package Java.LinkedList;

public class DoubleListNode {
    int data;
    DoubleListNode next;
    DoubleListNode prev;

    public static void main(String[] args) {

        DoubleListNode head1 = new DoubleListNode(1);
        head1.append(2).append(3).append(4).append(5);

        System.out.println(head1);
        head1.insertAt(1, 200);
        head1.insertAt(10, 200);
        System.out.println(head1);

        DoubleListNode randomNode = head1.getNodeAt(3);

        System.out.println(randomNode);
    }

    public DoubleListNode(int data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "" + this.data + ", " + this.next;
    }

    void printList() {
        DoubleListNode current = this;
        while (current.next != null) {
            System.out.println(current);
            current = current.next;
        }

    }

    DoubleListNode getNodeAt(int index) {
        DoubleListNode current = this;
        int currIdx = 0;
        while (currIdx <= index) {
            currIdx++;
            current = current.next;
        }

        return current;
    }

    DoubleListNode append(int data) {
        DoubleListNode node = new DoubleListNode(data);
        DoubleListNode current = this;
        while (current.next != null) {
            current = current.next;
        }
        current.next = node;
        node.prev = current;
        current = current.next;
        return current;

    }

    DoubleListNode goToHead() {
        DoubleListNode current = this;
        while (current.prev != null) {
            current = current.prev;
        }

        return current;
    }

    DoubleListNode goToTail() {
        DoubleListNode current = this;
        while (current.next != null) {
            current = current.next;
        }

        return current;
    }

    void insertAt(int index, int data) {
        DoubleListNode current = this;
        int currIndex = 0;
        while (current != null && currIndex < index) {
            current = current.next;
            currIndex++;
        }
        if (current == null) // if the node is null, we've surpassd the number of total nodes in the list.
        {
            System.out.println("Beyond the tail");
            return;
        }

        DoubleListNode newNode = new DoubleListNode(data);
        newNode.next = current;
        newNode.prev = current.prev;
        current.prev.next = newNode;

    }
}