class BinTree<E> {

    private Node root;
    private int height;

    // constructor
    BinTree(Node root) {
        this.root = root;
        this.height = 1;
    }

    /*** Getters ***/

    public Node getRoot() {
        return this.root;
    }

    public int getHeight() {
        return this.height;
    }

    /**
     *
     *
     */
    private void incHeight(int new) {
        this.height += 1;
    }

    public boolean DFS(E value) {

    }

    public boolean BFS(E value) {

    }

    public void insert(E value) {

    }

    public void serialize(String filename) {

    }

    public Node deSerialize()
}
