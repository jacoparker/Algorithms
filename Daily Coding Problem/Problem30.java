// Good morning! Here's your coding interview problem for today.
// This problem was asked by Facebook.
// You are given an array of non-negative integers that represents a
// two-dimensional elevation map where each element is unit-width wall and the
// integer is the height. Suppose it will rain and all spots between two walls
// get filled up.
//
// Compute how many units of water remain trapped on the map in O(N) time and
// O(1) space.
// For example, given the input [2, 1, 2], we can hold 1 unit of water in the
// middle.
//
// Given the input [3, 0, 1, 3, 0, 5], we can hold 3 units in the first index,
// 2 in the second, and 3 in the fourth index (we cannot hold 5 since it would
// run off to the left), so we can trap 8 units of water.


class Solution
{
    public static int computeTrappedWater(int[] map)
    {
        boolean leftMax = false;
        int left = 0, right = map.length-1, currLeft = 1, currRight = right-1, sum = 0;

        if (map[left] < map[right])
            leftMax = true;

        while (currRight >= currLeft)
        {
            if (leftMax)
            {
                if (map[currLeft] < map[left]) 
                {
                    sum += (map[left] - map[currLeft]);
                    currLeft += 1;
                }
                else
                {
                    left = currLeft;
                    currLeft += 1;
                    if (map[left] > map[right])
                        leftMax = false;
                }
            }
            else
            {
                if (map[currRight] < map[right])
                {
                    sum += (map[right] - map[currRight]);
                    currRight -= 1;
                }
                else
                {
                    right = currRight;
                    currRight -= 1;
                    if (map[left] < map[right])
                        leftMax = true;
                }
            }
        }
        
        return sum;
    }
}


public class Problem30
{
    private static void runTest(int testNum, int[] arr)
    {  
        System.out.println("Running test " + testNum + "...");
        int result = Solution.computeTrappedWater(arr);
        System.out.println("Trapped water: " + result);
        System.out.println("Finished test " + testNum + "...");
    }

    public static void main(String[] args)
    {
        int test1[] = {2,1,2};
        runTest(1, test1);

        int test2[] = {3,0,1,3,0,5};
        runTest(2, test2);

        int test3[] = {1,3,0,3,0,1,3,0,5,2};
        runTest(3, test3);
    }
}
