package leetcode.hot100._12_maximumSubarray;

/**
 * <a href="https://leetcode.cn/problems/maximum-subarray/description/?envType=study-plan-v2&envId=top-100-liked">最大子数组和</a>
 * <p>动态规划</p>
 */
public class SolutionOne {
    public int maxSubArray(int[] nums) {
        int length = nums.length;

        // 异常情况
        if (length == 0) {
            return 0;
        }

        // 初始化暂存区
        int[] dp = new int[length + 1];
        int max = dp[0] = nums[0];

        for (int i = 1; i < length; i++) {
            //dp[i] = nums[i] + dp[i-1]
            // 如果当前值加上先前的值变小，先前的值是累赘，抛弃，自立为王
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            // 和先前的最大值比较
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        SolutionOne solutionOne = new SolutionOne();
        System.out.println(solutionOne.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

}
