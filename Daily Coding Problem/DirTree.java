import java.util.Scanner;
import java.util.Stack;

class DirTree<E extends Comparable<E>> {
    private DirNode<E> root;

    /*** Constructors ***/

    // default constructor
    BinTree(String dirStruct) { deSerializeString(dirStruct); }

    /*** Getters ***/

    public DirNode<E> getRoot() {
        return this.root;
    }

    /*** Setters ***/
    public void setRoot(E val) {
        this.root = new DirNode<E>(val);
    }

    public void serialize() {

    }

     private int numberOfTabs(String text) {
        int count = 0;
        int index = 0;
        while (text.charAt(index++) == '\t') {
            count++;
        }
        return count;
    }

    private DirNode<E> deSerializeString(String str) {
        Scanner scnr = new Scanner(str);
        Stack<DirNode<E>> st = new Stack();
        DirNode<E> curr = null;
        int numTabs = 0;

        while (scnr.hasNextLine())
        {
            setRoot(scnr.nextLine());
            curr = getRoot();
            st.push(curr);

            while (!st.empty() && curr != null)
            {
                

                curr = st.pop();
            }
        }
    }
}
