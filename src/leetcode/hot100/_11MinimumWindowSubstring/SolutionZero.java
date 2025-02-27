package leetcode.hot100._11MinimumWindowSubstring;

import java.util.HashMap;
import java.util.Map;

/**
 *<a href="https://leetcode.cn/problems/minimum-window-substring/description/?envType=study-plan-v2&envId=top-100-liked">最小覆盖子串</a>
 *<p>双指针，一个遍历添加，一个遍历收缩</p>
 */
public class SolutionZero {
    public String minWindow(String s, String t) {
        // 参数校验
        if (s == null || t == null || s.isEmpty() || t.isEmpty() || s.length() < t.length()) {
            return "";
        }
        // 根据题目可以得到顺序不论，只要包含所有字符即可
        // 单个字符存在多个的可能性
        Map<Character, Integer> targetMap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            targetMap.put(t.charAt(i), targetMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        // 收集足够的字符后，还需要收缩，满足最小子串的要求
        // 每次只能遍历一个字符，需要记录符合要求的字符，不能声明在循环内，会被重置
        int left = 0, right = 0, start = 0, valid = 0, len = Integer.MAX_VALUE;

        // 收集字符的过程中，需要暂存
        Map<Character, Integer> sourceMap = new HashMap<>();


        for (; right < s.length(); right++) {
            char c = s.charAt(right);
            sourceMap.put(c, sourceMap.getOrDefault(c, 0) + 1);
            if (sourceMap.get(c).equals(targetMap.get(c))) {
                valid++;
            }

            while (valid == targetMap.size()) {
                char r = s.charAt(left);
                sourceMap.put(r, sourceMap.get(r) - 1);
                if (targetMap.containsKey(r) && sourceMap.get(r).compareTo(targetMap.get(r)) < 0) {
                    valid--;
                }

                if (right - left < len) {
                    start = left;
                    len = Math.min(len, right - left + 1);
                }
                left++;
            }
        }

        return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
    }

    public static void main(String[] args) {
        SolutionZero solutionZero = new SolutionZero();
        // cwae
        System.out.println(solutionZero.minWindow("aaaaaaaaaaaabbbbbcdd", "abcdd"));
    }
}
