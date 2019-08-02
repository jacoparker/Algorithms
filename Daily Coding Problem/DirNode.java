class DirNode<E extends Comparable<E>> {

    private E val;
    private ArrayList<DirNode<E>> subDirs;

    /*** Constructors ***/

    // Default constructor
    DirNode() {
        this.val = null;
        this.subDirs = new ArrayList<E>();
    }

    DirNode(E val) {
        this.val = val;
        this.subDirs = new ArrayList<E>();
    }

    /*** Getters ***/
    public ArrayList<E> getSubDirs() {
        return this.subDirs;
    }

    public E getValue() {
        return this.val;
    }

    /*** Setters ***/

    public void setValue(E val) {
        this.val = val;
    }

    public void addDir(E val) {
        DirNode<E> node = new DirNode<E>(val);
        this.subDirs.add(node);
    }
}
