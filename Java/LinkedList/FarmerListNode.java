package Java.LinkedList;

/**
 * This LinkedList has no wrapper class. It's just the node 'FarmerListNode'
 * 
 * It's a farmer node to break the monotony of generic, bland 'nodes'.
 */
public class FarmerListNode {
    public static void main(String[] args) {
        FarmerListNode headFarmer = new FarmerListNode(20);
        headFarmer.appendToEnd(19).appendToEnd(18).appendToEnd(17).appendToEnd(16);
        FarmerListNode newHeadFarmer = LinkedListHelper.reverse(headFarmer);
        System.out.println(newHeadFarmer);

    }

    int acresOfLand;
    FarmerListNode next;

    FarmerListNode(int acres) {
        this.acresOfLand = acres;
    }

    FarmerListNode appendToEnd(int acres) {
        FarmerListNode newFarmer = new FarmerListNode(acres);

        FarmerListNode current = this;
        while (current.next != null) {
            current = current.next;
        }

        current.next = newFarmer;
        return newFarmer;
    }

    static class LinkedListHelper {
        static FarmerListNode reverse(FarmerListNode node) {
            //
            FarmerListNode sentinel = null;
            FarmerListNode pointer = node;
            while (pointer != null) {
                FarmerListNode pointerTwo = pointer.next;
                pointer.next = sentinel;
                sentinel = pointer;
                pointer = pointerTwo;
            }

            return sentinel;

        }

        static boolean detectCycle(FarmerListNode headFarmer) {
            return true;
        }
    }

    @Override
    public String toString() {
        return "Acres: " + this.acresOfLand + ", Next: " + this.next;
    }
}
