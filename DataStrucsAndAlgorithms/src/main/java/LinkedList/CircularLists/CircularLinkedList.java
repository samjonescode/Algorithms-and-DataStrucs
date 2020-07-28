package LinkedList.CircularLists;

public class CircularLinkedList {
    Node last;

    // delete after node with data
    Node deleteAfter(int data) {
        if (last == null)
            return null;
        Node toDelete = null;
        Node curr = last;
        do {
            if (curr.data == data) {
                toDelete = curr.next;
                // check for a one node list... in which case we're deleting whole ting.
                if (curr.next == curr) {
                    last = null;
                } else {
                    // curr will point to the one following toDelete
                    // cutting toDelete out of the linkages.
                    curr.next = toDelete.next;
                    // if toDelete is last, last is now curr.
                    if (toDelete == last)
                        last = curr;
                }
                break;
            }
            curr = curr.next;
        } while (curr != last); // while we have not made multiple passes.
        return toDelete;
    }

    Node deleteBefore(int toDelete) {
        if (last == null || last == last.next) {
            Node deleted = last.next;
            last = null;
            return deleted;
        }
        Node curr = last;
        do {
            if (curr.next.data == toDelete) {
                if (curr.next == last) {
                    last = curr;
                }
                Node deleted = curr.next;
                curr.next = curr.next.next;
                return deleted;
            }
            curr.next = curr.next.next;
        } while (curr != last);

        return null;

    }

    // delete first
    Node deleteFirst() {
        Node deleteMe = last.next;
        if (last == null || last.next == last) {
            last = null;
            return deleteMe;
        }
        last.next = last.next.next;
        return deleteMe;
    }

    // delete last
    Node deleteLast() {
        Node deleteMe = last;
        if (last == null || last.next == deleteMe) {
            last = null;
            return deleteMe;
        }
        Node curr = last;
        while (curr.next != deleteMe) {
            curr = curr.next;
        }
        curr.next = last.next;
        last = curr;
        return deleteMe;

    }

    // insert at front

    void addAfter(int data, int after) {
        if (last == null) {
            return;
        }
        Node curr = last;

        do {
            if (curr.data != after) {
                Node n = new Node(data);
                n.next = curr.next;
                curr.next = n;
                break;
            }
            curr = curr.next;
        } while (curr.next != last);
    }

    void insertAtFront(int data) {
        Node n = new Node(data);
        if (last == null) {
            n.next = n;
            last = n;
        } else {
            n.next = last.next;
            last.next = n;
        }
    }

    void insertAtEnd(int data) {
        Node n = new Node(data);
        if (last == null) {
            last = n;
            last.next = n;
        } else {
            n.next = last.next;
            last.next = n;
            last = n;
        }
    }
}

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}