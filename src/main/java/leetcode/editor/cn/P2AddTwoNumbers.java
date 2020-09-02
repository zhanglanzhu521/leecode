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

public class P2AddTwoNumbers{
    public static void main(String[] args) {       
    
        Solution solution = new P2AddTwoNumbers().new Solution();

		ListNode listNode = new P2AddTwoNumbers().new ListNode();

		listNode.add(3);
		listNode.add(4);
		listNode.add(2);


		System.out.println(listNode);

    }
        // TO TEST      
   //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

		return null;

    }
}

class ListNode{

	private int cur;
	private ListNode last;
	private int size;


	public int getCur() {
		return cur;
	}

	public void setCur(int cur) {
		if (cur > 9 || cur < 0) {
			throw new IllegalArgumentException("参数不符合");
		}
		this.cur = cur;
	}



	public ListNode getLast() {
		return last;
	}

	public void setLast(ListNode last) {
		this.last = last;
	}

	public void add(int cur) {
		if (cur > 9 || cur < 0) {
			throw new IllegalArgumentException("参数不符合");
		}

		ListNode curL = new ListNode();

		curL.setCur(this.cur);
		curL.setLast(this.last);


		if (size>0) {
			this.setLast(curL);
		}
		size++;
		this.setCur(cur);
	}

}
//leetcode submit region end(Prohibit modification and deletion)

        
        
        
        
}