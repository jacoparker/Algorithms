// Good morning! Here's your coding interview problem for today.
// This problem was asked by Snapchat.
// Given an array of time intervals (start, end) for classroom lectures
// (possibly overlapping), find the minimum number of rooms required.
// For example, given [(30, 75), (0, 50), (60, 150)], you should return 2.

import java.util.ArrayList;


public class Problem21
{
    private static int sched(int schedule[][])
    {
        ArrayList<Integer[][]> rooms = new ArrayList<Integer[][]>();
        
    }

    public static void main(String[] args)
    {
        int[][] data = new int[3][] {
            {30, 75},
            {0, 50},
            {60, 150}
        }

        int result = sched(data);
        System.out.println("We need " + result + " rooms.")
    }
}
