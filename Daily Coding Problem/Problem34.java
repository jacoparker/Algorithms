// Good morning! Here's your coding interview problem for today.
//
// This problem was asked by Quora.
//
// Given a string, find the palindrome that can be made by inserting the fewest
// number of characters as possible anywhere in the word. If there is more than
// one palindrome of minimum length that can be made, return the
// lexicographically earliest one (the first one alphabetically).
//
// For example, given the string "race", you should return "ecarace", since we
// can add three letters to it (which is the smallest amount to make a
// palindrome). There are seven other palindromes that can be made from "race"
// by adding three letters, but "ecarace" comes first alphabetically.
// As another example, given the string "google", you should return "elgoogle".


class Solution
{
    public static String palindrome(String word)
    {
        String leftPal = helper(word);
        String rightPal = helper(reverse(word));
        if (rightPal.length() < leftPal.length()) return rightPal;
        else if (rightPal.length() > leftPal.length()) return leftPal;
        else if (rightPal.compareTo(leftPal) == -1) return rightPal;
        else return leftPal;
    }

    private static String reverse(String word)
    {
        String reverse = "";
        for (int i = 0, n = word.length(); i < n; i++)
            reverse = word.charAt(i) + reverse;
        // System.out.println(reverse);
        return reverse;
    }

    private static String helper(String word)
    {
        String reverse = reverse(word).substring(0, word.length()-1);
        // remove unnecessary letters
        int i = 0, j = 0, count = 0, n = word.length();
        while (i < n-1)
        {
            if (reverse.charAt(i) == word.charAt(j))
            {

                i += 1;
                j += 1;
            }
            else
            {
                j = 0;
                i += 1;
                count = i;
            }
        }
        return reverse.substring(0, count) + word;
    }
}


public class Problem34
{
    public static void main(String[] args)
    {
        String word = "google";
        System.out.println(Solution.palindrome(word));
        
        String word2 = "race";
        System.out.println(Solution.palindrome(word2));
    }
}
