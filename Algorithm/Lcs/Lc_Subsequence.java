package Lcs;

import java.util.Arrays;

public class Lc_Subsequence {

	public int lcs(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		int[][] result = new int[m + 1][n + 1];
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					result[i][j] = 0;
				} else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					result[i][j] = result[i - 1][j - 1] + 1;
				} else {
					result[i][j] = Math.max(result[i - 1][j], result[i][j - 1]);
				}
			}
		}
		System.out.println(Arrays.deepToString(result));
		return result[m][n];
	}

	public static void main(String[] args) {
		Lc_Subsequence lcSubsequence = new Lc_Subsequence();
		System.out.println(lcSubsequence.lcs("ABCBDAB", "BDCABA"));
	}

}
