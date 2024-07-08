package org.workspace;

import org.workspace.annotations.Leetcode;
import org.workspace.annotations.data.structure.Array;
import org.workspace.annotations.difficulty.Easy;
import org.workspace.annotations.status.Completed;

import java.util.Objects;

/**
 * 14. Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * <p>
 * Example 2:
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * <p>
 * Constraints:
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 */

@Easy
@Completed
@Leetcode
public class _14 {

    public static void main(String[] args) {
        String[] strs = {"flower","flow","flight"};
        _14 obj = new _14();

        System.out.println(obj.longestCommonPrefix(strs));
    }
    public String longestCommonPrefix(String[] strs) {
        if(Objects.isNull(strs))
            return "";

        String prefix = strs[0];
        for(int i=1;i< strs.length;i++){
            while(strs[i].indexOf(prefix)!=0){
                prefix = prefix.substring(0, prefix.length()-1);
                if(prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }
}
