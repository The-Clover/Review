package leetcode.top100._3_moveZeroes;

/**
 * 双层暴力遍历
 * @see https://leetcode.cn/problems/move-zeroes?envType=study-plan-v2&envId=top-100-liked
 */
class SolutionZero {
    public void moveZeroes(int[] nums) {

        int zeroQueueStartIndex = 0;
        int zeroQueueLength = 0;

        // 遍历数组
        for (int i=0; i<nums.length; i++){
            if (nums[i] == 0) {
                for(int j=i+1; j<nums.length; j++) {
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
