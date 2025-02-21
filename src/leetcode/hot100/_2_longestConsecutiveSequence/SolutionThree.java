package leetcode.hot100._2_longestConsecutiveSequence;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/longest-consecutive-sequence/description/?envType=study-plan-v2&envId=top-100-liked">最长连续序列</a>
 * <p>1、根据示例得到存在重复可能，重复元素不构成连续，故先去重</p>
 * <p>2、HashSet无序，所以在拼接连续序列的时候，可能会取到重复的元素，在遍历的时候还需要再次判重</p>
 * <p>3、记录上一次的序列长度，每次断序的时候都比较更新更大的值</p>
 */
public class SolutionThree {
    public int longestConsecutive(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }

        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }

        int maxLength = 0;

        for (Integer num : numSet) {
            if (!numSet.contains(num - 1)) {
                int last = num;
                while (numSet.contains(++last)) {
                }
                maxLength = Math.max(maxLength, last - num);
            }
        }

        return maxLength;
    }
}
