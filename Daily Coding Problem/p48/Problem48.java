// Good morning! Here's your coding interview problem for today.
// This problem was asked by Google.
// Given pre-order and in-order traversals of a binary tree, write a function 
// to reconstruct the tree.
// For example, given the following preorder traversal:
// [a, b, d, e, c, f, g]
// And the following inorder traversal:
// [d, b, e, a, f, c, g]
// You should return the following tree:

import java.util.Stack;


class BinTree
{
    class Node
    {
        private Character data;
        private Node left;
        private Node right;

        Node()
        {
            this.data = null;
            this.left = null;
            this.right = null;
        }

        // getters
        public char getData()
        {
            return this.data;
        }

        public Node getLeftChild()
        {
            return this.left;
        }

        public Node getRightChild()
        {
            return this.right;
        }


        // setters
        public void setData(char data)
        {
            this.data = data;
        }

        public void setLeftChild(Node left)
        {
            this.left = left;
        }

        public void setRightChild(Node right)
        {
            this.right = right;
        }
    }


    // private data
    Node root;

    BinTree()
    {
        this.root = null;
    }

    public Node getRoot()
    {
        return this.root;
    }

    public void setRoot(char val)
    {
        Node n = new Node();
        n.setData(val);
        this.root = n;
    }

    private void printHelper(Stack<Node> st)
    {
        if (st.isEmpty()) return;

        Node curr = st.pop(); 
        Node left = curr.getLeftChild();
        Node right = curr.getRightChild();

        System.out.println(curr.getData());

        if (left != null)
        {
            st.add(left);
            this.printHelper(st);
        }
        if (right != null)
        {
            st.add(right);
            this.printHelper(st);
        }
    }

    public void printTree()
    {
        Stack<Node> st = new Stack<>();
        Node curr = this.getRoot();
        st.add(curr);

        this.printHelper(st);
    }

    public void reconstruct(char[] preorder, char[] inorder)
    {
        int n = preorder.length;
        if (n == 0) return;

        char curr = preorder[0], next = curr, tmp;
        Node currNode, prevNode;
        Stack<Node> st = new Stack<>();

        this.setRoot(curr);
        currNode = this.getRoot();
        st.add(currNode);

        for (int i=1; i<n; i++)
        {
            int j = 0;
            next = preorder[i];
            currNode = st.peek();

            while (j < n)
            {
                tmp = inorder[j];
                if (tmp == next)  // case where next is left child of curr
                {
                    Node newNode = new Node();
                    newNode.setData(next);
                    currNode.setLeftChild(newNode);
                    System.out.println("connecting " + currNode.getData() + " to " + next);
                    st.add(newNode);
                    break;
                }
                else if (tmp == currNode.getData())
                {
                    j += 1;
                    prevNode = st.peek();
                    // determine if right child or in a different subtree
                    while (j < n)
                    {
                        if (inorder[j] == prevNode.getData())
                        {
                            // must cascade up the tree to find correct sub tree
                            currNode = prevNode;
                            if (!st.isEmpty())
                            {
                                currNode = prevNode;
                                prevNode = st.pop();
                            }
                            else break;
                        }
                        else if (tmp == next)
                            break;

                        j += 1;
                    }
                    // right child of curr
                    Node newNode = new Node();
                    newNode.setData(next);
                    currNode.setRightChild(newNode);
                    System.out.println("connecting " + currNode.getData() + " to " + next);
                    st.add(newNode);
                }
                j += 1;
            }
        }
    }
}


public class Problem48
{
    public static void main(String[] args)
    {
        char[] preorder = new char[]{'a', 'b', 'd', 'e', 'c', 'f', 'g'};
        char[] inorder = new char[]{'d', 'b', 'e', 'a', 'f', 'c', 'g'};
        BinTree tree = new BinTree();
        tree.reconstruct(preorder, inorder);
        tree.printTree();
    }
}
