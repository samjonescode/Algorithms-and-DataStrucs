package BinaryTree.BST;

public class MinSubtree {
    int minimumSoFar = Integer.MAX_VALUE;
    BST minimumNode;

    BST MinSubtreeSum(BST root) {
        minimumSum(root);
        return minimumNode;
    }

    /**
     * Base case: returns 0 when a leaf is reached. after that, we add the left and
     * right + root.data so ( 0 + 0 + current.data) the next call, this will be like
     * ( currSum(left) + currSum(right) + current.data)
     * 
     */
    int minimumSum(BST root) {
        if (root == null) {
            return 0;
        }

        int leftSum = minimumSum(root.left);
        int rightSum = minimumSum(root.right);

        int currSum = leftSum + rightSum + root.data;

        if (currSum < minimumSoFar) {
            minimumSoFar = currSum;
            minimumNode = root;
        }

        return currSum;
    }

}