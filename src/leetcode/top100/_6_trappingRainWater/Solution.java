package leetcode.top100._6_trappingRainWater;

/**
 * <p>两边的高度都要高于当前</p>
 * <p>两边高度取最低的（木桶效应）</p>
 * <p>两边可以间隔多个块（平移）</p>
 * <p>双指针</p>
 * @see https://leetcode.cn/problems/trapping-rain-water/description/?envType=study-plan-v2&envId=top-100-liked
 */
class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int len = height.length;

        // 记录当前的左边的柱高度（不一定是紧挨着的）
        int[] lmax = new int[len];
        // 记录当前的右边的柱高度（不一定是紧挨着的）
        int[] rmax = new int[len];

        int res = 0;
        // 首尾的柱子起到更新时参照作用
        lmax[0] = height[0];
        rmax[len - 1] = height[len - 1];

        // 更新左边的柱子，不一定是紧挨着的
        // 处理 left , left从1开始（最左不用更新，已经初始化过了）
        for (int i = 1; i < len; i++) {
            // 比较前面一个（左边最高的可以平移过来用） 和 当前的
            lmax[i] = Math.max(lmax[i - 1], height[i]);
        }

        // 更新右边的柱子，不一定是紧挨着的
        // 处理right ，left从len - 2（最右不用更新，已经初始化过了）
        for (int i = len - 2; i > 0; i--) {
            // 比较前面一个（右最高的可以平移过来用） 和 当前的
            rmax[i] = Math.max(rmax[i + 1], height[i]);
        }

        for (int i = 1; i < len - 1; i++) {
            // 木桶取短板
            res += Math.min(lmax[i], rmax[i]) - height[i];
        }
        return res;
    }
}

