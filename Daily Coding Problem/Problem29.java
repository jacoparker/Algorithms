// Good morning! Here's your coding interview problem for today.
// This problem was asked by Amazon.
// Run-length encoding is a fast and simple method of encoding strings. The
// basic idea is to represent repeated successive characters as a single count
// and character. For example, the string "AAAABBBCCDAA" would be encoded as
// "4A3B2C1D2A".
//
// Implement run-length encoding and decoding. You can assume the string to
// be encoded have no digits and consists solely of alphabetic characters. You
// can assume the string to be decoded is valid.


class Solution
{
    public static String encode(String message)
    {
        char prev = message.charAt(0);  // the last character we ran into
        int currNum = 1;                // number of curr char in a row
        String encodedMessage = "";

        for (int i=1, n = message.length(); i < n; i++)
        {
            char curr = message.charAt(i);
            if (prev == curr)
            {
                currNum += 1;
            }
            else
            {
                encodedMessage += Integer.toString(currNum) + Character.toString(prev);
                prev = curr;
                currNum = 1;
            }
        }
        encodedMessage += Integer.toString(currNum) + Character.toString(prev);
        return encodedMessage;
    }

    public static String decode(String message)
    {
        String decodedStr = "";
        String currNumStr = "";

        for (int i=0, n=message.length(); i<n; i++)
        {
            char curr = message.charAt(i);
            if (Character.isDigit(curr))
                currNumStr += Character.toString(curr);
            else
            {
                for (int j=0, m=Integer.parseInt(currNumStr); j<m; j++)
                    decodedStr += Character.toString(curr);
                currNumStr = "";
            }
        }
        return decodedStr;
    }
}

public class Problem29
{
    public static void main(String[] args)
    {
        String testStr, result;
        // test encoding and decoding 1
        testStr = "AAAABBBCCDAA";
        System.out.println("Encoding " + testStr);
        result = Solution.encode(testStr);
        System.out.println("Result: " + result);

        System.out.println("Decoding " + result);
        result = Solution.decode(result);
        System.out.println("Result: " + result);

        // test encoding and decoding 2


        // test encoding and decoding 3
    }
}
