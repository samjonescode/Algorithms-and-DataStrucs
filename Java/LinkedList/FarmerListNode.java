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
        FarmerListNode.insertAfterRecursive(newHeadFarmer, 17, Integer.MAX_VALUE);
        System.out.println(newHeadFarmer);
        FarmerListNode.insertAfterRecursive(newHeadFarmer, 20, Integer.MIN_VALUE);
        System.out.println(newHeadFarmer);
        FarmerListNode.insertAfterRecursive(newHeadFarmer, 30, Integer.MAX_VALUE);
        System.out.println(newHeadFarmer);

        // FarmerListNode.deleteRecursive(newHeadFarmer, 17);
        // System.out.println(newHeadFarmer);
        // FarmerListNode.deleteRecursive(newHeadFarmer, 16);
        newHeadFarmer.deleteIterative(20);
        System.out.println(newHeadFarmer);
        newHeadFarmer = newHeadFarmer.deleteIterative(16);
        System.out.println(newHeadFarmer);

        newHeadFarmer.appendToEnd(20).appendToEnd(20).appendToEnd(20);
        newHeadFarmer.deleteIterative(20);
        System.out.println(newHeadFarmer);
    }

    int acresOfLand;
    FarmerListNode next;

    FarmerListNode(int acres) {
        this.acresOfLand = acres;
    }

    static void deleteRecursive(FarmerListNode current, int acres) {
        if (current == null)
            return;
        if (current.acresOfLand == acres) {
            current.next = current.next.next;
            current.acresOfLand = current.next.acresOfLand;
            // deleteRecursive(current, current.acresOfLand);
            // deleteIterative(current, acres);
        }
        if (current.next.acresOfLand == acres) {
            current.next = current.next.next;
        } else {
            deleteRecursive(current, acres);
        }
    }

    /**
     * If using this method to delete the head, you must use the returned value.
     * Otherwise, feel free not to use the returned value.
     */
    FarmerListNode deleteIterative(int acres) {
        FarmerListNode current = this;
        if (current.acresOfLand == acres) {
            return current.next;
        }
        while (current != null) {
            if (current.acresOfLand == acres) {
                current.next = current.next.next;
            }
            current = current.next;
        }
        return this;
    }

    static void insertAfterRecursive(FarmerListNode current, int insertAfterMe, int acres) {
        if (current == null)
            return;
        if (current.acresOfLand == insertAfterMe) {
            FarmerListNode n = new FarmerListNode(acres);
            if (current.next != null) {
                FarmerListNode temp = current.next;
                n.next = temp;
            }
            current.next = n;
        } else {
            insertAfterRecursive(current.next, insertAfterMe, acres);
        }
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

        /**
         * The two pointers will overlap - then we reset the slowPointer to the head,
         * where it and the fastPointer will be equidistant from the cycle starting
         * point
         */
        static FarmerListNode findCycleStart(FarmerListNode headFarmer) {
            FarmerListNode slowPointer = headFarmer.next;
            FarmerListNode fastPointer = headFarmer.next.next;

            while (slowPointer != fastPointer) {
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next.next;
            }
            slowPointer = headFarmer;
            while (slowPointer != fastPointer) {
                slowPointer = slowPointer.next;
                fastPointer = fastPointer.next;
            }

            return slowPointer;
        }

        static FarmerListNode mergeLists(FarmerListNode headOne, FarmerListNode headTwo) {
            return null;
        }

        static FarmerListNode shiftList(int shiftUnits, FarmerListNode head) {
            return null;
        }
    }

    @Override
    public String toString() {
        return "Acres: " + this.acresOfLand + ", Next: " + this.next;
    }
}
