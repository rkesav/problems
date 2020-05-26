package fb;

import java.util.ArrayList;
import java.util.List;

public class RotationalCipher {
    // Add any helper functions you may need here
    private boolean isLowerCaseLetter(char c) {
        if ((int)c >= (int)'a' && (int)c <= (int)'z') {
            return true;
        }
        return false;
    }

    private boolean isUpperCaseLetter(char c) {
        if ((int)c >= (int)'A' && (int)c <= (int)'Z') {
            return true;
        }
        return false;
    }

    private boolean isNumber(char c) {
        if ((int)c >= (int)'0' && (int)c <= (int)'9') {
            return true;
        }
        return false;
    }

    private char getRotatedChar(char charToBeRotated, char base, int numberOfPossibleChars, int rotationFactor) {
        int relativeOrder = (int)charToBeRotated - (int)base;
        int rotatedCharRelativeOrder = (relativeOrder + rotationFactor) % numberOfPossibleChars;
        int rotatedChar = (int)base + rotatedCharRelativeOrder;
        return (char)rotatedChar;
    }

    String rotationalCipher(String input, int rotationFactor) {
        // Write your code here
        StringBuilder builder = new StringBuilder();

        char[] inputArr = input.toCharArray();
        for (int i=0; i<inputArr.length; i++) {
            char charAtIndex = inputArr[i];
            if(isLowerCaseLetter(charAtIndex)) {
                builder.append(getRotatedChar(charAtIndex, 'a', 26, rotationFactor));
            } else if(isUpperCaseLetter(charAtIndex)) {
                builder.append(getRotatedChar(charAtIndex, 'A', 26, rotationFactor));
            } else if(isNumber(charAtIndex)) {
                builder.append(getRotatedChar(charAtIndex, '0', 10, rotationFactor));
            } else {
                builder.append(charAtIndex);
            }
        }

        return builder.toString();
    }











    // These are the tests we use to determine if the solution is correct.
    // You can add your own at the bottom, but they are otherwise not editable!
    int test_case_number = 1;
    void check(String expected, String output) {
        boolean result = (expected.equals(output));
        char rightTick = '\u2713';
        char wrongTick = '\u2717';
        if (result) {
            System.out.println(rightTick + " Test #" + test_case_number);
        }
        else {
            System.out.print(wrongTick + " Test #" + test_case_number + ": Expected ");
            printString(expected);
            System.out.print(" Your output: ");
            printString(output);
            System.out.println();
        }
        test_case_number++;
    }
    void printString(String str) {
        System.out.print("[\"" + str + "\"]");
    }

    public void run() {
        String input_1 = "All-convoYs-9-be:Alert1.";
        int rotationFactor_1 = 4;
        String expected_1 = "Epp-gsrzsCw-3-fi:Epivx5.";
        String output_1 = rotationalCipher(input_1, rotationFactor_1);
        check(expected_1, output_1);

        String input_2 = "abcdZXYzxy-999.@";
        int rotationFactor_2 = 200;
        String expected_2 = "stuvRPQrpq-999.@";
        String output_2 = rotationalCipher(input_2, rotationFactor_2);
        check(expected_2, output_2);

        // Add your own test cases here

    }

    public static void main(String[] args) {
        new RotationalCipher().run();
        List<Integer> elements = new ArrayList();
        elements.stream().reduce((a, b) -> a * b).get();
        elements.sort(Integer::compareTo);

        List.of(1, 2).stream().max(Integer::compareTo).get();
    }
}
