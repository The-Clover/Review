package leetcode.top100._2_longestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-100-liked">最长连续序列</a>
 * <p>1、根据示例得到存在重复可能，重复元素不构成连续，故先去重</p>
 * <p>2、HashSet无序，所以在拼接连续序列的时候，可能会取到重复的元素，在遍历的时候还需要再次判重</p>
 * <p>3、记录上一次的序列长度，每次断序的时候都比较更新更大的值</p>
 */
class SolutionZero {
    public int longestConsecutive(int[] nums) {
        // 异常情况
        if (nums == null || nums.length == 0)
            return 0;

        // 去重
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        // 存储中间值
        Set<Integer> usedSet = new HashSet<>();

        int longest = 0;

        // 遍历去重集合
        for (int num : numSet) {
            // usedSet需要重复使用，不可以清空，此处为了防重
            if (usedSet.contains(num))
                continue;

            // 遍历找队友，计算队列长度
            int nextnum = num + 1;
            int curlongest = 1;
            while (numSet.contains(nextnum)) {
                curlongest++;
                nextnum++;
                usedSet.add(nextnum);
            }
            // 更新队列长度
            longest = Math.max(longest, curlongest);
        }
        // 返回最大队列长度
        return longest;
    }
}
