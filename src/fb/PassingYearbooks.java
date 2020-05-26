package fb;

import java.io.*;
import java.util.*;

public class PassingYearbooks {

// Add any extra import statements you may need he

        int[] findSignatureCounts(int[] arr) {


            // Write your code here
            // 4 1 3 2

            // b1 b2 b3 b4
            // b2 b4 b3 b1
            // b4 b1 b3 b2
            // b1 b2 b3 b4

            // 2 1 b2 b1
            // 2 1 b1 b2
            // 2 1 b2 b1

            // 1 + max times a number travels to reach it's index
            int[] resultArr = new int[arr.length];

            for (int i =1; i <= arr.length; i++) {
                int count = 1;
                int valueAtCurrentIndex = arr[i-1];
                int j = 0;
                while (valueAtCurrentIndex != i) {
                    j = valueAtCurrentIndex;
                    valueAtCurrentIndex = arr[j-1];
                    count++;
                }
                resultArr[i-1] = count;
            }
            return resultArr;
        }


        // These are the tests we use to determine if the solution is correct.
        // You can add your own at the bottom, but they are otherwise not editable!
        int test_case_number = 1;
        void check(int[] expected, int[] output) {
            int expected_size = expected.length;
            int output_size = output.length;
            boolean result = true;
            if (expected_size != output_size) {
                result = false;
            }
            for (int i = 0; i < Math.min(expected_size, output_size); i++) {
                result &= (output[i] == expected[i]);
            }
            char rightTick = '\u2713';
            char wrongTick = '\u2717';
            if (result) {
                System.out.println(rightTick + " Test #" + test_case_number);
            }
            else {
                System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
                printIntegerArray(expected);
                System.out.print(" Your output: ");
                printIntegerArray(output);
                System.out.println();
            }
            test_case_number++;
        }
        void printIntegerArray(int[] arr) {
            int len = arr.length;
            System.out.print("[");
            for(int i = 0; i < len; i++) {
                if (i != 0) {
                    System.out.print(", ");
                }
                System.out.print(arr[i]);
            }
            System.out.print("]");
        }

        public void run() {
            int n_1 = 2;
            int[] arr_1 = {2, 1};
            int[] expected_1 = {2, 2};
            int[] output_1 = findSignatureCounts(arr_1);
            check(expected_1, output_1);

            int n_2 = 2;
            int[] arr_2 = {1, 2};
            int[] expected_2 = {1, 1};
            int[] output_2 = findSignatureCounts(arr_2);
            check(expected_2, output_2);

            // Add your own test cases here

        }

        public static void main(String[] args) throws IOException {
            //new PassingYearbooks().run();
            String s = "";
            StringBuilder builder = new StringBuilder();
            builder.append(s);
            s.toCharArray();
            char character = 'a';
            int ascii = (int) character;
            System.out.println(ascii);
            char c = (char) ascii;
            System.out.println(c);
        }
}
