package org.workspace;

import org.workspace.annotations.Interview;

import java.util.HashMap;
import java.util.Map;

/**
 * You have given a string that contains the braces (brackets),
 * both opening and closing braces. You have to find the length of the longest balanced subarray.
 * Input : {}{}{()[]()
 * Output: 6
 * Input : {}{}{()[](){}{}]]{}{}
 * Output: 10
 * Input : {}{}(){}(){()[]()
 * Output: 10
 */
@Interview
public class LongestBalancedSubArray {

    public static void main(String[] args) {
        LongestBalancedSubArray obj = new LongestBalancedSubArray();
        int l = obj.longestBraces("{}{}{()[](){}{}]]{}[]{}{}{}{}".toCharArray());
        System.out.println(l);
    }

    private int longestBraces(char[] chars) {

        int longestLength = 0;
        Map<Character, Character> brackets = new HashMap<>(3);
        brackets.put('{', '}');
        brackets.put('(', ')');
        brackets.put('[', ']');

        int i = 0;
        while (brackets.containsValue(chars[i])) {
            i++;
        }

        int j = i;
        while (j < chars.length - 1) {
            if (brackets.get(chars[j]) != null && brackets.get(chars[j]) == chars[j + 1]) {
                j += 2;
            } else {
                longestLength = Math.max(longestLength, (j - i));
                j++;
                i = j;
            }
        }

        longestLength = Math.max(longestLength, (j - i));
        return longestLength;
    }
}
