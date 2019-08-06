// Good morning! Here's your coding interview problem for today.
// This problem was asked by Microsoft.
// Compute the running median of a sequence of numbers. That is, given a stream of numbers, print out the median of the list so far on each new element.
// Recall that the median of an even-numbered list is the average of the two middle numbers.
// For example, given the sequence [2, 1, 5, 7, 2, 0, 5], your algorithm should print out:
// 2
// 1.5
// 2
// 3.5
// 2
// 2
// 2


class Solution
{
    public static void runningMedian(double[] sequence)
    {
        double[] orderedSeq = new double[sequence.length];

        System.out.println(sequence[0]);
        orderedSeq[0] = sequence[0];

        for (int i=1; i < sequence.length; i++)
        {
            int j = 0;
            double curr = sequence[i];

            while (j < i && curr > orderedSeq[j]) j += 1;
            // swap values
            double prev = orderedSeq[j];
            orderedSeq[j++] = curr;
            while (j < i)
            {
                double tmp = orderedSeq[j];
                orderedSeq[j] = prev;
                prev = orderedSeq[j+1];
                j += 1;
            }
            orderedSeq[i] = prev;
            
            if (i % 2 == 1)  // number is even (index odd since starting at 0)
                System.out.println((orderedSeq[i/2]+orderedSeq[i/2 + 1]) / 2);
            else             // number is odd
                System.out.println(orderedSeq[i/2]);
        }

        for (int i=0; i < orderedSeq.length; i++)
            System.out.println("Index " + i + ": " + orderedSeq[i]);
    }
}


public class Problem33
{
    public static void main(String[] args)
    {
        double[] testData = {2, 1, 5, 7, 2, 0, 5};
        Solution.runningMedian(testData);
    }
}

