package leetcode.hot100._13_mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *<a href="https://leetcode.cn/problems/merge-intervals/?envType=study-plan-v2&envId=top-100-liked">合并区间</a>
 */
public class SolutionZero {

    // TODO 测试未通过
    public int[][] merge(int[][] intervals) {
        if (intervals.length < 2 || intervals[0].length != 2) {
            return intervals;
        }

        // 需要先排序，不然处理了后面，还要倒回来处理前面的，时间复杂度指数上升
        Arrays.sort(intervals, Comparator.comparingInt(arr -> arr[0]));

        // 经过合并，子数组的数量不定，不适合用数组存储
        List<int[]> res = new ArrayList<>();

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[i - 1][1]) {

                intervals[i][0] = Math.min(intervals[i][0], intervals[i - 1][0]);
                intervals[i][1] = Math.max(intervals[i][1], intervals[i - 1][1]);

                res.add(intervals[i]);
                continue;
            }
            res.add(intervals[i - 1]);
        }
        return res.toArray(new int[][]{});
    }

    public static void main(String[] args) {
        SolutionZero solutionZero = new SolutionZero();
        System.out.println(Arrays.deepToString(solutionZero.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}})));
    }
}
