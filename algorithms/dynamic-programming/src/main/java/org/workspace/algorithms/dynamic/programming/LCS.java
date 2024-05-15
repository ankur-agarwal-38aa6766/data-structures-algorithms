package org.workspace.algorithms.dynamic.programming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;

/**
 * @author Ankur Agarwal
 * </p>
 * The longest common subsequence (LCS) is defined as the longest subsequence,
 * which is common in all given input sequences.
 */
public class LCS {

    /**
     * Greedy Algorithm approach, using recursion
     * Time Complexity O(2^(l1+l2))
     * Space Complexity O(1)
     */
    private int lcs(char[] str1, char[] str2, int l1, int l2) {

        if (l1 <= 0 || l2 <= 0) {
            return 0;
        } else if (str1[l1 - 1] == str2[l2 - 1]) {
            return lcs(str1, str2, l1 - 1, l2 - 1) + 1;
        } else {
            return Math.max(lcs(str1, str2, l1 - 1, l2),
                    lcs(str1, str2, l1, l2 - 1));
        }
    }

    /**
     * Top-Down approach, using memorization
     * Time Complexity O(l1*l2)
     * Space Complexity O(l1*l2)
     */
    private int lcs(char[] str1, char[] str2, int l1, int l2, int[][] memory) {

        if (l1 <= 0 || l2 <= 0) {
            return 0;
        } else if (memory[l1][l2] == -1 && str1[l1 - 1] == str2[l2 - 1]) {
            memory[l1][l2] = lcs(str1, str2, l1 - 1, l2 - 1, memory) + 1;
        } else if (memory[l1][l2] == -1) {
            memory[l1][l2] = Math.max(lcs(str1, str2, l1 - 1, l2, memory),
                    lcs(str1, str2, l1, l2 - 1, memory));
        }
        return memory[l1][l2];
    }

    /**
     * Bottom-Up approach, using tabulation
     * Time Complexity O(l1*l2)
     * Space Complexity O(l2)
     */
    private int lcs(char[] str1, char[] str2) {

        int l1 = str1.length;
        int l2 = str2.length;
        int[] previousMemory = new int[l2 + 1];
        int[] currentMemory = new int[l2 + 1];

        for (int i = 1; i <= l1; i++) {
            for (int j = 1; j <= l2; j++) {
                if (str1[i - 1] == str2[j - 1])
                    currentMemory[j] = previousMemory[j - 1] + 1;
                else
                    currentMemory[j] = Math.max(currentMemory[j - 1], previousMemory[j]);
            }
            previousMemory = Arrays.copyOf(currentMemory, l2 + 1);
        }

        return currentMemory[l2];
    }

    private void printOutput(String message, int output, long startTime) {
        long endTime = System.currentTimeMillis();
        System.out.printf("%s :: Output : %s :: Time Elapsed : %s \n", message, output, (endTime - startTime));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        LCS obj = new LCS();
        while (T-- > 0) {
            String s1 = sc.next(Pattern.compile("\\S+"));
            String s2 = sc.next(Pattern.compile("\\S+"));

            Runnable t1 = () -> {
                long startTime = System.currentTimeMillis();
                int output = obj.lcs(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length());
                obj.printOutput("With recursion", output, startTime);
            };

            Runnable t2 = () -> {
                long startTime = System.currentTimeMillis();
                int[][] memory = new int[s1.length() + 1][s2.length() + 1];
                Arrays.stream(memory)
                        .forEach(singleSetMemory -> Arrays.fill(singleSetMemory, -1));
                int output = obj.lcs(s1.toCharArray(), s2.toCharArray(), s1.length(), s2.length(), memory);
                obj.printOutput("With Top-Down Approach", output, startTime);
            };

            Runnable t3 = () -> {
                long startTime = System.currentTimeMillis();
                int output = obj.lcs(s1.toCharArray(), s2.toCharArray());
                obj.printOutput("With Bottom-Up Approach", output, startTime);
            };

            ExecutorService executorService = Executors.newFixedThreadPool(3);
            executorService.execute(t1);
            executorService.execute(t2);
            executorService.execute(t3);
        }
    }
}
