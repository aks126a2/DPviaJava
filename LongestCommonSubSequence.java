/*
 * LCS Problem Statement: Given two sequences, find the length of longest subsequence present in both of them. 
 * A subsequence is a sequence that appears in the same relative order, but not necessarily contiguous.
 * For example, “abc”, “abg”, “bdf”, “aeg”, ‘”acefg”, .. etc are subsequences of “abcdefg”.
 * So a string of length n has 2^n different possible subsequences.
 * Examples:
 * LCS for input Sequences “ABCDGH” and “AEDFHR” is “ADH” of length 3.
 * LCS for input Sequences “AGGTAB” and “GXTXAYB” is “GTAB” of length 4.
 * Algorithm:
 * dp[i][j]= dp[i-1][j-1] + 1, if string1[i] == string2[j]
 *         	max(dp[i-1][j], dp[i][j-1]) , else
 */

public class LongestCommonSubSequence {
	private static int[][] dp;

	//Print dp[][]
	public static void displayDp() {
		for (int i = 0; i < dp.length; i++) {
			for (int j = 0; j < dp[0].length; j++) {
				System.out.print(dp[i][j] + "\t");
			}
		}
	}

	//Generate dp[][] and return the length of the longest common subsequence
	public static int generateDp(String str1, String str2) {
		int l1 = str1.length();
		int l2 = str2.length();
		dp = new int[l1 + 1][l2 + 1];
		for (int i = 1; i <= l1; i++) {
			for (int j = 1; j <= l2; j++) {
				if (str1.charAt(i - 1) == str2.charAt(j - 1))
					dp[i][j] = dp[i - 1][j - 1] + 1;
				else
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		return dp[l1][l2];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String string1 = "AGGTAB";
		String string2 = "GXTXAYB";
		System.out.println(generateDp(string1, string2));

	}

}
