// Good morning! Here's your coding interview problem for today.
//
// This problem was asked by Google.
//
// Given the root to a binary tree, implement serialize(root), which serializes
// the tree into a string, and deserialize(s), which deserializes the string
// back into the tree.
//
// For example, given the following Node class
//
// class Node:
//     def __init__(self, val, left=None, right=None):
//         self.val = val
//         self.left = left
//         self.right = right
// The following test should pass:
//
// node = Node('root', Node('left', Node('left.left')), Node('right'))
// assert deserialize(serialize(node)).left.left.val == 'left.left'

import java.lang.StringBuilder;
import java.util.Stack;
import java.util.Scanner;


public class problem3 {
    public static String serialize(Node<Integer> root) {
        StringBuilder str = new StringBuilder();
        Stack<Node<Integer>> st = new Stack<Node<Integer>>();
        st.push(root);
        while (!st.empty()) {
            Node<Integer> curr = st.pop();
            if (curr.getLeftChild() != null)
                st.push(curr.getLeftChild());
            if (curr.getRightChild() != null)
                st.push(curr.getRightChild());
            str.append(curr.getValue());
            str.append(" ");
        }
        return str.toString();
    }

    /**
     *  Turn a string into a binary tree.
     *  Returns the root node of the newly created string.
     */
    public static BinTree<Integer> deSerialize(String treeStr) {
        Scanner scnr = new Scanner(treeStr);
        Node<Integer> root = new Node<Integer>();
        BinTree<Integer> tree = new BinTree<Integer>(root);
        while (scnr.hasNext()) {
            Integer data = scnr.nextInt();
            tree.insert(data);
        }
        return tree;
    }

    private static void test1() {
        System.out.println("Starting test 1...");
        Node<Integer> root = new Node<Integer>(5);
        BinTree<Integer> tree = new BinTree<Integer>(root);

        // insert some values
        tree.insert(4);
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        tree.insert(0);

        // tree should be just a linked list
        int h = tree.getHeight(root);
        assert h == 6: "Incorrect Height: " + h;
        assert tree.lookup(1) == true: "Did not find 1 in tree.";
        assert tree.lookup(2) == true: "Did not find 2 in tree.";
        assert tree.lookup(3) == true: "Did not find 3 in tree.";
        assert tree.lookup(4) == true: "Did not find 4 in tree.";
        assert tree.lookup(5) == true: "Did not find 5 in tree.";
        assert tree.lookup(6) == false: "Shouldn't have found 6.";
        System.out.println("Finished test 1...");
    }

    private static void test2() {
        System.out.println("Starting test 2...");
        Node<Integer> root = new Node<Integer>(3);
        BinTree<Integer> tree = new BinTree<Integer>(root);

        // insert some values
        tree.insert(4);
        tree.insert(2);
        tree.insert(5);
        tree.insert(1);
        tree.insert(6);
        tree.insert(0);

        // tree should be just a linked list
        int h = tree.getHeight(root);
        assert h == 4: "Incorrect Height: " + h;
        assert tree.lookup(1) == true: "Did not find 1 in tree.";
        assert tree.lookup(2) == true: "Did not find 2 in tree.";
        assert tree.lookup(3) == true: "Did not find 3 in tree.";
        assert tree.lookup(4) == true: "Did not find 4 in tree.";
        assert tree.lookup(5) == true: "Did not find 5 in tree.";
        assert tree.lookup(6) == true: "Did not find 6 in tree.";
        assert tree.lookup(7) == false: "Shouldn't have found 7.";
        System.out.println("Finished test 2...");
    }

    private static void test3() {
        System.out.println("Starting test 3...");
        Node<Integer> root = new Node<Integer>(3);
        BinTree<Integer> tree = new BinTree<Integer>(root);

        // insert some values
        tree.insert(5);
        tree.insert(1);
        tree.insert(4);
        tree.insert(2);
        tree.insert(6);
        tree.insert(0);

        // tree should be just a linked list
        int h = tree.getHeight(root);
        assert h == 3: "Incorrect Height: " + h;
        assert tree.lookup(1) == true: "Did not find 1 in tree.";
        assert tree.lookup(2) == true: "Did not find 2 in tree.";
        assert tree.lookup(3) == true: "Did not find 3 in tree.";
        assert tree.lookup(4) == true: "Did not find 4 in tree.";
        assert tree.lookup(5) == true: "Did not find 5 in tree.";
        assert tree.lookup(6) == true: "Did not find 6 in tree.";
        assert tree.lookup(7) == false: "Shouldn't have found 7.";
        System.out.println("Finished test 3...");
    }

    private static String test_serialize() {
        System.out.println("Starting serialize tests...");
        Node<Integer> root = new Node<Integer>(5);
        BinTree<Integer> tree = new BinTree<Integer>(root);

        // insert some values
        tree.insert(4);
        tree.insert(3);
        tree.insert(2);
        tree.insert(1);
        tree.insert(0);

        String tree_str = serialize(root);
        System.out.println(tree_str);
        System.out.println("Finished serialize tests");
        return tree_str;
    }

    private static void test_deserialize(String tree_str) {
        System.out.println("Starting deserialize tests");
        BinTree<Integer> tree = deSerialize(tree_str);

        // tree should be just a linked list
        int h = tree.getHeight(tree.getRoot());
        assert h == 6: "Incorrect Height: " + h;
        assert tree.lookup(1) == true: "Did not find 1 in tree.";
        assert tree.lookup(2) == true: "Did not find 2 in tree.";
        assert tree.lookup(3) == true: "Did not find 3 in tree.";
        assert tree.lookup(4) == true: "Did not find 4 in tree.";
        assert tree.lookup(5) == true: "Did not find 5 in tree.";
        assert tree.lookup(6) == false: "Shouldn't have found 6.";
        System.out.println("Finished deserialize tests");
    }

    public static void main(String []args) {
        // test data tree and node operations
        test1();
        test2();
        test3();

        // test serializing/deserializing
        String tree = test_serialize();
        test_deserialize(tree);
    }

}
