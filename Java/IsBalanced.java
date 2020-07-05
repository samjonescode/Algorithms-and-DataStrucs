public class IsBalanced {

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);

        Node level2Left = root.left;
        Node level2Right = root.right;

        level2Left.left = new Node(4);
        level2Left.right = new Node(5);

        level2Right.left = new Node(6);
        level2Right.right = new Node(7);

        Node level3LeftLeft = level2Left.left;
        Node level3LeftRight = level2Left.right;

        Node level3RightLeft = level2Right.left;
        Node level3RightRight = level2Right.right;

        level3LeftLeft.left = new Node(8);
        level3LeftLeft.right = new Node(9);
        level3LeftRight.left = null;
        level3LeftRight.right = new Node(10);

        level3RightLeft.left = new Node(11);
        level3RightLeft.right = new Node(12);
        level3RightRight.left = new Node(13);
        level3RightRight.right = new Node(14);

        level3RightRight.right.right = new Node(15);

     

     public static boolean isBalanced(Node root) {
        if (root == null) {
            return true;
        }

        int depthLeft = findDepth(root.left);
        int depthRight = findDepth(root.right);

        boolean isBalanced = Math.abs(depthLeft - depthRight) <= 1;
        if (!isBalanced) {
            return false;
        } else {
            return isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public static int findDepth(Node root) {
        if (root == null) {
            return -1;
        }
        return Math.max(findDepth(root.left), findDepth(root.right)) + 1;
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
