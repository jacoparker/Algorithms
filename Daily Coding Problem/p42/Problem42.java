// Good morning! Here's your coding interview problem for today.
// This problem was asked by Google.
// Given a list of integers S and a target number k, write a function that 
// returns a subset of S that adds up to k. If such a subset cannot be made, 
// then return null.
// Integers can appear more than once in the list. You may assume all numbers 
// in the list are positive.
// For example, given S = [12, 1, 61, 5, 9, 2] and k = 24, return [12, 9, 2, 1] 
// since it sums up to 24.


import java.util.ArrayList;

class Solution
{
    private static void printBoard(int[][] table)
    {
        for (int i=0, m=table.length; i<m; i++)
        {
            for (int j=0, n=table[0].length; j<n; j++)
                System.out.print(table[i][j]));
            System.out.println();
        }
    }

    private static ArrayList<Integer> backTrack(int[][] table, int[] S, int index)
    {
        int curr = table[0].length;
        ArrayList<Integer> subSet = new ArrayList<>();
        for (int i=index; i > 0; i--)
        {
            if (curr-S[i] >= 0 && table[i][curr-S[i]] != 0) 
            {
                curr -= S[i];
                subSet.add(S[i]);
            }
            else if (curr-S[i] == 0 && table[i][curr-S[i]] == 0)
            {
                subSet.add(S[i]);
                return subSet;
            }
        }
        subSet.add(S[0]);
        return subSet;
    }

    public static ArrayList<Integer> findSum(int[] S, int k)
    {
        int[][] table = new int[S.length][k+1];
        for (int i=0; i<S.length; i++)
            for (int j=0; j<=k; j++)
                table[i][j] = 0;

        if (S[0] <= k) table[0][S[0]] = S[0];

        for (int i=1; i<S.length; i++)
        {
            int j = 0;
            while (j <= k)
            {
                if (table[i-1][j] != 0 && j + S[i] <= k)
                    table[i][j + S[i]] = j + S[i];
                if (table[i-1][j] != 0)
                    table[i][j] = table[i-1][j];
                j += 1;
            }

            if (S[i] <= k)
                table[i][S[i]] = S[i];
        }

        for (int i=0; i<S.length; i++)
        {            
            System.out.println(k);
            if (table[i][k] == k) return backTrack(table, S, i);
        }        
        return null;
    }
}


public class Problem42
{
    public static void main(String[] args)
    {
        // For example, given S = [12, 1, 61, 5, 9, 2] and k = 24, return [12, 9, 2, 1] 

        int S[] = {12, 1, 61, 5, 9, 2};
        ArrayList<Integer> result = Solution.findSum(S, 24);
        for (int num: result)
            System.out.print(num + " ");
    }
}
