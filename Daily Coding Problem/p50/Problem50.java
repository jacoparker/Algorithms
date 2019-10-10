// Good morning! Here's your coding interview problem for today.
// This problem was asked by Microsoft.
// Suppose an arithmetic expression is given as a binary tree. Each leaf is an 
// integer and each internal node is one of '+', '−', '∗', or '/'.
// Given the root to such a tree, write a function to evaluate it.


class Node
{
    private String data;
    private Node left;
    private Node right;

    Node()
    {
        this.data = null;
        this.left = null;
        this.right = null;
    }

    // getters
    public String getData()
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
    public void setData(String data)
    {
        this.data = data;
    }

    public void setLeftChild(String left)
    {
        this.left = new Node();
        this.left.setData(left);
    }

    public void setRightChild(String right)
    {
        this.right = new Node();
        this.right.setData(right);
    }
}


class BinTree
{
    // private data
    Node root;  // must have an operation and two numbers

    BinTree()
    {
        this.root = null;
    }

    public Node getRoot()
    {
        return this.root;
    }

    public void setRoot(String val)
    {
        Node n = new Node();
        n.setData(val);
        this.root = n;
    }

    public void printTree()
    {
        return;
    }
}


class Solution
{
    public static double evaluateArithmeticTree(BinTree tree)
    {
        return helper(tree.getRoot());
    }
    
    private static double helper(Node node)
    {
        if (node.getLeftChild() == null && node.getRightChild() == null)
        {
            // leaf node
            return Double.parseDouble(node.getData());
        }
        else 
        {
            double leftTreeEvaluation = helper(node.getLeftChild());

            // inner node - has an operation as data which we cast to char
            // here we are assuming there is good data!
            switch (node.getData().charAt(0))
            {
                case '+':
                    return leftTreeEvaluation + helper(node.getRightChild());
                case '-':
                    return leftTreeEvaluation - helper(node.getRightChild());
                case '*':
                    return leftTreeEvaluation * helper(node.getRightChild());
                case '/':
                    // hope that there is no divide by zero error....
                    return leftTreeEvaluation / helper(node.getRightChild());
                default:
                    System.out.println("Invalid Operation found in arithmetic"
                    + " tree: " + node.getData().charAt(0));
                    System.exit(1);
            }
        }

        return 0.0;  // def wrong...
    }
}


public class Problem50
{
    public static void main(String[] args)
    {
        BinTree tree = new BinTree();
        tree.setRoot("*");
        Node curr = tree.getRoot();
        curr.setLeftChild("30");
        curr.setRightChild("2");

        // should evaluate to 30*2 = 60
        System.out.println("This tree evaluates to: " 
            + Solution.evaluateArithmeticTree(tree));

        // more complex testing
        BinTree tree2 = new BinTree();
        tree2.setRoot("+");
        curr = tree2.getRoot();
        curr.setLeftChild("*");
        curr.setRightChild("4");

        curr = curr.getLeftChild();
        curr.setLeftChild("2");
        curr.setRightChild("-");

        curr = curr.getRightChild();
        curr.setLeftChild("2");
        curr.setRightChild("-3");

        // should evaluate to 2*(2 - -3) + 4 = 14
        System.out.println("This tree evaluates to: " 
        + Solution.evaluateArithmeticTree(tree2));
    }
}
