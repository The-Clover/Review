package leetcode.top100._0_twoSum;

/**
 * <a href="https://leetcode.cn/problems/two-sum/description/?envType=study-plan-v2&envId=top-100-liked">两数之和</a>
 * <p>暴力遍历，简单直接，兜底方案</p>
 */
class SolutionZero {
    public int[] twoSum(int[] nums, int target) {

        // 第一层遍历
        for (int i=0; i<nums.length; i++) {
            // 从第一层结果向后遍历，防止重复遍历，浪费时间
            for (int j=i+1; j<nums.length; j++) {
                // 目标匹配
                if (target - nums[i] == nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        // 匹配失败
        return new int[]{};
    }
}
