import java.util.Iterator;

public class LinkedList<E extends Comparable<E>> implements Iterable<E>
{
    private ListNode<E> head;
    private int numNodes;

    LinkedList() { this.head = null; this.numNodes = 0; }

    public ListNode<E> getHead() { return this.head; }
    public int getNumNodes() { return this.numNodes; }
    public void setHead(ListNode<E> head) { this.head = head; }
    public void incNumNodes() { this.numNodes += 1; }

    public void add(int index, E value)
    {
        ListNode<E> curr = getHead(), tmp = null;
        if (curr == null)
        {
            this.setHead(new ListNode<E>(value, null));
            this.incNumNodes();
            return;
        }

        while (index-- > 0 && curr.getNext() != null) curr = curr.getNext();
        tmp = curr.getNext();
        curr.setNext(new ListNode<E>(value, tmp));
        this.incNumNodes();
    }

    public void add(E value)
    {
        this.add(getNumNodes(), value);
        this.incNumNodes();
    }

    public E get(int index)
    {
        ListNode<E> curr = this.getHead();
        if (index >= this.getNumNodes()) return null;

        while (index-- > 0) curr = curr.getNext();
        return curr.getValue();
    }

    public E get(E value)
    {
        ListNode<E> curr = this.getHead();
        while (curr != null)
        {
            if (curr.getValue().compareTo(value) == 0)
                return curr.getValue();
            curr = curr.getNext();
        }
        return null;
    }

    public LLIterator<E> iterator() { return new LLIterator<E>(this); }
}

class LLIterator<E extends Comparable<E>> implements Iterator<E>
{
    private ListNode<E> curr;
    LLIterator(LinkedList<E> obj) { this.curr = obj.getHead(); }
    public E next()
    {
        E val = curr.getValue();
        curr = curr.getNext();
        return val;
    }
    public boolean hasNext() { return this.curr.getNext() != null; }

    public ListNode<E> getNode() { return this.curr; }

    // not needed for this problem
    public void remove()
    {
        throw new UnsupportedOperationException();
    }
}

class ListNode<E extends Comparable<E>>
{
    E value;
    ListNode<E> next;

    public E getValue() { return this.value; }
    public ListNode<E> getNext() { return this.next; }

    public void setValue(E value) { this.value = value; }
    public void setNext(ListNode<E> next) { this.next = next; }

    ListNode(E value, ListNode<E> next)
    {
        this.value = value;
        this.next = next;
    }

    ListNode() { this(null, null); }
}
