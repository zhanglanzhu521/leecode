//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 示例 1: 
//
// 输入: "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 输入: "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 输入: "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window 
// 👍 4252 👎 0

package leetcode.editor.cn;//Java：无重复字符的最长子串

import java.util.*;

public class P3LongestSubstringWithoutRepeatingCharacters {
	public static void main(String[] args) {

		Solution solution = new P3LongestSubstringWithoutRepeatingCharacters().new Solution();

//		String dd = "aw";
		String dd = "pwwkew";

		int i = solution.lengthOfLongestSubstring(dd);
		System.out.println(i);
	}

	// TO TEST
	//leetcode submit region begin(Prohibit modification and deletion)


	class Solution {
		public int lengthOfLongestSubstring(String s) {

			int lengthMax = 0;

			for (int i = 0; i < s.length(); i++) {

				char top = s.charAt(i);
				int length = 0;
				Set<Character> countedInner = new HashSet<>();

				for (int j = i + 1; j < s.length(); j++) {

					Character tail = s.charAt(j);

					if (top == tail || countedInner.contains(tail)) {
						break;
					} else {
						length++;
					}

					countedInner.add(tail);
				}
				if (length > lengthMax) {
					lengthMax = length;
				}
			}

			return s.length() == 0 ? 0 : lengthMax + 1;

		}
	}
//leetcode submit region end(Prohibit modification and deletion)

	class Solution1 {
		//左右边界滑动，i为左边界，j为有边界，保证边界内部无重复字符，判断是否有重复字符使用int[] m存储
		public int lengthOfLongestSubstring(String s) {
			int[] m = new int[128];
			int len = 0;
			for(int i = 0, j = 0; j < s.length(); j++){
				i = Math.max(m[s.charAt(j)], i);
				len = Math.max(len, j - i + 1);
				m[s.charAt(j)] = j + 1;
			}
			return len;
		}
	}
}