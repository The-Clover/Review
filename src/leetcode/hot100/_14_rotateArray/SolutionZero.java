package leetcode.hot100._14_rotateArray;

/**
 * <a href="https://leetcode.cn/problems/rotate-array/?envType=study-plan-v2&envId=top-100-liked">轮转数组</a>
 */
public class SolutionZero {
    public void rotate(int[] nums, int k) {
        int outerCycle = 0, innerCycle = 0, index = 0, value = nums[0];

        // 总循环次数
        while (outerCycle < nums.length) {

            index = (index + k) % nums.length;
            nums[index] = value;
            // TODO 处理好子循环，避免循环遍历
        }
    }

    public static void main(String[] args) {
    }
}
