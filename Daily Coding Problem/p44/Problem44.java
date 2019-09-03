// Good morning! Here's your coding interview problem for today.
// This problem was asked by Google.
// We can determine how "out of order" an array A is by counting the number of 
// inversions it has. Two elements A[i] and A[j] form an inversion if A[i] > A
// [j] but i < j. That is, a smaller element appears after a larger element.
// Given an array, count the number of inversions it has. Do this faster than O
// (N^2) time.
// You may assume each element in the array is distinct.
// For example, a sorted list has zero inversions. The array [2, 4, 1, 3, 5] 
// has three inversions: (2, 1), (4, 1), and (4, 3). The array [5, 4, 3, 2, 1] 
// has ten inversions: every distinct pair forms an inversion.

// TODO merge sort, count the number of swaps


class Solution
{
    private static int helper(int[] list, int start, int end)
    {
        if (start == end)
            return 0;
        System.out.println("Start: " + start + " End: " + end);
        int count = helper(list, start, (start+end)/2) + helper(list, (start+end)/2 + 1, end);
        int[] sortedList = new int[end - start + 1];
        int index = 0;

        int i = start, j = (start+end) / 2 + 1;
        while (i <= (start+end) / 2 && j <= end)
        {
            if (list[i] > list[j])
            {
                sortedList[index] = list[j++];
                count += 1;
            }
            else
            {
                sortedList[index] = list[i++];
            }
            index += 1;
        }

        while (i <= (start+end)/2)
            sortedList[index++] = list[i++];
        while (j <= end)
            sortedList[index++] = list[j++];

        // copy over sorted array and return
        System.arraycopy(sortedList, 0, list, start, sortedList.length-1);
        return count;
    }

    public static int countInversions(int[] list)
    {
        // consider creating a clone to avoid modifying list in place
        int count = helper(list, 0, list.length-1);
        for (int i: list)
            System.out.print(i + " ");
        System.out.println();
        return count;
    }
}


public class Problem44
{
    public static void main(String[] args)
    {
        int[] test = new int[]{2, 4, 1, 3, 5};
        int result = Solution.countInversions(test);
        System.out.println(result);
        System.out.println();

        test = new int[]{5, 4, 3, 2, 1};
        result = Solution.countInversions(test);
        System.out.println(result);

        test = new int[]{1, 3, 2};
        result = Solution.countInversions(test);
        System.out.println(result);
    }
}
