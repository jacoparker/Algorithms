// The edit distance between two strings refers to the minimum number of
// character insertions, deletions, and substitutions required to change one
// string to the other. 
//
// Given two strings, compute the edit distance between them.


class Solution
{
    public static int editDistance(String w1, String w2)
    {
        int len1 = w1.length(), len2 = w2.length();
        int table[][] = new int[len1+1][len2+1];

        for (int i=0; i <= len1; i++) table[i][0] = 0;
        for (int i=1; i <= len2; i++) table[0][i] = 0;

        for (int i=1; i <= len1; i++) 
        {
            for (int j=1; j <= len2; j++)
            {
                if (w1.charAt(i-1) == w2.charAt(j-1))
                    table[i][j] = table[i-1][j-1];
                else
                {
                    int min = (table[i-1][j] < table[i][j-1]) ? table[i-1][j] : table[i][j-1];
                    min = (min < table[i-1][j-1]) ? min : table[i-1][j-1];
                    table[i][j] = min + 1;
                }
            }
        }

        return table[len1][len2];
    }
}


public class Problem31
{
    private static void runTest(String w1, String w2, int testNum)
    {
        System.out.println("Running test " + testNum + "...");
        int result = Solution.editDistance(w1, w2);
        System.out.println(w1 + " --> " + w2 + ": " + result + " operations.");
        System.out.println("Finished test " + testNum + "...");
    }

    public static void main(String[] args)
    {
        runTest("geek", "gesek", 1);       // test 1
        runTest("hello", "help", 2);       // test 2
        runTest("saturday", "sunday", 3);  // test 3
        runTest("kitten", "sitting", 4);   // test 4
    }
}
