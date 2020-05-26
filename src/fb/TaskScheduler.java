package fb;

import java.util.Arrays;

public class TaskScheduler {
    public int leastInterval(char[] tasks, int n) {
        //(3-1) * 3 + 2 = 8
        //(maxCount-1) * (n+1) + numTaskWithMaxCount

        int[] countArr = new int[26];
        int maxCount = 0;
        int numTasksWithMaxCount = 0;
        int numDistinctTasks = 0;

        for (int i = 0; i < tasks.length; i++) {
            countArr[tasks[i] - 'A']++;
            maxCount = Math.max(countArr[tasks[i] - 'A'], maxCount);
            if (countArr[tasks[i] - 'A'] == 1) {
                numDistinctTasks++;
            }
        }

        for (int j = 0; j < 26; j++) {
            if (countArr[j] == maxCount) {
                numTasksWithMaxCount++;
            }
        }

        int result = ((maxCount-1) * (n+1)) + numTasksWithMaxCount;
        String s = "";
        char[] c1 = s.toCharArray();
        Arrays.sort(c1);
        return result > tasks.length ? result : tasks.length;

    }
}
