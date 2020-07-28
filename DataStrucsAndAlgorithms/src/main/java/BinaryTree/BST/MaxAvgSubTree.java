package BinaryTree.BST;

/**
 * Assumptions: 1.The tree is binary 2. The values each node stores are
 * integers.
 *
 */
public class MaxAvgSubTree {
    TreeNode subtreeRoot;
    Result subtreeResult;

    TreeNode findMaxAvgSubTree(TreeNode root) {
        helperFunction(root);
        return this.subtreeRoot;
    }

    public static void main(String[] args) {
        System.out.println(5 / 3 == 2 / 1);
    }

    Result helperFunction(TreeNode root) {
        /**
         * Do no computations until reaching a leaf, or null node Bubble the average at
         * that node up to the other calls. Update the maxAvg and subtreeRoot instance
         * variables when the average as we ascend up the tree exceeds the previous
         * average.
         */
        if (root == null) {
            return new Result(0, 0);
        }
        Result left = helperFunction(root.left);
        Result right = helperFunction(root.right);
        Result newResult = new Result(left.sum + right.sum + root.val, left.size + right.size + 1);

        // update the max average.
        if (subtreeRoot == null || subtreeResult.sum * newResult.size < newResult.sum * subtreeResult.size) {
            subtreeResult = newResult;
            subtreeRoot = root;
        }
        return newResult;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Result {
    int sum;
    int size;

    Result(int sum, int size) {
        this.sum = sum;
        this.size = size;
    }
}