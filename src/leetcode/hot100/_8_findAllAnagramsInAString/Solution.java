package leetcode.hot100._8_findAllAnagramsInAString;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/find-all-anagrams-in-a-string/description/?envType=study-plan-v2&envId=top-100-liked">找到字符串中所有字母异位词</a>
 * <p>数组-双指针-滑动窗口</p>
 */
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();

        int slen = s.length(), plen = p.length();

        // 异常情况
        if (s == null || s.length() == 0 || p == null || p.length() == 0 || plen > slen)
            return res;

        // 最多26个字母
        int[] parr = new int[26];
        int[] sarr = new int[26];

        // 初始化窗口
        for (int i = 0; i < plen; i++) {
            sarr[s.charAt(i) - 'a']++;
            parr[p.charAt(i) - 'a']++;
        }

        // 双指针构成窗口
        int l = 0, r = plen - 1;

        // 遍历字符串s
        while (r < slen) {

            // 比较窗口内的内容, 如果窗口内容相等,就代表是异位词
            if (Arrays.equals(parr, sarr)) {
                res.add(l);
            }

            // 窗口右移
            r++;
            // r++ 可能导致r == slen，导致数组越界
            if (r != slen) {
                // 窗口有边界
                sarr[s.charAt(r) - 'a']++;
            }
            // 窗口左边界
            sarr[s.charAt(l) - 'a']--;
            l++;
        }
        return res;
    }
}

