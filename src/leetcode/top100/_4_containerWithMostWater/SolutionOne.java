package leetcode.top100._4_containerWithMostWater;

/**
 * 双指针
 * <p>
 * height.length - 2种可能
 * @see https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-100-liked
 */
class SolutionOne {
    public int maxArea(int[] height) {
        // 异常情况
        if (height == null || height.length == 0)
            return 0;
        // 双指针：头和尾
        int l = 0, r = height.length - 1;
        int max = 0;
        while (l < r) {

            // 计算更新面积
            int area = (r - l) * Math.min(height[l], height[r]);
            max = Math.max(max, area);

            // 无论是l++还是r--，横轴都-1
            // 此时决定面积大小的是纵轴，保留更高的，下一次面积更大的可能性更大
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return max;
    }
}
