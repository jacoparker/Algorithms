// Good morning! Here's your coding interview problem for today.
//
// This problem was asked by Amazon.
//
// Implement a stack that has the following methods:
//  - push(val), which pushes an element onto the stack
//  - pop(), which pops off and returns the topmost element of the stack. If 
//    there are no elements in the stack, then it should throw an error or 
//    return null.
//  - max(), which returns the maximum value in the stack currently. If there 
//    are no elements in the stack, then it should throw an error or return 
//    null.
//
// Each method should run in constant time.


class MaxStack
{
    private Stack st;
    private Stack maxes;

    MaxStack()
    {
        st = new Stack();
        maxes = new Stack();
    }

    public Integer pop()
    {
        this.maxes.pop();
        return this.st.pop();
    }

    public void push(int val)
    {
        this.st.push(val);
        
        Integer currMax = this.maxes.peek();
        if (currMax == null || val > currMax) this.maxes.push(val);
        else this.maxes.push(currMax);
    }

    public Integer max()
    {
        return this.maxes.peek();
    }
}

class Stack
{
    class Node
    {
        private Integer val;
        private Node next;

        Node(int val) { this.val = val; this.next = null; }
        public int getVal() { return this.val; }
        public void setVal(int val) { this.val = val; }
        public Node getNext() { return this.next; }
        public void setNext(Node next) { this.next = next; }
    }

    private Node top;

    Stack() { this.top = null; }

    public Integer peek() 
    {
        if (this.top == null) return null;
        return this.top.getVal();
    }

    public Integer pop()
    {
        if (this.top == null) return null;
        
        Node tmp = this.top;
        this.top = tmp.getNext();
        return tmp.getVal();
    }

    public void push(int val)
    {
        if (this.top == null)
            this.top = new Node(val);
        else
        {
            Node newNode = new Node(val);
            newNode.setNext(this.top);
            this.top = newNode;
        }
    }
}


public class Problem43
{
    public static void main(String[] args)
    {
        MaxStack mxst = new MaxStack();
        mxst.push(10);
        mxst.push(11);
        mxst.push(8);
        System.out.println(mxst.max());  // should be 11

        System.out.println(mxst.pop());  // should be 8
        System.out.println(mxst.max());  // should be 11

        mxst.push(20);
        mxst.push(12);
        System.out.println(mxst.max());  // should be 20

        mxst.pop();
        mxst.pop();
        System.out.println(mxst.pop());  // should be 11

        mxst.pop();
        System.out.println(mxst.pop());  // should be null
    }
}
