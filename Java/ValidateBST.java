// import isBalanced.Node;
public class ValidateBST {
    public static void main(String[] args) {

    }

    Integer lastPrinted;

    boolean validateBST(Node n) {
        if (n == null)
            return true;
        // check left
        if (!validateBST(n.left))
            return false;

        // validate
        if (lastPrinted != null && n.value <= lastPrinted) {
            return false;
        }

        // Once finished traversing left-most branch, save the current value.
        lastPrinted = n.value;

        // check right
        if (!validateBST(n.right))
            return false;

        return true;

    }
}

class Node {
    int value;
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }
}