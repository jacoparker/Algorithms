// Good morning! Here's your coding interview problem for today.
//
// This problem was asked by Google.
//
// Given a singly linked list and an integer k, remove the kth last element 
// from the list. k is guaranteed to be smaller than the length of the list.
//
// The list is very long, so making more than one pass is prohibitively
// expensive.
//
// Do this in constant space and in one pass.


import java.util.Iterator;

class Node<E>
{
    private E val;
    private Node<E> next;

    Node() { this(null, null); }
    Node(E val, Node<E> next)
    {
        this.val = val;
        this.next = next;
    }

    public E getVal() { return this.val; }
    public Node<E> getNext() { return this.next; }

    public void setVal(E newVal) { this.val = newVal; }
    public void setNext(Node<E> next) { this.next = next; }
    public boolean hasNext() { return this.getNext() != null; }
}

// singly linked list implementation - simple but all we need for this
class SinglyLinkedList<E> implements Iterable<E>
{
    private Node<E> head; 

    SinglyLinkedList() { this.head = null; }
    SinglyLinkedList(E val) { this.head = new Node<E>(val, null); }

    public Node<E> getHead() { return this.head; }
    public void setHead(Node<E> head) { this.head = head; }
    public void setHead(E val) { this.head = new Node<E>(val, this.head); }

    public void addNode(E val)
    {
        Node<E> curr = this.getHead();
        if (curr == null)
            this.setHead(val);
        else
        {
            while(curr.hasNext())
                curr = curr.getNext();
            curr.setNext(new Node<E>(val, null));
        }
    }

    public Iterator<E> iterator() { return new SinglyLinkedListIterator<E>(this); }
}


class SinglyLinkedListIterator<E> implements Iterator<E> { 
    Node<E> current; 
      
    // initialize pointer to head of the list for iteration 
    public SinglyLinkedListIterator(SinglyLinkedList<E> list) { current = list.getHead(); } 
      
    // returns false if next element does not exist 
    public boolean hasNext() { return current != null; } 
      
    // return current data and update pointer 
    public E next() 
    { 
        E data = current.getVal(); 
        current = current.getNext(); 
        return data; 
    }
} 


class Solution
{
    public static String removeKthNodeFromEnd(SinglyLinkedList<String> sll, int k)
    {
        Node<String> prev = null, itr = sll.getHead();
        Node<String> curr = itr;
        for( int i = 0 ; i < k; i++ )
            itr = itr.getNext();
        while(itr.hasNext())
        {
            prev = curr;
            curr = curr.getNext();
            itr = itr.getNext();
        }
        if (prev != null)
            prev.setNext(curr.getNext());
        else
            sll.setHead(curr.getNext());
        return curr.getVal();
    }
}


public class Problem26
{
    public static void main(String[] args)
    {
        SinglyLinkedList<String> sll = new SinglyLinkedList<String>();
        sll.addNode("Hello");
        sll.addNode("how");
        sll.addNode("are");
        sll.addNode("you");
        sll.addNode("today?");

        String result = Solution.removeKthNodeFromEnd(sll, 2);
        System.out.println("Removed node with value: " + result);

        System.out.println("Printing Linked List after removal...");
        Iterator itr = sll.iterator();
        while (itr.hasNext()) System.out.println(itr.next());
    }
}