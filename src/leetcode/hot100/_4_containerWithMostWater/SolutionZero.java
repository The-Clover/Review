package leetcode.hot100._4_containerWithMostWater;

/**
 * <a href="https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-100-liked">盛最多水的容器</a>
 * <p>双层暴力遍历</p>
 *
 * <p>双层循环，短的作为高（木桶效应），间隔作为宽，比较更新最大值</p>
 *
 * <p>（height.length - 1 * height.length）/2种</p>
 * <p>sn = (n(n+1))/2，n + n-1 + n-2 + … + 1</p>
 */
class SolutionZero {
    public static int maxArea(int[] height) {
        int area = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                // 计算更新最大面积
                area = Math.max((j - i) * Math.min(height[i], height[j]), area);
            }
        }
        return area;
    }
}
