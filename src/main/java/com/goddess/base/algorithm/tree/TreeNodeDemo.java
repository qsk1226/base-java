package com.goddess.base.algorithm.tree;

/**
 * TODO
 *
 * @author qinshengke
 * @since 2022/4/27
 **/
public class TreeNodeDemo {
	static TreeNode root = new TreeNode(4);

	static {
		insert(root, 2);
		insert(root, 3);
		insert(root, 5);
		insert(root, 6);
	}

	/**
	 * 构建二叉搜索树
	 */
	public static TreeNode insert(TreeNode root, int val) {
		if (root == null) {
			return new TreeNode(val);//新建树节点
		} else {
			TreeNode cur;
			if (val <= root.val) {//小的放在左侧
				cur = insert(root.left, val);//递归一直到root为空时，调用第一个IF实现新建树节点
				root.left = cur;
			} else {//大的放在右侧
				cur = insert(root.right, val);
				root.right = cur;
			}
			return root;
		}
	}
}
