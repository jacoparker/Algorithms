// Good morning! Here's your coding interview problem for today.
// This problem was asked by Facebook.
// Given a array of numbers representing the stock prices of a company in 
// chronological order, write a function that calculates the maximum profit you 
// could have made from buying and selling that stock once. You must buy before 
// you can sell it.
// For example, given [9, 11, 8, 5, 7, 10], you should return 5, since you 
// could buy the stock at 5 dollars and sell it at 10 dollars.


class Solution
{
    public static int maxProfitOnce(int[] list)
    {
        int currBest = 0, i = 0, j = 1;

        while (j < list.length)
        {
            int temp = list[j] - list[i];
            if (temp > currBest)
                currBest = temp;
            if (list[j] < list[i])
                i = j;
            j += 1;
        }
        return currBest;
    }
}


public class Problem47
{
    public static void main(String[] args)
    {
        int[] list = {9, 11, 8, 5, 7, 10};
        int result = Solution.maxProfitOnce(list);
        System.out.println(result);

        list = new int[]{7, 1, 5, 3, 6, 4};
        result = Solution.maxProfitOnce(list);
        System.out.println(result);

        list = new int[]{7, 6, 5, 4, 3, 2, 1};
        result = Solution.maxProfitOnce(list);
        System.out.println(result);
    }
}
