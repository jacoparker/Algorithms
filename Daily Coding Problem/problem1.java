// Good morning! Here's your coding interview problem for today.
// This problem was recently asked by Google.
// Given a list of numbers and a number k, return whether any two numbers from the list add up to k.
// For example, given [10, 15, 3, 7] and k of 17, return true since 10 + 7 is 17.
// Bonus: Can you do this in one pass?

import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.ArrayList;


public class problem1 {

    private static Scanner scnr = null;

    private static HashSet<Integer> parse_single(String filename) {
        File file = new File(filename);
        try {
            Scanner scnr = new Scanner(file);
            HashSet<Integer> values = new HashSet<Integer>();  
            while (scnr.hasNext()) {
                int next = scnr.nextInt();
                values.add(next);  // assume for now that we do not have duplicates
            }
            scnr.close();
            return values;
        } catch (FileNotFoundException e) {
            System.out.println("Could not find that file. Exiting...");
            System.exit(1);
        }
        return null;
    }

    private static ArrayList<HashSet<Integer>> parse_file() { 
        if (scnr == null) {
            System.out.println("Error: scanner must be initialized first. Exiting...");
            System.exit(1);
        }

        ArrayList<HashSet<Integer>> data = new ArrayList<HashSet<Integer>>();
        while (scnr.hasNext()) {
            String line = scnr.nextLine();
            HashSet<Integer> set = new HashSet<Integer>();
            for (String next: line.split(" ")) {
                int tmp = Integer.parseInt(next);
                set.add(tmp);
            }
            data.add(set);
        }
        scnr.close();
        return data;
    }

    public static int[] find_k(HashSet<Integer> set, int k) {
        for (int value: set) {
            if (k-value != value && set.contains(k - value)) {
                return new int[]{value, k-value};
            }
        }
        return null;
    }

    public static void main(String []args) {
        if (args.length < 2) {
            System.out.println("Usage: java problem1 file k");
            System.exit(1);
        }

        int k = Integer.parseInt(args[1]);
        // HashSet<Integer> set = parse(args[0]);
        try {
            File file_obj = new File(args[0]);
            scnr = new Scanner(file_obj);
            ArrayList<HashSet<Integer>> set = parse_file();
            for (HashSet<Integer> subset: set) {
                int result[] = find_k(subset, k);
                if (result == null) {
                    System.out.println("Cannot sum to " + k + " with given numbers for set " + subset.toString() + ".");
                } else {
                    System.out.println("The number " + k + " can be summed with " + subset.toString() + " using: " + result[0] + " and " + result[1]);
                }
            }
            scnr.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not open file. Exiting...");
            System.exit(1);
        }
    }
}