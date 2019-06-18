import java.lang.Math;


class BinTree<E extends Comparable<E>> {

    private Node<E> root;

    /*** Constructors ***/

    // default constructor
    BinTree() { this.root = new Node<E>(); }

    BinTree(Node<E> root) { this.root = root; }

    /*** Getters ***/

    public Node<E> getRoot() {
        return this.root;
    }

    public int getHeight(Node<E> curr) {
        if (curr == null) return 0;
        return 1 + Math.max(
            getHeight(curr.getLeftChild()),
            getHeight(curr.getRightChild())
        );
    }

    /*** Traversal algos - TODO ***/

    // public boolean DFS(E value) {
    //
    // }

    // public boolean BFS(E value) {
    //
    // }

    public boolean lookup(E value) {
        Node<E> curr = this.getRoot();
        while (curr != null) {
            if (curr.getValue().compareTo(value) == 0) return true;
            else if (curr.getValue().compareTo(value) < 0)
                curr = curr.getLeftChild();
            else curr = curr.getRightChild();
        }
        return false;
    }

    public void insert(E value) {
        Node<E> curr = this.getRoot();
        if (curr == null) {
            this.root = new Node<E>(value);
            return;
        } else if (curr.getValue() == null) {
            curr.setValue(value);
            return;
        }
        while (true) {
            if (curr.getValue().compareTo(value) < 0) {
                if (curr.getLeftChild() == null) {
                    curr.setLeftChild( new Node<E>(value) );
                    return;
                } else {
                    curr = curr.getLeftChild();
                }
            } else {
                if (curr.getRightChild() == null) {
                    curr.setRightChild( new Node<E>(value) );
                    return;
                } else {
                    curr = curr.getRightChild();
                }
            }
        }
    }
}
