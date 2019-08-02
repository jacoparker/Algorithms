// Good morning! Here's your coding interview problem for today.
// This problem was asked by Palantir.
// Write an algorithm to justify text. Given a sequence of words and an integer
// line length k, return a list of strings which represents each line, fully
// justified.
//
// More specifically, you should have as many words as possible in each line.
// There should be at least one space between each word. Pad extra spaces when
// necessary so that each line has exactly length k. Spaces should be
// distributed as equally as possible, with the extra spaces, if any,
// distributed starting from the left.
// If you can only fit one word on a line, then you should pad the right-hand
// side with spaces.
//
// Each word is guaranteed not to be longer than k.
//
// For example, given the list of words ["the", "quick", "brown", "fox",
// "jumps", "over", "the", "lazy", "dog"] and k = 16, you should return the
// following:
// ["the  quick brown", # 1 extra space on the left
// "fox  jumps  over", # 2 extra spaces distributed evenly
// "the   lazy   dog"] # 4 extra spaces distributed evenly


import java.util.ArrayList;

class Solution
{
    public static ArrayList<String> justifyText(String[] words, int k)
    {
        ArrayList<String> sol = new ArrayList<>();
        int currNumWords = 1;  // number of words in curr line
        int begin = 0;
        String word = words[0];
        int currLeft = k - word.length() - 1;      // number of spaces left in curr line
        for (int index = 1, n = words.length; index < n; index++)
        {
            int len = words[index].length();
            if (len > currLeft)
            {
                // distribute remaining spaces
                String line = "";
                int spaceBetweenWords = (currLeft+1) / (currNumWords-1);
                int spaceRemainder = (currLeft+1) % (currNumWords-1);
                for (int i = begin; i < index; i++)
                {
                    System.out.println("Begin: " + begin + " between words: " + spaceBetweenWords + " remainder: " + spaceRemainder + " Curr Num Words: " + currNumWords + " Curr left: " + currLeft);
                    line += words[i];
                    for (int j = 0; j <= spaceBetweenWords; j++)
                        line += " ";
                    if (i - begin < spaceRemainder) line += " ";
                }
                sol.add(line);
                currLeft = k - len - 1;
                currNumWords = 1;
                begin = index;
            }
            else if (index == n-1)
            {
                // distribute remaining spaces
                String line = "";
                currLeft -= len;
                currNumWords += 1;
                int spaceBetweenWords = (currLeft) / (currNumWords-1);
                int spaceRemainder = (currLeft) % (currNumWords-1);
                for (int i = begin; i <= index; i++)
                {
                    System.out.println("Begin: " + begin + " between words: " + spaceBetweenWords + " remainder: " + spaceRemainder + " Curr Num Words: " + currNumWords + " Curr left: " + currLeft);
                    line += words[i];
                    for (int j = 0; j <= spaceBetweenWords; j++)
                        line += " ";
                    if (i - begin < spaceRemainder) line += " ";
                }
                sol.add(line);
            }
            else
            {
                // add another word
                currLeft -= (len + 1);
                currNumWords += 1;
            }
        }


        return sol;
    }
}

public class Problem28 
{
    public static void main(String[] args)
    {
        // test 1
        String[] words = {"the", "quick", "brown",
                         "fox", "jumps", "over",
                         "the", "lazy", "dog"};
        ArrayList<String> result = Solution.justifyText(words, 16);
        for (String r: result)
            System.out.println(r);
    }
}
