package org.workspace;

import org.workspace.annotations.Leetcode;
import org.workspace.annotations.data.structure.Array;
import org.workspace.annotations.difficulty.Easy;
import org.workspace.annotations.status.Completed;

import java.util.Arrays;

/**
 * 66. Plus One
 * You are given a large integer represented as an integer array digits,
 * where each digits[i] is the ith digit of the integer.
 * The digits are ordered from most significant to least significant in left-to-right order.
 * The large integer does not contain any leading 0's.
 * Increment the large integer by one and return the resulting array of digits.
 *
 * Example 1:
 * Input: digits = [1,2,3]
 * Output: [1,2,4]
 * Explanation: The array represents the integer 123.
 * Incrementing by one gives 123 + 1 = 124.
 * Thus, the result should be [1,2,4].
 *
 * Example 2:
 * Input: digits = [4,3,2,1]
 * Output: [4,3,2,2]
 * Explanation: The array represents the integer 4321.
 * Incrementing by one gives 4321 + 1 = 4322.
 * Thus, the result should be [4,3,2,2].
 *
 * Example 3:
 * Input: digits = [9]
 * Output: [1,0]
 * Explanation: The array represents the integer 9.
 * Incrementing by one gives 9 + 1 = 10.
 * Thus, the result should be [1,0].
 *
 * Constraints:
 * 1 <= digits.length <= 100
 * 0 <= digits[i] <= 9
 * digits does not contain any leading 0's.
 */
@Easy
@Array
@Completed
@Leetcode
public class _66 {

    public int[] plusOne(int[] digits) {

        int i = digits.length-1;
        int addBit;
        int remainder = 1;
        while(i >= 0 && remainder > 0){
            addBit = digits[i] + remainder;
            digits[i] = (addBit)%10;
            remainder = (addBit)/10;
            --i;
        }

        if(remainder > 0){
            int[] plusOne = new int[digits.length + 1];
            System.arraycopy(digits, 0, plusOne, 1, digits.length);
            plusOne[0] = remainder;
            digits = plusOne;
        }

        return digits;
    }
}
