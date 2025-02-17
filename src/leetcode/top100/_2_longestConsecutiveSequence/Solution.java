package leetcode.top100._2_longestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

/**
 * Set去重和contains
 * @see https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-100-liked
 */
class Solution {
    public int longestConsecutive(int[] nums) {
        // 异常情况
        if (nums == null || nums.length == 0)
            return 0;

        // 去重
        Set<Integer> numset = new HashSet<>();
        for (int num : nums) {
            numset.add(num);
        }

        // 存储中间值
        Set<Integer> usedset = new HashSet<>();
        int longest = 0;

        // 遍历去重集合
        for (int num : numset) {
            // usedset需要重复使用，不可以清空，此处为了防重
            if (usedset.contains(num))
                continue;

            // 遍历找队友，计算队列长度
            int nextnum = num + 1;
            int curlongest = 1;
            while (numset.contains(nextnum)) {
                curlongest++;
                nextnum++;
                usedset.add(nextnum);
            }
            // 更新队列长度
            longest = Math.max(longest, curlongest);
        }
        // 返回最大队列长度
        return longest;
    }
}
