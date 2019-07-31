// Good morning! Here's your coding interview problem for today.
// This problem was asked by Google.
// Given an array of integers and a number k, where 1 <= k <= length of the
// array, compute the maximum values of each subarray of length k.
// For example, given array = [10, 5, 2, 7, 8, 7] and k = 3, we should get:
//   [10, 7, 8, 8], since:
//  -	10 = max(10, 5, 2)
//  -	7 = max(5, 2, 7)
//  -	8 = max(2, 7, 8)
//  -	8 = max(7, 8, 7)
// Do this in O(n) time and O(k) space. You can modify the input array
// in-place and you do not need to store the results. You can simply print
// them out as you compute them.

class Problem18 {

    private static void maxSubArrayVal(int []arr, int k) {
        int ptr = 0, max;
        while (ptr <= arr.length - k) {
            max = Integer.MIN_VALUE;
            for (int index = ptr; index < k + ptr; index++)
                if (max < arr[index])
                    max = arr[index];
            System.out.println(max);
            ptr += 1;
        }
    }

    public static void main(String []args) {
        // provided test
        // int test1[] = new int[]{10, 5, 2, 7, 8, 7};
        // worst case scenario for a solution which would go off of the
        // max of the last sub array
        // int test2[] = new int[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int test3[] = new int[]{1, 2, 3, 1, 4, 5, 2, 3, 6};
        // maxSubArrayVal(test1, 3);
        maxSubArrayVal(test3, 3);
        // maxSubArrayVal(test2, test2.length);
    }

}
