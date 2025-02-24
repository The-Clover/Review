package leetcode.hot100._5_3sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/3sum/description/?envType=study-plan-v2&envId=top-100-liked">三数之和</a>
 * <p>三层遍历（暴力）</p>
 */
class SolutionZero {
    public List<List<Integer>> threeSum(int[] nums) {
        // 异常检查
        if (nums == null || nums.length < 3)
            return new ArrayList<>();

        // 最终结果
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;

        // 对数组进行排序，排序后，重复的都挨着
        // 必须要排序，不然无法避免重复
        Arrays.sort(nums);

        // 一找二
        for (int i = 0; i < len - 2; i++) {
            // 跳过重复的第一个数
            if (i > 0 && nums[i] == nums[i - 1])
                continue;
            for (int j = i + 1; j < len - 1; j++) {
                // 跳过重复的第二个数
                if (j > i + 1 && nums[j] == nums[j - 1])
                    continue;

                int third = -nums[i] - nums[j];

                for (int k = j + 1; k < len; k++) {
                    // 保证第一个数和第二个数不相等
                    if (nums[k] == third) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                        break;
                    }
                    // 跳过重复的第三个数
                    while (k < len - 1 && nums[k] == nums[k + 1]) {
                        k++;
                    }
                }
            }
        }
        return res;
    }
}
