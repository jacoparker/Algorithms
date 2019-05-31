class Node<E> {
    private E val;
    private Node right;
    private Node left;

    Node(E val, Node right, Node left) {
        this.val = val;
        this.right = right;
        this.left = left;
    }

    Node() {
        this.val = null;
        this.right = null;
        this.left = null;
    }

    /*** Getters ***/

    public Node getRightChild() {
        return this.right;
    }

    public Node getLeftChild() {
        return this.left;
    }

    public E getValue() {
        return this.val;
    }

    /*** Setters ***/

    public void setValue(E val) {
        this.val = val;
    }

    public void setLeftChild(Node left) {
        this.left = left;
    }

    public void setRightChild(Node right) {
        this.right = right;
    }
}
