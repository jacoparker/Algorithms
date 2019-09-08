// Good morning! Here's your coding interview problem for today.
// This problem was asked by Amazon.
// Given a string, find the longest palindromic contiguous substring. If there 
// are more than one with the maximum length, return any one.
// For example, the longest palindromic substring of "aabcdcb" is "bcdcb". The 
// longest palindromic substring of "bananas" is "anana" w.


class Solution
{
    private static String helper(String word, int i, int j)
    {
        String curr = "";
        int n = word.length();
        while (i >= 0 && j < n)
        {
            if (word.charAt(i) == word.charAt(j))
            {
                curr = word.substring(i, j+1);
                i -= 1;
                j += 1;
            }
            else break;
        }
        return curr;
    }

    public static String palindrome(String word)
    {
        String maxPal = "";
        int maxLen = 0;

        for (int i=0, n=word.length(); i<n; i++)
        {
            String currMax = helper(word, i, i);
            if (currMax.length() > maxLen)
            {
                maxLen = currMax.length();
                maxPal = currMax;
            }

            currMax = helper(word, i, i+1);
            if (currMax.length() > maxLen)
            {
                maxLen = currMax.length();
                maxPal = currMax;
            }

            currMax = helper(word, i-1, i);
            if (currMax.length() > maxLen)
            {
                maxLen = currMax.length();
                maxPal = currMax;
            }
        }
        return maxPal;
    }
}


public class Problem46
{
    public static void main(String[] args)
    {
        String word;
        
        // test 1 - aabcdcb - expect bcdcb
        word = "aabcdcb";
        System.out.println(Solution.palindrome(word));

        // test 2 - bananas - expect anana
        word = "bananas";
        System.out.println(Solution.palindrome(word));

        // test 3 - mammal - expect amma
        word = "mammal";
        System.out.println(Solution.palindrome(word));
    }
}
