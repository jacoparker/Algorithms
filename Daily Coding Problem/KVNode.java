class KVNode<E extends Comparable<E>, T> {

    private E key;
    private T val;
    private KVNode<E, T> right;
    private KVNode<E, T> left;

    KVNode() { this(null, null); }

    KVNode(E key, T val) {
        this.key = key;
        this.val = val;
        this.right = null;
        this.left = null;
    }

    /*** Getters ***/

    public KVNode<E, T> getRightChild() {
        return this.right;
    }

    public KVNode<E, T> getLeftChild() {
        return this.left;
    }

    public E getKey() {
        return this.key;
    }

    public T getValue() {
        return this.val;
    }

    /*** Setters ***/

    public void setKey(E key) {
        this.key = key;
    }

    public void setValue(T val) {
        this.val = val;
    }

    public void setLeftChild(KVNode<E, T> left) {
        this.left = left;
    }

    public void setRightChild(KVNode<E, T> right) {
        this.right = right;
    }
}
