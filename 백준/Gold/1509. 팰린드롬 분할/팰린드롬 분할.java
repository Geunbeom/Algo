import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static int[] p11, p12, p22, p21;
	static boolean[][] dp;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		int L = str.length();
		dp = new boolean[L][L];
		
		makeFirst(str, dp, L);
		int answer = solution(str, dp, L);
		System.out.println(answer);
	}

	private static int solution(String str, boolean[][] dp, int L) {
		int[] dp2 = new int[L];
		Arrays.fill(dp2, 2500);
		for (int i=0; i<L; i++) {
			for (int j=i; j<L; j++) {
				if(dp[i][j]) {
					if (i == 0)dp2[j] = 1;
					else dp2[j] = Math.min(dp2[j], dp2[i-1]+1);
				}
			}
		}
		return dp2[L-1];
	}

	private static void makeFirst(String str, boolean[][] dp, int L) {
		for (int i=0; i<L; i++) {
			dp[i][i] = true;
			
			if (i==L-1) continue;
			else if (str.charAt(i) == str.charAt(i+1)) {
				dp[i][i+1] = true;
			}
		}
		
		for (int l=3; l<=L; l++) {
			
			for (int s=0; s<L-l+1; s++) {
				int e = s+l-1;
				if (str.charAt(s) != str.charAt(e)) continue;
				if (dp[s+1][e-1]) dp[s][e] = true;
			}
		}
		
	}
}