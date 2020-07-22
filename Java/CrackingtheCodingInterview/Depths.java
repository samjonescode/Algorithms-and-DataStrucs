package Java.CrackingtheCodingInterview;

import java.util.*;

/**
 * This creates a linked list from each level of a binary tree.
 * 
 * I incorrectly named the tree class BST when in fact the question applies to
 * generic binary trees. Hence the BST in here is not really a BST.
 * 
 */
public class Depths {

    public static void main(String[] args) {
        BST root = new BST(1);
        root.left = new BST(2);
        root.right = new BST(3);

        BST level2Left = root.left;
        BST level2Right = root.right;

        level2Left.left = new BST(4);
        level2Left.right = new BST(5);

        level2Right.left = new BST(6);
        level2Right.right = new BST(7);

        long start = System.currentTimeMillis();
        System.out.println("My method: " + createLinkedLists(root));
        long end = System.currentTimeMillis();
        long totalTime = end - start;
        System.out.println("My solution took: " + totalTime + " ms.");

        start = System.currentTimeMillis();
        System.out.println("CTCI Solution: " + createLevelLinkedList(root));
        end = System.currentTimeMillis();
        totalTime = end - start;
        System.out.println("CTCI solution took: " + totalTime + " ms.");

    }

    // My solution
    public static List<List<BST>> createLinkedLists(BST root) {
        List<List<BST>> containerList = new ArrayList<>();
        List<BST> levelList = new LinkedList<>();

        levelList.add(root);
        containerList.add(levelList);
        while (true) {
            levelList = new LinkedList<>();
            int containerSize = containerList.size() - 1;
            List<BST> parentLevel = containerList.get(containerSize);
            for (BST node : parentLevel) {
                levelList.add(node.left);
                levelList.add(node.right);
            }
            if (containsOnlyNulls(levelList))
                return containerList;
            containerList.add(levelList);
        }
    }

    static boolean containsOnlyNulls(List<BST> levelList) {
        for (BST node : levelList) {
            if (node != null) {
                return false;
            }
        }
        return true;
    }

    // CTCI Solution

    static ArrayList<LinkedList<BST>> createLevelLinkedList(BST root) {
        ArrayList<LinkedList<BST>> result = new ArrayList<LinkedList<BST>>();
        LinkedList<BST> levelList = new LinkedList<>();
        if (root != null) {
            levelList.add(root);
        }

        while (levelList.size() > 0) {
            result.add(levelList);
            LinkedList<BST> parents = levelList;
            levelList = new LinkedList<BST>();
            for (BST parent : parents) {
                if (parent.left != null) {
                    levelList.add(parent.left);
                }
                if (parent.right != null) {
                    levelList.add(parent.right);
                }
            }
        }
        return result;
    }
}

class BST {
    int value;
    BST left;
    BST right;

    public BST(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return this.value + "";
    }
}