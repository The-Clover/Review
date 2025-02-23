package leetcode.hot100._9_subarraySumEqualsK;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/subarray-sum-equals-k/description/?envType=study-plan-v2&envId=top-100-liked">和为 K 的子数组</a>
 * <p>双指针滑动窗口(不合适)</p>
 * <p>当数组内存在负数时，无法判断窗口应该扩展还是缩小</p>
 * <p>有可能下一个数是负数，扩展也能起到缩小的作用</p>
 * <p>前缀和</p>
 * <p>先吃（前缀和）后吐（这里可能存在多个组合，所以用key-value记数），凑目标</p>
 */
class Solution {

    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        // nums 可能存在0和负数，导致前缀和计算过程中，结果忽高忽低，产生一个值出现多次
        // 所有需要用Map或者数组记数
        // 由于下面的计算有根据key取value的场景，因此用Map更佳
        Map<Integer, Integer> presumMap = new HashMap<>();

        // 当前缀和计算结果刚好等于k时，k = k + 0，此时需要取key为0对应的1用于+1记数
        presumMap.put(0, 1);
        int presum = 0, count = 0;

        for (int num : nums) {
            // 遍历计算前缀和
            presum += num;

            // 从Map中查找 前缀和 与 目标值的差值
            if (presumMap.containsKey(presum - k)) {
                // 存在则+1
                count += presumMap.get(presum - k);
            }
            // 没匹配到，先缓存起来
            presumMap.put(presum, presumMap.getOrDefault(presum, 0) + 1);
        }
        return count;
    }
}
