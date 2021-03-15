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

	public void printCommonPart(MyNode head1, MyNode head2) {
		while (head1 != null && head2 != null) {
			if (head1.value < head2.value) {
				head1 = head1.next;
			} else if (head1.value > head2.value) {
				head2 = head2.next;
			} else {
				System.out.println(head1.value + "--");
				head1 = head1.next;
				head2 = head2.next;

			}
		}
	}

	public static void main(String[] args) {
		MyNode myNode = new MyNode(1);
		myNode.next = new MyNode(2);
		myNode.next.next = new MyNode(3);

		MyNode myNode1 = new MyNode(1);

		PrintCommonPart printCommonPart = new PrintCommonPart();
		printCommonPart.printCommonPart(myNode,myNode1);
	}

}
