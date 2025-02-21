package leetcode.top100._3_moveZeroes;

/**
 * <a href="https://leetcode.cn/problems/move-zeroes?envType=study-plan-v2&envId=top-100-liked">移动零</a>
 * <p>双指针</p>
 */
class SolutionOne {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        // 用紧跟着的非零拷贝填充0（此处不是交换），返回队尾下标
        // 由于不是交换是拷贝填充，此时队尾下标后还有着源数组的一些非0值
        // 需要用0刷脏值
        int index = removeZero(nums);
        // 用0刷新脏值
        while (index < nums.length) {
            nums[index] = 0;
            index++;
        }
    }

    int removeZero(int[] nums) {
        // slow：当前num or 0
        // fast：当前num or !0
        int slow = 0, fast = 0;
        // 快指针寻找非0值，拷贝填充
        // 慢指针保留结果（因为快指针的拷贝填充策略，除了目标值之外，还会多一些脏值）
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }
}
