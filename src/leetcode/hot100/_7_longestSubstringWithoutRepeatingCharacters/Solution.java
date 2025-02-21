package leetcode.hot100._7_longestSubstringWithoutRepeatingCharacters;

import java.util.HashSet;
import java.util.Set;

/**
 * 滑动窗口-双指针
 * @see https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/?envType=study-plan-v2&envId=top-100-liked
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // 异常情况
        if (s == null || s.length() == 0)
            return 0;

        // 中间态
        Set<Character> winset = new HashSet<>();

        int len = s.length();
        int l = 0, r = 0, max = 0;

        while (l < len && r < len) {
            if (!winset.contains(s.charAt(r))) {
                winset.add(s.charAt(r));
                r++;
                max = Math.max(r - l, max);
            } else {
                winset.remove(s.charAt(l));
                l++;
            }
        }
        return max;
    }
}

