/**
 * 
 */
package Index_6;

import java.util.HashMap;

/**
 * @author tlm
 * @leetcode : 6. ZigZag Conversion
 */
public class Solution {

	public String converta(String s, int numRows) {
		char[] cs = s.toCharArray();
		int length = s.length();
		StringBuffer pre = new StringBuffer();
		StringBuffer in = new StringBuffer();
		StringBuffer post = new StringBuffer();

		for (int i = 0; i < cs.length; i++) {
			int mod = i % 4;
			if (mod == 0) {
				pre.append(cs[i]);
			} else if (mod == 1 || mod == 3) {
				in.append(cs[i]);
			} else {
				post.append(cs[i]);
			}
		}
		return new String(pre.append(in).append(post));
	}

	public String convert(String s, int numRows) {
		
		if (numRows==1) {
			return s;
		}
		char[] cs = s.toCharArray();
		int length = s.length();

		HashMap<Integer, StringBuilder> hashMap = new HashMap<>();

		for (int i = 0; i < numRows; i++) {
			hashMap.put(i, new StringBuilder(""));
		}

		boolean flag = true;
		int count = 0;
		for (int i = 0; i < cs.length; i++) {

			if (flag) {

				hashMap.put(count, hashMap.get(count).append(cs[i]));
				if (++count == numRows) {
					count = 0;
					flag = false;
				}

			} else {
				if(numRows<=2){
					count =0;
					flag =true;
				}
				hashMap.put(numRows - count - 2, hashMap.get(numRows - count - 2).append(cs[i]));
				if (++count == numRows - 2) {
					count = 0;
					flag = true;

				}

			}

		}
		StringBuilder stringBuilder = new StringBuilder("");
		for (int j = 0; j < numRows; j++) {
			stringBuilder.append(hashMap.get(j));
		}
		return new String(stringBuilder);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		System.out.println(solution.convert("abcd", 2));
		System.out.println(solution.converta("PAYPALISHIRING", 3));
		
	}

}
