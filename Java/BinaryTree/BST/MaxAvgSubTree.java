package Java.BinaryTree.BST;

/**
 * Assumptions: The tree is binary The values each node stores are integers.
 *
 */
public class MaxAvgSubTree {
    TreeNode subtreeRoot;
    Avg maxAvg;

    TreeNode findMaxAvgSubTree(TreeNode root) {
        helperFunction(root);
        return this.subtreeRoot;
    }

    Avg helperFunction(TreeNode root) {
        /**
         * Do no computations until reaching a leaf, or null node Bubble the average at
         * that node up to the other calls. Update the maxAvg and subtreeRoot instance
         * variables when the average as we ascend up the tree exceeds the previous
         * average.
         */
        if (root == null) {
            return new Avg(0, 0);
        }

        Avg left = helperFunction(root.left);
        Avg right = helperFunction(root.right);
        Avg currAvg = new Avg(left.sum + right.sum + root.val, left.size + right.size + 1);

        // update the max average.
        if (subtreeRoot == null || maxAvg.sum * currAvg.size < currAvg.sum * maxAvg.size) {
            maxAvg = currAvg;
            subtreeRoot = root;
        }

        return currAvg;
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

class Avg {
    int sum;
    int size;

    Avg(int sum, int size) {
        this.sum = sum;
        this.size = size;
    }
}