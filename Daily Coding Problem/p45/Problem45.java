// Good morning! Here's your coding interview problem for today.
// This problem was asked by Two Sigma.
// Using a function rand5() that returns an integer from 1 to 5 (inclusive) 
// with uniform probability, implement a function rand7() that returns an 
// integer from 1 to 7 (inclusive).

import java.util.Random;


class Solution
{
    private static int rand5()
    {
        Random rng = new Random();
        int num = rng.nextInt(5) + 1;
        return num;
    }

    public static int rand7()
    {
        int num;
        while (true)
        {
            num = 5*rand5() + rand5() - 5;
            if (num < 22)
                return num % 7 + 1;
        }
    }
}


public class Problem45
{
    public static void main(String[] args)
    {
        for (int i=0; i < 10; i++)
        {
            System.out.println(Solution.rand7());
        }
    }
}
