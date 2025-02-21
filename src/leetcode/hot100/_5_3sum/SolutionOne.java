package leetcode.hot100._5_3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 双指针
 * @see https://leetcode.cn/problems/3sum/description/?envType=study-plan-v2&envId=top-100-liked
 */
class SolutionOne {
    public List<List<Integer>> threeSum(int[] nums) {
        // 异常
        if (nums == null || nums.length == 0)
            return new ArrayList<>();

        int len = nums.length;

        // 排序
        Arrays.sort(nums);
        // 最终结果
        List<List<Integer>> res = new ArrayList<>();

        // 一找二
        for (int i = 0; i < len - 1; i++) {

            // 保证第一个数和第二个数不相等
            if (i > 0 && nums[i - 1] == nums[i])
                continue;

            // 第二个数和第三个数的和
            int target = -nums[i];

            // 双指针找两数之和（第二个和第三个数）
            int l = i + 1, r = len - 1;
            while (l < r) {
                // 实际两数之和 与 目标值比较，通过调整双指针寻找
                int sum = nums[l] + nums[r];
                if (sum > target)
                    r--;
                else if (sum < target)
                    l++;
                else {
                    // 匹配到第二个数和第三个数

                    // 将三个数字放入结果集合
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));

                    // 当第一组（第二个和第三个数）找到后，同时移动双指针，为寻找下一组做准备
                    l++;
                    r--;

                    // 确保第一个数和第二个数不相等
                    while (l < r && nums[l - 1] == nums[l])
                        l++;
                    // 确保第二个数和第三个数不相等
                    while (l < r && nums[r] == nums[r + 1])
                        r--;
                }
            }
        }
        return res;
    }
}

