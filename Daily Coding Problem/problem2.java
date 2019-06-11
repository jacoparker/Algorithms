// Good morning! Here's your coding interview problem for today.
// This problem was asked by Uber.
// Given an array of integers, return a new array such that each element at index i
// of the new array is the product of all the numbers in the original array except the one at i.
// For example, if our input was [1, 2, 3, 4, 5], the expected output would be [120, 60, 40, 30, 24].
// If our input was [3, 2, 1], the expected output would be [2, 3, 6].
// Follow-up: what if you can't use division?

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


public class problem2 {

    private static ArrayList<Integer[]> parse(Scanner scnr) {
        ArrayList<Integer[]> list = new ArrayList<Integer[]>();
        while (scnr.hasNext()) {
            String line = scnr.nextLine();
            Integer tmp[] = new Integer[10];
            int index = 0;
            for (String num_str: line.split(" ")) {
                int num = Integer.parseInt(num_str);
                tmp[index++] = num;
            }
            list.add(tmp);
        }
        scnr.close();
        return list;
    }

    /**
     * Function to multiply ith indexed element by all other
     * elements other than itself and return the newly created
     * list.
     * 
     * @param values
     * @return
     */
    private static Integer[] mult(Integer values[]) {
        // solution could be solved using division,
        // but we will just complete with the bonus
        // challenge included.

        // use a dynamic programming approach
        

        return null;  // TODO
    }

    public static void main(String []args) {
        if (args.length < 1) {
            System.out.println("Usage: problem2 <file>");
            System.exit(1);
        }
        try {
            File file_obj = new File(args[0]);
            Scanner scnr = new Scanner(file_obj);
            ArrayList<Integer[]> data = parse(scnr);
            for (Integer list[]: data) {
                String tmp = "";
                for (int i=0; i<list.length; i++) {
                    tmp += "Number " + i + ": " + list[i] + " ";
                }
                System.out.println(tmp);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not open that file. Exiting...");
            System.exit(1);
        }
    }
}