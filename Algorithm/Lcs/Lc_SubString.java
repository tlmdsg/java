package Lcs;

import java.util.Arrays;

public class Lc_SubString {

	public int lcs(String str1, String str2) {
		int m = str1.length();
		int n = str2.length();
		int[][] result = new int[m + 1][n + 1];
		int max = 0;
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					result[i][j] = 0;
				} else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
					result[i][j] = result[i - 1][j - 1] + 1;
					max = Math.max(max, result[i][j]);
				} else {
					result[i][j] = 0;
				}
			}
		}
		System.out.println(Arrays.deepToString(result));
		return max;
	}

	public static void main(String[] args) {
		Lc_SubString lc_SubString = new Lc_SubString();
		System.out.println(lc_SubString.lcs("ABCBDAB", "BDCABA"));
	}
}
