package IntMultiplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntMultiplication {

    public static void getMinInteger(int num) {
        int[] digitArr = new int[32];
        int i = 2;
        int j = 0;
        while (i < 10 && num > 1) {
            if (num % i == 0) {
                digitArr[j++] = i;
                num = num / i;
                i = 2;
            } else {
                i++;
            }
        }
        if (num > 9) {
            System.out.println(0);
        } else {
            digitArr[j] = num;
            int k=0;
            int digit=1;
            List<Integer> resultList = new ArrayList<>();

            while (k <= j) {

                if (digit * digitArr[k] > 9) {
                    resultList.add(digit);
                    digit = 1;
                } else {
                    digit = digit * digitArr[k];
                    k++;
                }
            }
            resultList.add(digit);
            resultList.sort(Integer::compareTo);

            System.out.println(resultList);

        }
    }

    public static void main(String[] args) {
        /*
        96 -> 2, 48 | 2
        48 -> 2, 24 | 4
        24 -> 2, 12 | 8
        12 -> 2, 6  | 16, 6
        16 -> 2, 8  | 2, 8, 6

         */

        getMinInteger(15);

    }
}

