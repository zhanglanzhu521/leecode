//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。 
//
// 示例 1： 
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
// 
//
// 示例 2： 
//
// 输入: "cbbd"
//输出: "bb"
// 
// Related Topics 字符串 动态规划 
// 👍 2659 👎 0

package leetcode.editor.cn;//Java：最长回文子串

public class P5LongestPalindromicSubstring {
	public static void main(String[] args) {

		Solution solution = new P5LongestPalindromicSubstring().new Solution();

		//回文子串是正读反读都一样的字符串
//		String dd = "dsdsdsssssdsdaaaa";
//		String dd = "a";
//		String dd = "bb";
//		String dd = "aacdefcaa";
//		String dd = "ibvjkmpyzsifuxcabqqpahjdeuzaybqsrsmbfplxycsafogotliyvhxjtkrbzqxlyfwujzhkdafhebvsdhkkdbhlhmaoxmbkqiwiusngkbdhlvxdyvnjrzvxmukvdfobzlmvnbnilnsyrgoygfdzjlymhprcpxsnxpcafctikxxybcusgjwmfklkffehbvlhvxfiddznwumxosomfbgxoruoqrhezgsgidgcfzbtdftjxeahriirqgxbhicoxavquhbkaomrroghdnfkknyigsluqebaqrtcwgmlnvmxoagisdmsokeznjsnwpxygjjptvyjjkbmkxvlivinmpnpxgmmorkasebngirckqcawgevljplkkgextudqaodwqmfljljhrujoerycoojwwgtklypicgkyaboqjfivbeqdlonxeidgxsyzugkntoevwfuxovazcyayvwbcqswzhytlmtmrtwpikgacnpkbwgfmpavzyjoxughwhvlsxsgttbcyrlkaarngeoaldsdtjncivhcfsaohmdhgbwkuemcembmlwbwquxfaiukoqvzmgoeppieztdacvwngbkcxknbytvztodbfnjhbtwpjlzuajnlzfmmujhcggpdcwdquutdiubgcvnxvgspmfumeqrofewynizvynavjzkbpkuxxvkjujectdyfwygnfsukvzflcuxxzvxzravzznpxttduajhbsyiywpqunnarabcroljwcbdydagachbobkcvudkoddldaucwruobfylfhyvjuynjrosxczgjwudpxaqwnboxgxybnngxxhibesiaxkicinikzzmonftqkcudlzfzutplbycejmkpxcygsafzkgudy";
//		String dd = "sgjwmfklkff";
//		String dd = "cbbd";
		String dd = "ac";

		long l = System.nanoTime();

		String s = solution.longestPalindrome(dd);
		System.out.println(s);
		long l2 = System.nanoTime();



		System.out.println(l2-l);


	}

	// TO TEST
	//leetcode submit region begin(Prohibit modification and deletion)
	class Solution {
		public String longestPalindrome(String s) {

			int count = 0;
			int maxLengthStr = 0;
			int maxLengthEnd = 0;

			if (s==null||s.equals("")||s.length() == 1) {
				return s;
			}

			if (s.length() == 2 && s.charAt(0) == s.charAt(1)) {
				return s;
			}
			char[] chars = s.toCharArray();

			for (int i = 0; i < chars.length; i++) {

				for (int j = i + 1; j < chars.length; j++) {

					if (ifSubPrefix(chars, i, j)&&(maxLengthEnd-maxLengthStr)<(j-i)) {
						maxLengthStr =i;
						maxLengthEnd =j;
					}

					count++;
				}
			}

			return s.substring(maxLengthStr,maxLengthEnd+1);
		}


		private boolean ifSubPrefix(char[] list,int start, int end){

			boolean isFlg = true;


			while (start < end) {

				if (list[start] != list[end]) {
					isFlg = false;
					break;
				}

				start++;
				end--;
			}

			return isFlg;
		}
	}
//leetcode submit region end(Prohibit modification and deletion)


	//这个简单，但确实最耗费性能
	class Solution2 {
		public String longestPalindrome(String s) {

			int count = 0;
			String maxSubPrefix = "";



			for (int i = 0; i < s.length(); i++) {

				for (int j = i + 1; j < s.length() + 1; j++) {

					String substring = s.substring(i, j);
					int i1 = s.indexOf(substring);


					StringBuffer sb = new StringBuffer(substring);

					StringBuffer reverse = sb.reverse();

					int i2 = s.indexOf(reverse.toString());


					if (i1 >= 0 && substring.length() > maxSubPrefix.length()&&i1==i2) {
						maxSubPrefix = substring;
					}

					count++;
				}
			}

			return maxSubPrefix;
		}
	}

	//这个是官方解法，从中心出发，对称向外扩展，直到对称点不相等则认为回文子串长度达到最大，跟题解1思路正好相反
	//之所以有len1 len2是因为回文串可能是奇数长度、也可能是偶数长度
	class Solution3 {
		public String longestPalindrome(String s) {
			if (s == null || s.length() < 1) return "";
			int start = 0, end = 0;
			for (int i = 0; i < s.length(); i++) {
				int len1 = expandAroundCenter(s, i, i);
				int len2 = expandAroundCenter(s, i, i + 1);
				int len = Math.max(len1, len2);
				if (len > end - start) {
					start = i - (len - 1) / 2;
					end = i + len / 2;
				}
			}
			return s.substring(start, end + 1);
		}

		private int expandAroundCenter(String s, int left, int right) {
			int L = left, R = right;
			while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
				L--;
				R++;
			}
			return R - L - 1;
		}
	}

	//官方动态规划
	class Solution4 {
		public String longestPalindrome(String s) {
			int len = s.length();
			// 特判
			if (len < 2){
				return s;
			}

			int maxLen = 1;
			int begin  = 0;

			// 1. 状态定义
			// dp[i][j] 表示s[i...j] 是否是回文串


			// 2. 初始化
			boolean[][] dp = new boolean[len][len];
			for (int i = 0; i < len; i++) {
				dp[i][i] = true;
			}

			char[] chars = s.toCharArray();
			// 3. 状态转移
			// 注意：先填左下角
			// 填表规则：先一列一列的填写，再一行一行的填，保证左下方的单元格先进行计算
			for (int j = 1;j < len;j++){
				for (int i = 0; i < j; i++) {
					// 头尾字符不相等，不是回文串
					if (chars[i] != chars[j]){
						dp[i][j] = false;
					}else {
						// 相等的情况下
						// 考虑头尾去掉以后没有字符剩余，或者剩下一个字符的时候，肯定是回文串
						if (j - i < 3){
							dp[i][j] = true;
						}else {
							// 状态转移
							dp[i][j] = dp[i + 1][j - 1];
						}
					}

					// 只要dp[i][j] == true 成立，表示s[i...j] 是否是回文串
					// 此时更新记录回文长度和起始位置
					if (dp[i][j] && j - i + 1 > maxLen){
						maxLen = j - i + 1;
						begin = i;
					}
				}
			}
			// 4. 返回值
			return s.substring(begin,begin + maxLen);
		}
	}

}