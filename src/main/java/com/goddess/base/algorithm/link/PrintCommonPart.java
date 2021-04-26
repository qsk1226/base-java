package com.goddess.base.algorithm.link;

/**
 * 打印两个有序链表的公共部分
 *
 * <code>
*  public class MyNode {
*     public int value;
*     public MyNode next;
*
*     public MyNode(int value) {
*       this.value = value;
*     }
 * }
 * </code>
 *
 * @author qinshengke
 * @since 2021/3/14
 **/
public class PrintCommonPart {
	/**
	 * 打印两个有序链表的公共部分
	 */
	public void printCommonPart(ListNode head1, ListNode head2) {
		while (head1 != null && head2 != null) {
			if (head1.val < head2.val) {
				head1 = head1.next;
			} else if (head1.val > head2.val) {
				head2 = head2.next;
			} else {
				System.out.println(head1.val + "--");
				head1 = head1.next;
				head2 = head2.next;

			}
		}
	}

	public static void main(String[] args) {
		ListNode listNode = new ListNode(1);
		listNode.next = new ListNode(2);
		listNode.next.next = new ListNode(3);

		ListNode listNode1 = new ListNode(1);

		PrintCommonPart printCommonPart = new PrintCommonPart();
		printCommonPart.printCommonPart(listNode, listNode1);
	}

}
