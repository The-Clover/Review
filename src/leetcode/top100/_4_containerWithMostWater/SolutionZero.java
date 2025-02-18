package leetcode.top100._4_containerWithMostWater;

/**
 * 双层暴力遍历
 * <p>
 * （height.length - 1 * height.length）/2种，sn = (n(n+1))/2，n + n-1 + n-2 + … + 1
 * @see https://leetcode.cn/problems/container-with-most-water/description/?envType=study-plan-v2&envId=top-100-liked
 */
class SolutionZero {
    public int maxArea(int[] height) {
        int area = 0;
        for (int i=0; i<height.length; i++) {
            for (int j=i+1; j<height.length; j++) {
                // 计算更新最大面积
                area =  Math.max((j-i) * Math.min(height[i], height[j]), area);
            }
        }
        return area;
    }
}
