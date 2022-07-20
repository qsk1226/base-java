package com.goddess.base.algorithm.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点
 *
 * @author qinshengke
 * @since 2022/5/17
 **/
public class 数所有路径 {
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> paths = new ArrayList<String>();
		constructPaths(root, "", paths);
		return paths;
	}

	public void constructPaths(TreeNode root, String path, List<String> paths) {
		if (root != null) {
			StringBuffer pathSB = new StringBuffer(path);
			pathSB.append(Integer.toString(root.val));
			if (root.left == null && root.right == null) {  // 当前节点是叶子节点
				paths.add(pathSB.toString());  // 把路径加入到答案中
			} else {
				pathSB.append("->");  // 当前节点不是叶子节点，继续递归遍历
				constructPaths(root.left, pathSB.toString(), paths);
				constructPaths(root.right, pathSB.toString(), paths);
			}
		}
	}

}
