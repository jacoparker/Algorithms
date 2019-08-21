// Good morning! Here's your coding interview problem for today.
//
// This problem was asked by Microsoft.
//
// You have an N by N board. Write a function that, given N, returns the number 
// of possible arrangements of the board where N queens can be placed on the 
// board without threatening each other, i.e. no two queens share the same row, 
// column, or diagonal.


package p38;

import java.util.ArrayList;


class Solution
{
    private static boolean checkDiagonals(int row, int col, int n, Integer[] placedQueen)
    {
        int i = 0;
        while (row + i < n && col + i < n)
        {
            if (placedQueen[0] == row+i && placedQueen[1] == col+i)
                return true;
            i += 1;
        }
        i = 0;
        while (row - i >= 0 && col + i < n)
        {
            if (placedQueen[0] == row-i && placedQueen[1] == col+i)
                return true;
            i += 1;
        }
        i = 0;
        while (row + i < n && col - i >= 0)
        {
            if (placedQueen[0] == row+i && placedQueen[1] == col-i)
                return true;
            i += 1;
        }
        i = 0;
        while (row - i >= 0 && col - i >= 0)
        {
            if (placedQueen[0] == row-i && placedQueen[1] == col-i)
                return true;
            i += 1;
        }
        return false;
    }

    public static int nQueens(int n)
    {
        int i = 0, j = 0, count = 0;
        ArrayList<Integer []> placedQueens = new ArrayList<>();

        for (int k=0; k<n; k++)
        {
            i = 1; j = 0;
            placedQueens.add(new Integer[]{0, k});
            // check if queen present in another column or row
            while (!placedQueens.isEmpty())
            {
                for (Integer[] curr: placedQueens)
                {
                    if (j >= n) break;
                    if (checkDiagonals(i, j, n, curr)) j += 1;
                    if (curr[1] == j) j += 1;
                    if (checkDiagonals(i, j, n, curr)) j += 1;
                }
                if (j < n)
                {
                    if (i == n-1)
                    {
                        count += 1;
                        j += 1;
                    }
                    else
                    {
                        placedQueens.add(new Integer[]{i, j});
                        i += 1;
                        j = 0;
                    }
                }
                else
                {
                    Integer[] tmp = placedQueens.remove(placedQueens.size()-1);
                    i = tmp[0];
                    j = tmp[1] + 1;
                }
            }
        }
        return count;
    }

    // public static int numNQueens(int n)
    // {
    //     boolean[][] board = new boolean[n][n];

    //     return 0;
    // }
}


public class Problem38
{
    public static void main(String[] args)
    {
        int n = 4;
        int result = Solution.nQueens(n);
        System.out.println("Result: " + result);

        System.exit(0);  // for vs code debugging
    }
}
