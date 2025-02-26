package leetcode.hot100._10_slidingWindowMaximum;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/sliding-window-maximum/description/?envType=study-plan-v2&envId=top-100-liked">滑动窗口最大值</a>
 * <p>双指针+双层for循环暴力遍历</p>
 */
public class SolutionZero {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int left = 0;
        int right = k - 1;
        int len = nums.length;

        if (len < k) {
            return new int[]{};
        }

        int[] result = new int[len - k + 1];

        for (int i = 0; i <= len - k; i++) {
            int max = Integer.MIN_VALUE;
            for (int j = left; j <= right; j++) {
                result[i] = max = Math.max(max, nums[j]);
            }
            left++;
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        SolutionZero solutionZero = new SolutionZero();
        System.out.println(Arrays.toString(solutionZero.maxSlidingWindow(new int[]{1, -1}, 1)));
    }
}
