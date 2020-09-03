//给出两个 非空 的链表用来表示两个非负的整数。其中，
// 它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
//
// 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。 
//
// 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
//
// 示例： 
//
// 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
//输出：7 -> 0 -> 8
//原因：342 + 465 = 807
// 
// Related Topics 链表 数学 
// 👍 4833 👎 0

package leetcode.editor.cn;//Java：两数相加

import java.util.Objects;

public class P2AddTwoNumbers {
	public static void main(String[] args) {

		Solution solution = new P2AddTwoNumbers().new Solution();

		ListNode listNode = new ListNode(2);
		ListNode listNode4 = new ListNode(4);
		listNode.next = listNode4;
		ListNode listNode3 = new ListNode(3);
		listNode4.next = listNode3;


		ListNode listNodeL5 = new ListNode(5);
		ListNode listNodeL6 = new ListNode(6);
		listNodeL5.next = listNodeL6;

		ListNode listNodeL4 = new ListNode(4);
		listNodeL6.next = listNodeL4;

		ListNode listNode1 = solution.addTwoNumbers(listNode, listNodeL5);

		System.out.println(listNode1);



	}
	// TO TEST
	//leetcode submit region begin(Prohibit modification and deletion)

	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 * int val;
	 * ListNode next;
	 * ListNode(int x) { val = x; }
	 * }
	 */
	class Solution {
		public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

			int jinWei = 0;
			ListNode res =null;
			while (Objects.nonNull(l1) || Objects.nonNull(l2)) {
				int curL1 = 0;
				if (Objects.nonNull(l1)) {
					curL1 = l1.val;
				}
				int curL2 = 0;
				if (Objects.nonNull(l2)) {
					curL2 = l2.val;
				}

				int curSum = curL1 + curL2;

				if (curSum >= 10) {
					int jianShu = curSum - 10;

					int countAfter = jianShu + jinWei;
					ListNode temp = new ListNode(countAfter);
					temp.next = res;

					res = temp;

			;
					jinWei = 1;
				} else {
					int countAfter = curSum + jinWei;
					ListNode temp = new ListNode(countAfter);
					temp.next = res;

					res = temp;

					if (jinWei > 0) {
						jinWei = 0;
					}
				}

				if (Objects.nonNull(l1)) {
					l1 = l1.next;
				}


				if (Objects.nonNull(l2)) {
					l2 = l2.next;
				}

			}

			return res;

		}



	}

//leetcode submit region end(Prohibit modification and deletion)
public static class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
}