// Good morning! Here's your coding interview problem for today.
// This problem was recently asked by Google.
// Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
// For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
// Bonus: Can you do this in one pass?

import java.util.Scanner;
import java.util.Arrays;


public class problem1 {

    private static int[] parse(String filename) {
        File file = new File(filename);
        Scanner scnr = new Scanner(file);
        int values[] = new int[10];
        int index = 0;
        while (scnr.hasNext()) {
            String line = scnr.getLine();
            if (index == values.length) {
                int tmp[] = new int[index*2];
                System.arraycopy(values, 0, tmp, 0, values.length);
                values = tmp;
            }
            int tmp = Integer.parseInt(line);  // assume data is good and does not need further processing
            values[index++] = tmp;
        }
        scnr.close();
        return values;
    }

    public static int[] find_k(int list[], int k) {

        return null;
    }

    public static void main(String []args) {
        if (args.length < 2) {
            System.out.println("Usage: java problem1 file k");
            System.exit(1);
        }

        int k = Integer.parseInt(args[1]);
        int values[] = parse(args[0]);
        for (int value: values) {
            System.out.println("Value: " + value);
        }
        int result[] = find_k(values, k);
            if (result == null) {
                System.out.println("Cannot sum to " + k + " with given numbers.");
            } else {
                System.out.println("The number " + k + " can be summed using: " + result[0] + " and " + result[1]);
            }
    }
}