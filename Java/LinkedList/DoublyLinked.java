package Java.LinkedList;

// package Java.LinkedList;
// import Java.Linked
public interface DoublyLinked {

    void addToFront(int nerdiness);

    Nerd addAtIndex(int nerdiness, int index);

    DoubleLinkedList addToTail(int nerdiness);

    void deleteAtIndex(int index);

    void deleteNerd(Nerd deletedNerd);

    void deleteNerdsByNerdiness(int nerdinessLevel);

}
