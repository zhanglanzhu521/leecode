//将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。 
//
// 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下： 
//
//L   C   I   R
//E T O E S I I G
//E   D   H   N
// 
//
// 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。 
//
// 请你实现这个将字符串进行指定行数变换的函数： 
//
// string convert(string s, int numRows); 
//
// 示例 1: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 3
//输出: "LCIRETOESIIGEDHN"
// 
//
// 示例 2: 
//
// 输入: s = "LEETCODEISHIRING", numRows = 4
//输出: "LDREOEIIECIHNTSG"
//解释:
//
//L     D     R
//E   O E   I I
//E C   I H   N
//T     S     G 
// Related Topics 字符串 
// 👍 827 👎 0

package leetcode.editor.cn;//Java：Z 字形变换

import java.util.ArrayList;
import java.util.List;

public class P6ZigzagConversion{
    public static void main(String[] args) {       
    
        Solution solution = new P6ZigzagConversion().new Solution();

		String dd = "abcdefghijklmnopqrstuv";


		solution.convert(dd, 4);

    
    }
        // TO TEST      
   //leetcode submit region begin(Prohibit modification and deletion)
		class Solution {
			public String convert(String s, int numRows) {

				if (numRows == 1) return s;

				StringBuilder ret = new StringBuilder();
				int n = s.length();
				int cycleLen = 2 * numRows - 2;

				//外层行数 按行 按列 来拼接
				for (int i = 0; i < numRows; i++) {
					//内层每列的位置
					for (int j = 0; j + i < n; j = cycleLen+j) {
						ret.append(s.charAt(j + i));
						//这个判断就是 i不是第一行 也不是最后一行 同时下一个列位置小于最大长度，也就是没到头
						//所以除了第一行和最后一行 一次循环实际上是确定了两个位置
						if (i != 0 && i != numRows - 1 && j + cycleLen - i < n)
							//bf   hl  nr  t
							ret.append(s.charAt(j + cycleLen - i));
					}
				}
				return ret.toString();
			}
		}

//leetcode submit region end(Prohibit modification and deletion)

/*
123456789abcdefg

a     g     m     s
b   f h   l n   r t
c e   i k   o q   u
d     j     p     v

x= (h-2)*l+2*l

char[][]=
abcdefghijklmnopqrstuv
agmsbfhlnrtceikoqudjpv
1 2 3  4   5 6 7 8   9  10  11  12 13 14 15 16  17 18  19  20 21 22
1 7 13 19  2 6 8 12  14 18  20  3  5  9  11 15  17 21  4  10 16  22
0 1 2  3   4 5 6 7   8  9   10  11
0 5 10 15  -3 0 -1 -4 -5 -8 -9
如果l为偶数，那么

0*5 + 0
1*5 + 1
2*5 + 2
3*5 + 3
4*5 + 4


x= (h-2)*（l-1）+2*(l-1)+l

如果l为奇数，那么


 */


	/*
	官方解法
	 */
	class Solution2 {
		public String convert(String s, int numRows) {

			if (numRows == 1) return s;

			List<StringBuilder> rows = new ArrayList<>();
			for (int i = 0; i < Math.min(numRows, s.length()); i++)
				rows.add(new StringBuilder());

			int curRow = 0;
			boolean goingDown = false;

			for (char c : s.toCharArray()) {
				rows.get(curRow).append(c);
				if (curRow == 0 || curRow == numRows - 1) goingDown = !goingDown;
				curRow += goingDown ? 1 : -1;
			}

			StringBuilder ret = new StringBuilder();
			for (StringBuilder row : rows) ret.append(row);
			return ret.toString();
		}
	}

        
        
        
}