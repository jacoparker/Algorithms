// Good morning! Here's your coding interview problem for today.
// This problem was asked by Google.
// A unival tree (which stands for "universal value") is a tree where
// all nodes under it have the same value.
// Given the root to a binary tree, count the number of unival subtrees.

class Problem8<E extends Comparable<E>, T> {

    private static int counter = 0;

    public static void incCounter() { counter += 1; }

    public static int getUVLCount() { return counter; }

    // this iterative approach will not be great with larger trees. TODO re-
    // implement this in an iterative manner to avoid the crashing which occurs
    // with stack overflows.
    private static boolean countUnivalSubTrees(KVNode<Integer, Integer> root) {
        if (root == null) return true;
        KVNode<Integer, Integer> left = root.getLeftChild(), right = root.getRightChild();
        if (left == null && right == null) {
            incCounter();
            return true;
        } else if (left == null) {
            boolean isUVL = countUnivalSubTrees(right);
            return isUVL && right.getValue().compareTo(root.getValue()) == 0;
        } else if (right == null) {
            boolean isUVL = countUnivalSubTrees(left);
            return isUVL && left.getValue().compareTo(root.getValue()) == 0;
        }
        boolean leftSubTree = countUnivalSubTrees(left);
        boolean rightSubTree = countUnivalSubTrees(right);
        if (leftSubTree && rightSubTree) {
            boolean rightEqualsParent = right.getValue().compareTo(root.getValue()) == 0;
            boolean leftEqualsParent = left.getValue().compareTo(root.getValue()) == 0;
            return leftEqualsParent && rightEqualsParent;
        }
        return false;
    }

    // run some tests
    public static void main(String []args) {
        NonBSBTree<Integer, Integer> tree = new NonBSBTree<Integer, Integer>();
        tree.insert(5, 0);
        tree.insert(4, 1);
        tree.insert(10, 0);
        tree.insert(7, 1);
        tree.insert(6, 1);
        tree.insert(8, 1);
        tree.insert(11, 0);
        countUnivalSubTrees(tree.getRoot());

        int count = getUVLCount();
        assert count == 5 : "Expected 5 got " + count;
    }
}
