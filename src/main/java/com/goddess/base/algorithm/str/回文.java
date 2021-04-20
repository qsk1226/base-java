package com.goddess.base.algorithm.str;

/**
 * TODO
 *
 * @author qinshengke
 * @since 2021/4/19
 **/
public class 回文 {

	public boolean isPalindrome(String s) {
		int left = 0, right = s.length() - 1;
		while (left < right) {
			//left是左指针，如果不是字母和数字要过滤掉
			while (left < right && !Character.isLetterOrDigit(s.charAt(left)))
				left++;
			//right也一样，如果不是字母和数字也要过滤掉
			while (left < right && !Character.isLetterOrDigit(s.charAt(right)))
				right--;
			//然后判断这两个字符是否相同，如果不相同直接返回false，这里是先把字符全部转化为小写
			if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right)))
				return false;
			//如果left和right指向的字符忽略大小写相等的话，这两个指针要分别往中间移一步
			left++;
			right--;
		}
		//如果都比较完了，说明是回文串，返回true
		return true;
	}

	public boolean isPalindrome1(String s) {
		//先转为小写
		s = s.toLowerCase();
		for (int i = 0, j = s.length() - 1; i < j; i++, j--) {
			while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
			while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
			if (s.charAt(i) != s.charAt(j)) return false;
		}
		return true;
	}
}
