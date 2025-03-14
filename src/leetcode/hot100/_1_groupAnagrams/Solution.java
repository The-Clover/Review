package leetcode.hot100._1_groupAnagrams;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/group-anagrams/description/?envType=study-plan-v2&envId=top-100-liked">字母异位词分组</a>
 * <p>异位词，只有顺序不一样，先排序，再分组（key为排序后的词）</p>
 */
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // 异常情况
        if (strs == null || strs.length == 0) {
            return new ArrayList();
        }
        // Map
        Map<String, List<String>> resultMap = new HashMap<String, List<String>>();
        // 遍历数组
        for (String str : strs) {
            // 字符串重排序，确定key
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            // 根据key获取list
            List<String> list = resultMap.getOrDefault(key, new ArrayList<>());
            // 这里str貌似会重复
            list.add(str);
            resultMap.put(key, list);
        }
        return new ArrayList<>(resultMap.values());
    }
}