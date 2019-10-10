// Good morning! Here's your coding interview problem for today.
// This problem was asked by Facebook.
// Given a function that generates perfectly random numbers between 1 and k 
// (inclusive), where k is an input, write a function that shuffles a deck of 
// cards represented as an array using only swaps.
// It should run in O(N) time.
// Hint: Make sure each one of the 52! permutations of the deck is equally 
// likely.

import java.util.Random;


class Solution 
{
    private static Random rand = new Random();

    public static int rng(int k)
    {
        return rand.nextInt(k) + 1;
    }

    public static void shuffle(int[] cards)
    {
        int temp, swap1, swap2, n = cards.length;

        for (int i = 0; i < n; i++)
        {
            swap1 = rng(n) - 1;
            swap2 = rng(n) - 1;
            temp = cards[swap1];
            cards[swap1] = cards[swap2];
            cards[swap2] = temp;
        }
    }
}


public class Problem51
{
    public static void main(String[] args)
    {
        int[] cards = new int[52];
        for (int i = 0; i < 52; i++)
            cards[i] = i+1;

        Solution.shuffle(cards);
        
        for (int i=0; i<51; i++)
            System.out.print(cards[i] + ", ");
        System.out.println(cards[51]);
    }
}
