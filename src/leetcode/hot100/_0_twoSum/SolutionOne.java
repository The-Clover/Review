package leetcode.hot100._0_twoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/two-sum/description/?envType=study-plan-v2&envId=top-100-liked">两数之和</a>
 * <p>用Hash表的空间换时间，性能更好</p>
 * <p>没有一开始就将所有的值都存到Map中，避免了不必要的运算</p>
 * <p>题目本身不要求找出所有的可能性，所以哈希冲突不影响，如果要求找出所有的可能性，哈希结构不适应</p>
 */
class SolutionOne {
    public int[] twoSum(int[] nums, int target) {
        // 异常情况
        if (nums == null || nums.length == 0)
            return new int[] {};

        // 空间换时间
        Map<Integer, Integer> map = new HashMap<>();

        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            // 在Map里找另一半，找不到，把自己放进去，候选
            if (map.containsKey(target - nums[i])) {
                return new int[] { map.get(target - nums[i]), i };
            }
            map.put(nums[i], i);
        }
        return new int[] {};
    }
}
