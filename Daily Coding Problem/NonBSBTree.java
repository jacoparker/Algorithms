import java.lang.Math;


class NonBSBTree<E extends Comparable<E>, T> {

    private KVNode<E, T> root;

    /*** Constructors ***/

    // default constructor
    NonBSBTree() { this.root = new KVNode<E, T>(); }
    NonBSBTree(KVNode<E, T> root) { this.root = root; }

    /*** Getters ***/
    public KVNode<E, T> getRoot() { return this.root; }

    public int getHeight(KVNode<E, T> curr) {
        if (curr == null) return 0;
        return 1 + Math.max(
            getHeight(curr.getLeftChild()),
            getHeight(curr.getRightChild())
        );
    }

    public boolean lookupKey(E key) {
        KVNode<E, T> curr = this.getRoot();
        while (curr != null) {
            if (curr.getKey().compareTo(key) == 0) return true;
            else if (curr.getKey().compareTo(key) < 0)
                curr = curr.getLeftChild();
            else curr = curr.getRightChild();
        }
        return false;
    }

    public T getValueFromKey(E key) {
        KVNode<E, T> curr = this.getRoot();
        while (curr != null) {
            if (curr.getKey().compareTo(key) == 0) return curr.getValue();
            else if (curr.getKey().compareTo(key) < 0)
                curr = curr.getLeftChild();
            else curr = curr.getRightChild();
        }
        return null;
    }

    public void insert(E key, T value) {
        KVNode<E, T> curr = this.getRoot();
        if (curr == null) {
            this.root = new KVNode<E, T>(key, value);
            return;
        } else if (curr.getKey() == null) {
            curr.setKey(key);
            curr.setValue(value);
            return;
        }
        while (true) {
            if (curr.getKey().compareTo(key) <= 0) {
                if (curr.getLeftChild() == null) {
                    curr.setLeftChild( new KVNode<E, T>(key, value) );
                    return;
                } else {
                    curr = curr.getLeftChild();
                }
            } else {
                if (curr.getRightChild() == null) {
                    curr.setRightChild( new KVNode<E, T>(key, value) );
                    return;
                } else {
                    curr = curr.getRightChild();
                }
            }
        }
    }
}
