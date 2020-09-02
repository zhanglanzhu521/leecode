//给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。 
//
// 
//
// 示例: 
//
// 给定 nums = [2, 7, 11, 15], target = 9
//
//因为 nums[0] + nums[1] = 2 + 7 = 9
//所以返回 [0, 1]
// 
// Related Topics 数组 哈希表 
// 👍 9028 👎 0

package leetcode.editor.cn;//Java：两数之和

import java.util.Objects;

public class P1TwoSum {
	public static void main(String[] args) {

		Solution solution = new P1TwoSum().new Solution();

		int[] nums = {2, 7, 11, 15};
		int[] ints = solution.twoSum(nums, 13);

		System.out.println(ints[0] + "--" + ints[1]);


	}

	// TO TEST
	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public int[] twoSum(int[] nums, int target) {

			int[] res = new int[2];
			if (Objects.isNull(nums)) {
				return null;

			}

			for (int i = 0; i < nums.length; i++) {

				int tempI = nums[i];

				for (int j = 0; j < nums.length; j++) {
					int tempJ = nums[j];

					if (tempI + tempJ == target && i != j) {

						res[0] = i;
						res[1] = j;

						return res;
					}

				}
			}


			return null;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)

//解答成功: 执行耗时:112 ms,击败了5.06% 的Java用户 内存消耗:40.2 MB,击败了14.15% 的Java用户
}