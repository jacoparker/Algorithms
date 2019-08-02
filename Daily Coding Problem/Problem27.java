// Good morning! Here's your coding interview problem for today.
//
// This problem was asked by Facebook.
//
// Given a string of round, curly, and square open and closing brackets, 
// return whether the brackets are balanced (well-formed).
//
// For example, given the string "([])[]({})", you should return true.
//
// Given the string "([)]" or "((()", you should return false.


import java.util.Stack;
import java.util.HashMap;

class Solution
{
    static boolean isWellFormed(String str)
    {
        int numOpenBraces = 0;
        HashMap<Character, Character> openning = new HashMap<Character, Character>();
        openning.put(']', '[');
        openning.put(')', '(');
        openning.put('}', '{');

        Stack<Character> st = new Stack<Character>();
        for (int i = 0, n = str.length(); i < n; i++)
        {
            char c = str.charAt(i);
            if (!openning.containsKey(c)) {
                // System.out.println("pushing : " + c);
                st.push(c);
                numOpenBraces += 1;
            } 
            else if (!st.pop().equals(openning.get(c))) 
                return false; 
            else numOpenBraces -= 1;                
        }
        return st.isEmpty() && numOpenBraces == 0;
    }
}

public class Problem27
{
    public static void main(String[] args)
    {
        String test1 = "([])[]({})";
        String test2 = "([)]";
        String test3 = "((()";
        boolean result;

        System.out.print("Test 1: " + test1 + " is well formed: ");
        result = Solution.isWellFormed(test1);
        System.out.println(result);

        System.out.print("Test 2: " + test2 + " is well formed: ");
        result = Solution.isWellFormed(test2);
        System.out.println(result);

        System.out.print("Test 3: " + test3 + " is well formed: ");
        result = Solution.isWellFormed(test3);
        System.out.println(result);
    }
}
