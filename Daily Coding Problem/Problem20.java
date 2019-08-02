// Good morning! Here's your coding interview problem for today.
// This problem was asked by Google.
// Given two singly linked lists that intersect at some point, find the
// intersecting node. The lists are non-cyclical.
// For example, given A = 3 -> 7 -> 8 -> 10 and B = 99 -> 1 -> 8 -> 10,
// return the node with value 8.
// In this example, assume nodes with the same value are the exact same node
// objects.
// Do this in O(M + N) time (where M and N are the lengths of the lists) and
// constant space.

import java.util.Iterator;

class Problem20
{
    public static ListNode<Integer> findIntersection(LinkedList<Integer> listA, LinkedList<Integer> listB)
    {
        LLIterator<Integer> itrA = listA.iterator(), itrB = listB.iterator();
        if (listA.getNumNodes() < listB.getNumNodes())
        {
            int i = listB.getNumNodes() - listA.getNumNodes();
            while (i > 0) itrB.next();
        }
        else if (listA.getNumNodes() > listB.getNumNodes())
        {
            int i = listA.getNumNodes() - listB.getNumNodes();
            while (i > 0) itrA.next();
        }
        int aVal, bVal;
        ListNode<Integer> prev = null;
        while (itrA.hasNext())
        {
            prev = itrA.getNode();
            aVal = itrA.next(); bVal = itrB.next();
            if (aVal == bVal) return prev;
        }
        return null;
    }

    private static void test1()
    {
        LinkedList<Integer> listA = new LinkedList<Integer>();
        listA.add(3);
        listA.add(7);
        listA.add(8);
        listA.add(10);

        LinkedList<Integer> listB = new LinkedList<Integer>();
        listB.add(90);
        listB.add(1);
        listB.add(8);
        listB.add(10);

        ListNode<Integer> result = findIntersection(listA, listB);
        if (result == null) System.out.println("Lists do not intersect.");
        else System.out.println(result.getValue());
    }

    private static void test2()
    {

    }

    private static void test3()
    {

    }

    public static void main(String[] args)
    {
        test1();
        test2();
        test3();
    }
}
