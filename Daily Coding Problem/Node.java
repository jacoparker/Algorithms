class Node<E extends Comparable<E>> {
    private E val;
    private Node<E> right;
    private Node<E> left;

    Node(E val, Node<E> right, Node<E> left) {
        this.val = val;
        this.right = right;
        this.left = left;
    }

    Node(E val) {
        this(val, null, null);
    }

    Node() {
        this.val = null;
        this.right = null;
        this.left = null;
    }

    /*** Getters ***/

    public Node<E> getRightChild() {
        return this.right;
    }

    public Node<E> getLeftChild() {
        return this.left;
    }

    public E getValue() {
        return this.val;
    }

    /*** Setters ***/

    public void setValue(E val) {
        this.val = val;
    }

    public void setLeftChild(Node<E> left) {
        this.left = left;
    }

    public void setRightChild(Node<E> right) {
        this.right = right;
    }
}
