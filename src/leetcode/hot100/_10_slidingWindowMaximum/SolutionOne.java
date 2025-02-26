package leetcode.hot100._10_slidingWindowMaximum;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.cn/problems/sliding-window-maximum/description/?envType=study-plan-v2&envId=top-100-liked">滑动窗口最大值</a>
 * <p>单调队列</p>
 */
public class SolutionOne {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }
        int n = nums.length;

        // 当nums.length = k，一个最大值
        int[] res = new int[n - k + 1];

        // queueItem index
        LinkedList<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            // 优先队列：每次以当前元素为基准，剔除比当前元素小的，整体趋势递减
            while (!queue.isEmpty() &&
                    // 检索此列表的最后一个元素，但不删除它
                    nums[queue.peekLast()] <= nums[i]) {
                // 检索并删除此列表的最后一个元素，如果此列表为空则返回null
                queue.pollLast();
            }

            // 入队当前元素
            queue.addLast(i);

            // 比较当前元素index和队列中最大的元素index
            // 如果构成的滑动窗口大于K，则剔除头部元素
            if (queue.peek() < i - (k - 1)) {
                // 检索并删除此列表的头部
                queue.poll();
            }

            // 当 i = k-1 时，开始更新目标值，队首存放最大值在nums的index
            if (i - (k - 1) >= 0) {
                res[i - (k - 1)] = nums[queue.peek()];// 检索但不删除此列表的头部
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SolutionOne solutionOne = new SolutionOne();
        System.out.println(Arrays.toString(solutionOne.maxSlidingWindow(new int[]{1, 3, -1, -3, 5, 3, 6, 7}, 3)));
    }
}
