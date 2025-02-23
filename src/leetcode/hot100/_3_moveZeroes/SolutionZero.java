package leetcode.hot100._3_moveZeroes;

/**
 * <a href="https://leetcode.cn/problems/move-zeroes?envType=study-plan-v2&envId=top-100-liked">移动零</a>
 * <p>双层暴力遍历</p>
 * <p>零后置，从左往右遍历，则将非0前置，从右往左遍历，则将0后置</p>
 */
class SolutionZero {
    public void moveZeroes(int[] nums) {

        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        swap(nums, i, j);
                        break;
                    }
                }
            }
        }
    }

    public void swap(int[] nums, int source, int target) {
        int temp = nums[target];
        nums[target] = nums[source];
        nums[source] = temp;
    }
}
