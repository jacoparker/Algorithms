// Good morning! Here's your coding interview problem for today.
// This problem was asked by Airbnb.
// Given a list of integers, write a function that returns the largest
// sum of non-adjacent numbers. Numbers can be 0 or negative.
// For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5.
// [5, 1, 1, 5] should return 10, since we pick 5 and 5.
//
// Follow-up: Can you do this in O(N) time and constant space?

import java.lang.Math;


class Problem9 {

    public static int largestNonAdjSumOpt(int list[]) {
        int incl = 0, excl = 0, tmp;
        for (int curr: list) {
            tmp = incl;
            incl = excl + curr;
            excl = Math.max(tmp, excl);
        }
        return Math.max(excl, incl);
    }


    /*** Trivial DP solution - not constant space or linear time ***/
    private static int largestNonAdjSum(int list[], int i /*index*/) {
        if (list.length >= i) return 0;
        int val1 = largestNonAdjSum(list, i+2) + list[i];
        int val2 = largestNonAdjSum(list, i+1);
        return Math.max(val1, val2);
    }

    public static int largestNonAdjSum(int list[]) {
        // use a dynamic programming approach
        return largestNonAdjSum(list, 0);
    }


    /*** Test methods ***/

    public static void test1() {
        int arr[] = new int[]{2, 4, 6, 2, 5};
        int result = largestNonAdjSum(arr);
        assert (result == 13): " Expected 13 got " + result;
    }

    public static void test2() {
        int arr[] = new int[]{5, 1, 1, 5};
        int result = largestNonAdjSum(arr);
        assert (result == 10): " Expected 10 got " + result;
    }

    public static void test3() {
        int arr[] = new int[]{1, 2, 3, 4, 5, 6, 7};
        int result = largestNonAdjSum(arr);
        assert (result == 16): " Expected 16 got " + result;
    }

    /**
    *   Driver program to test largestNonAdjSum
    */
    public static void main(String []args) {
        // test trivial implementation
        test1();
        test2();
        test3();

        // test the optimized solution
        int arr1[] = new int[]{5, 1, 1, 5};
        int arr2[] = new int[]{2, 4, 6, 2, 5};
        int arr3[] = new int[]{5, 5, 10, 40, 50, 35};
        int result;
        result = largestNonAdjSumOpt(arr1);
        assert (result == 10): "Expected 10 got " + result;
        result = largestNonAdjSumOpt(arr2);
        assert (result == 13): "Expected 13 got " + result;
        result = largestNonAdjSumOpt(arr3);
        assert (result == 80): "Expected 80 got " + result;

        int arr4[] = new int[]{23, 12, 13, 21, 11, 6, 16, 16, 5, 25, 16, 18};
        System.out.println(largestNonAdjSumOpt(arr4));
    }
}
