// Good morning! Here's your coding interview problem for today.
// This problem was asked by Google.
// Suppose we represent our file system by a string in the following manner:
// The string "dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext" represents:
// dir
//     subdir1
//     subdir2
//         file.ext
// The directory dir contains an empty sub-directory subdir1 and a
// sub-directory subdir2 containing a file file.ext.
// The string "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"
// represents:
// dir
//     subdir1
//         file1.ext
//         subsubdir1
//     subdir2
//         subsubdir2
//             file2.ext
// The directory dir contains two sub-directories subdir1 and subdir2.
// subdir1 contains a file file1.ext and an empty second-level sub-directory
// subsubdir1. subdir2 contains a second-level sub-directory subsubdir2
// containing a file file2.ext.
// We are interested in finding the longest (number of characters)
// absolute path to a file within our file system. For example, in the second
// example above, the longest absolute path is "dir/subdir2/subsubdir2/file2.ext",
//  and its length is 32 (not including the double quotes).
// Given a string representing the file system in the above format,
// return the length of the longest absolute path to a file in the abstracted
// file system. If there is no file in the system, return 0.
// Note:
// The name of a file contains at least a period and an extension.
// The name of a directory or sub-directory will not contain a period.

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Stack;


class Problem17 {

    private static int numberOfTabs(String text) {
       int count = 0;
       int index = 0;
       while (text.charAt(index++) == '\t') {
           count++;
       }
       return count;
    }

    private static String getLongestAbsPath(Scanner scnr) {
        String currBest = "", fullPath = "", curr = "";
        int prevTabNum = 0, currTabLen = 0, currMax = 0, currStrLen = 0;
        ArrayList<Integer> strLengths = new ArrayList<Integer>();

        // read in the root, 'dir' (assuming it starts with root)
        curr = scnr.nextLine() + "/";
        strLengths.add(curr.length());
        currMax += curr.length();
        fullPath = curr;

        // TODO combine the else if and else, and switch array list to a stack

        while (scnr.hasNextLine()) {
            curr = scnr.nextLine();
            currTabLen = numberOfTabs(curr);
            // detect if file or dir
            curr = curr.trim();
            if (!curr.contains(".")) curr = curr + "/";
            // determine whether this is in a parent dir or the prev dir
            if (currTabLen > prevTabNum) {
                // a file or dir inside of the previous directory
                strLengths.add(curr.length());
                currStrLen += curr.length();
                fullPath += curr;
            } else if (currTabLen == prevTabNum) {
                // dir in same parent as last dir or file
                int prevLen = strLengths.remove(strLengths.size()-1);
                fullPath = fullPath.substring(0, fullPath.length() - prevLen);
                currStrLen = currStrLen - prevLen + curr.length();
                fullPath += curr;
                strLengths.add(curr.length());
            } else {
                // dir higher up in hierarchy than prev
                int sum = 0;
                for (int i=0; i<=prevTabNum-currTabLen; i++) {
                    sum += strLengths.remove(strLengths.size()-i-1);
                }
                currStrLen = currStrLen - sum + curr.length();
                fullPath = fullPath.substring(0, fullPath.length()-sum);
                fullPath += curr;
                strLengths.add(curr.length());
            }
            prevTabNum = currTabLen;
            if (currMax < currStrLen) {
                currMax = currStrLen;
                currBest = fullPath;
            }
        }
        return currBest;
    }

    public static void main(String []args) {
        String s = "dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext";
        Scanner scnr = new Scanner(s);
        // while (scnr.hasNextLine()) {
        //     System.out.println(scnr.nextLine());
        // }

        String result = getLongestAbsPath(scnr);
        System.out.println("Longest path: " + result);
        System.out.println("Path length: " + result.length());
    }

}
