package org.workspace;

import org.workspace.annotations.Leetcode;
import org.workspace.annotations.difficulty.Easy;
import org.workspace.annotations.status.Completed;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * 20. Valid Parentheses
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 *
 * Example 1:
 * Input: s = "()"
 * Output: true
 *
 * Example 2:
 * Input: s = "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: s = "(]"
 * Output: false
 *
 * Constraints:
 * 1 <= s.length <= 104
 * s consists of parentheses only '()[]{}'.
 */

@Easy
@Completed
@Leetcode
public class _20 {

    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>(s.length());

        char checkChar;
        for(char c : s.toCharArray()){
            checkChar = stack.isEmpty()?'.':stack.peek();
            if(c == '(' || c == '{' || c == '[') {
                stack.push(c);
            }else if((c == ')' && checkChar != '(') || (c=='}' && checkChar != '{') || (c==']' && checkChar!='['))
                return false;
            else
                stack.pop();
        }

        return stack.isEmpty();
    }
}
