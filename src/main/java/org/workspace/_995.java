package org.workspace;

import org.workspace.annotations.difficulty.Hard;
import org.workspace.annotations.status.InProgress;

/**
 * 995. Minimum Number of K Consecutive Bit Flips
 * <p>
 * You are given a binary array nums and an integer k.
 * A k-bit flip is choosing a subarray of length k from nums and simultaneously changing every 0 in the subarray to 1, and every 1 in the subarray to 0.
 * Return the minimum number of k-bit flips required so that there is no 0 in the array. If it is not possible, return -1.
 * A subarray is a contiguous part of an array.
 * <p>
 * Example 1:
 * Input: nums = [0,1,0], k = 1
 * Output: 2
 * Explanation: Flip nums[0], then flip nums[2].
 * <p>
 * Example 2:
 * Input: nums = [1,1,0], k = 2
 * Output: -1
 * Explanation: No matter how we flip subarrays of size 2, we cannot make the array become [1,1,1].
 * <p>
 * Example 3:
 * Input: nums = [0,0,0,1,0,1,1,0], k = 3
 * Output: 3
 * Explanation:
 * Flip nums[0],nums[1],nums[2]: nums becomes [1,1,1,1,0,1,1,0]
 * Flip nums[4],nums[5],nums[6]: nums becomes [1,1,1,1,1,0,0,0]
 * Flip nums[5],nums[6],nums[7]: nums becomes [1,1,1,1,1,1,1,1]
 * <p>
 * Constraints:
 * 1 <= nums.length <= 105
 * 1 <= k <= nums.length
 */

@Hard
@InProgress
public class _995 {

    public static void main(String[] args) {
        int[] nums = {0, 1, 1};
        int k = 2;

        _995 obj = new _995();
        System.out.println(obj.minKBitFlips(nums, k));
    }

    public int minKBitFlips(int[] nums, long k) {
        int n = nums.length;
        int i = 0;
        int flipCount = 0;
        int reverseCounter = 0;
        int reverseSeqCounter = 0;
        int evenOdd = 0;
        while ((n - i) >= k) {
            if ((nums[i] == 0 && reverseCounter <= 0)
                    || ((((reverseSeqCounter & 1) == 0 && nums[i] == 0)
                    || ((reverseSeqCounter & 1) != 0 && nums[i] == 1))
                    && reverseCounter > 0)) {
                reverseCounter = (int) k;
                reverseSeqCounter += k;
                flipCount++;
            }
            reverseCounter--;
            evenOdd = (int) Math.ceil((double) reverseSeqCounter / k);
            reverseSeqCounter = Math.max(reverseSeqCounter - evenOdd, 0);
            i++;
        }

        while (i < n) {
            if ((nums[i] == 0 && reverseCounter <= 0)
                    || ((((reverseSeqCounter & 1) == 0 && nums[i] == 0)
                    || ((reverseSeqCounter & 1) != 0 && nums[i] == 1))
                    && reverseCounter > 0))
                return -1;
            reverseCounter--;
            evenOdd = (int) Math.ceil((double) reverseSeqCounter / k);
            reverseSeqCounter = Math.max(reverseSeqCounter - evenOdd, 0);
            i++;
        }

        return flipCount;
    }

    public int minKBitFlips(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int flipCount = 0;
        int reverseCounter = 0;
        int seqCount = 0;

        while ((n - i) >= k) {
            if ((nums[i] == 0 && reverseCounter <= 0)
                    || ((((reverseCounter & 1) == 0 && nums[i] == 1)
                    || ((reverseCounter & 1) != 0 && nums[i] == 0))
                    && reverseCounter > 0)) {
                reverseCounter += k - seqCount;
                flipCount++;
            }
            seqCount = (int) Math.ceil((double) reverseCounter / k);
            i++;
        }

        while (i < n) {
            if ((nums[i] == 0 && reverseCounter <= 0)
                    || ((((reverseCounter & 1) == 0 && nums[i] == 0)
                    || ((reverseCounter & 1) != 0 && nums[i] == 1))
                    && reverseCounter > 0))
                return -1;
            reverseCounter -= seqCount;
            seqCount = (int) Math.round((double) reverseCounter / k) + 1;
            i++;
        }

        return flipCount;
    }
}
