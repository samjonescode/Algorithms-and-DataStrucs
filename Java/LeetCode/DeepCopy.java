
package Java.LeetCode;

public class DeepCopy {
    public Node copyRandomList(Node head) {
        if (head == null)
            return null;

        // Create copies
        Node node = head;
        while (node != null) {
            Node copy = new Node(node.val);
            Node next = node.next;
            node.next = copy;
            copy.next = next;
            node = next;
        }

        // Set the Copy's random nodes
        node = head;
        while (node != null) {
            Node random = node.random != null ? node.random.next : null;
            node.next.random = random;
            node = node.next.next;
        }

        // Update the links
        node = head;
        Node newHead = head.next;
        while (node != null) {
            Node p2 = node.next;
            node.next = p2.next;
            p2.next = p2.next != null ? p2.next.next : p2.next;
            node = node.next;
        }
        return newHead;
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}