// Good morning! Here's your coding interview problem for today.
//
// This problem was asked by Google.
//
// The power set of a set is the set of all its subsets. Write a function that, 
// given a set, generates its power set.
//
// For example, given the set {1, 2, 3}, it should return {{}, {1}, {2}, {3}, 
// {1, 2}, {1, 3}, {2, 3}, {1, 2, 3}}.
//
// You may also use a list or array to represent a set.

package P37;

import java.lang.Math;
import java.util.ArrayList;


class Solution
{
    public static ArrayList<ArrayList<Integer>> powerSet(int[] list)
    {
        ArrayList<ArrayList<Integer>> powerSet = new ArrayList<>();
        // add empty set
        powerSet.add(new ArrayList<Integer>());

        // now enumerate possible sets
        int i = 0; int l = 0, prev = -1;
        ArrayList<Integer> tmp, curr;
        double bound = Math.pow(2, list.length-1);
        while (i <= bound)
        {
            curr = powerSet.get(i);

            if (curr.size() == prev) l += 1;
            else
            {
                l = 0;
                prev = curr.size();
            }

            for (int k = curr.size()+l; k < list.length; k++)
            {
                curr = powerSet.get(i);
                for (int j = k; j < list.length; j++)
                {
                    tmp = new ArrayList<>(curr);
                    tmp.add(list[j]);
                    powerSet.add(tmp);
                }
                i += 1;
            }
            i += 1;
        }

        // add the original set
        if (list.length % 2 == 0)
        {
            tmp = new ArrayList<>(powerSet.get((int)bound*2 - 2));
            tmp.add(0, list[0]);
            powerSet.add(tmp);
        }

        return powerSet;
    }
}


public class Problem37
{
    public static void main(String[] args)
    {
        ArrayList<ArrayList<Integer>> result = null;

        // test 1
        int[] t1 = {1, 2, 3};
        result = Solution.powerSet(t1);
        for (ArrayList<Integer> l: result)
            System.out.println(l.toString());

        // test 2
        int[] t2 = {1, 2, 3, 4};
        result = Solution.powerSet(t2);
        for (ArrayList<Integer> l: result)
            System.out.println(l.toString());

        // test 3
        int[] t3 = {1, 2, 3, 4, 5};
        result = Solution.powerSet(t3);
        for (ArrayList<Integer> l: result)
            System.out.println(l.toString());

        System.exit(0);
    }
}
