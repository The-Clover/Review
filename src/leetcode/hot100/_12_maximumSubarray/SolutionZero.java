package leetcode.hot100._12_maximumSubarray;

/**
 * <a href="https://leetcode.cn/problems/maximum-subarray/description/?envType=study-plan-v2&envId=top-100-liked">最大子数组和</a>
 * <p>普通循环迭代，比动态规划表现还好一点</p>
 */
public class SolutionZero {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, sum = 0;
        for (int num : nums) {
            sum += num;
            if (sum < num) {
                max = Math.max(max, num);
                sum = num;
                continue;
            }
            max = Math.max(max, sum);
        }
        return max;
    }

    public static void main(String[] args) {
        SolutionZero solutionOne = new SolutionZero();
        // 6
        System.out.println(solutionOne.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        // 23
        System.out.println(solutionOne.maxSubArray(new int[]{5, 4, -1, 7, 8}));
    }

}
