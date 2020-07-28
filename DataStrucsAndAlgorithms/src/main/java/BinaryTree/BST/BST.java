package BinaryTree.BST;

public class BST {

    BST left;
    BST right;
    int data;

    public BST(int data) {
        this.data = data;
    }

    void insert(int data) {
        BST current = this;
        while (current != null) {
            if (data < current.data) {
                if (current.left != null) {
                    this.left.insert(data);
                } else {
                    BST n = new BST(data);
                    this.left = n;
                }
            } else {
                if (current.right != null) {
                    this.right.insert(data);
                } else {
                    BST n = new BST(data);
                    this.right = n;
                }
            }
        }
    }

    static boolean isBalanced(BST root) {
        return isBalancedHelper(root) != -1;
    }

    /**
     * Each call to this checks if the absolute value of the left depth and right
     * depth exceeds 1 in which case, it returns -1 to signify that the tree is
     * unbalanced. each call checks whether a previous call returned -1 before
     * checking whether it should return -1 if another call returned -1, it just
     * forwards this -1 up the call stack. otherwise, it checks whether the absolute
     * value of left and right exceed 1. if they don't, it adds 1 to the max depth
     * between the left and right sides, and returns it.
     */
    static private int isBalancedHelper(BST root) {
        if (root == null)
            return 0;

        int leftDepth = isBalancedHelper(root.left);
        int rightDepth = isBalancedHelper(root.right);
        // if the left or right depth at this node are already -1, then no need to check
        // it here.
        // the third 'or' part determines if the leftDetph and rightDepth, which are not
        // known to be unbalanced yet
        // are unbalanced now.
        if (leftDepth == -1 || rightDepth == -1 || Math.abs(leftDepth - rightDepth) > 1)
            return -1;

        return Math.max(leftDepth, rightDepth) + 1;
    }

    void flattenToLinkedList(BST root) {
        if (root == null) {
            return;
        }

        BST left = root.left;
        BST right = root.right;
        flattenToLinkedList(left);
        flattenToLinkedList(right);

        root.right = left;
        root.left = null;
        BST current = root;
        while (current.right != null) {
            current = current.right;
        }
        current.right = right;
    }

    static int findDepth(BST root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = findDepth(root.left);
        int rightDepth = findDepth(root.right);

        return Math.max(leftDepth, rightDepth) + 1;
    }

    void inOrderTraversal() {
        if (this == null) {
            System.out.println("Traversed the BST!");
        }

        this.left.inOrderTraversal();
        System.out.println("Current root: " + this.data);
        this.right.inOrderTraversal();

    }

    void preOrderTraversal() {
        if (this == null) {
            System.out.println("Done!");
        }
        System.out.println("Current root: " + this.data);
        this.left.preOrderTraversal();
        this.right.preOrderTraversal();
    }

    void postOrderTraversal() {
        if (this == null) {
            System.out.println("Done!");
        }
        this.left.postOrderTraversal();
        this.right.postOrderTraversal();
        System.out.println("Current root: " + this.data);

    }
}