package org.workspace;

import org.workspace.annotations.Leetcode;
import org.workspace.annotations.data.structure.Array;
import org.workspace.annotations.pattern.HashTable;
import org.workspace.annotations.status.Completed;
import org.workspace.annotations.difficulty.Easy;

import java.util.*;

/**
 * 1. Two Sum
 * <p>
 * <p>
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * You can return the answer in any order.
 * <p>
 * Example 1:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
 * <p>
 * Example 2:
 * Input: nums = [3,2,4], target = 6
 * Output: [1,2]
 * <p>
 * Example 3:
 * Input: nums = [3,3], target = 6
 * Output: [0,1]
 * <p>
 * Constraints:
 * 2 <= nums.length <= 104
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * Only one valid answer exists.
 * <p>
 * Follow-up: Can you come up with an algorithm that is less than O(n2) time complexity?
 */

@Easy
@Completed
@Array @HashTable
@Leetcode
public class _1 {

    public static void main(String[] args) {
        int target = 9;
        int[] numbers = {2,7,11,15};

        _1 obj = new _1();

        int[] results = obj.twoSum(numbers, target);
        String result = Arrays.stream(results).boxed().map(Object::toString).reduce((i1, i2) -> i1 + ", " + i2).orElse("");
        System.out.println(result);
    }
    public int[] twoSum(int[] nums, int target) {

        Map<Integer, List<Integer>> indices = new HashMap<>(nums.length);

        int i=0;
        while(i<nums.length){
            int requiredCurrTarget = target - nums[i];
            if(indices.containsKey(requiredCurrTarget)){
                return new int[]{indices.get(requiredCurrTarget).remove(0), i};
            }
            indices.computeIfAbsent(nums[i], k -> new ArrayList<>()).add(i);
            i++;
        }

        return new int[0];
    }
}
