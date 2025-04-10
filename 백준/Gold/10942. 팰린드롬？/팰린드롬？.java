import java.util.*;
import java.io.*;

public class Main {
	
	static boolean[][] dp;
	static BufferedReader br;
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int L = Integer.parseInt(br.readLine());
		int[] arr = new int[L];
		dp = new boolean[L][L];
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<L; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			
			dp[i][i] = true;
			if (i==0) continue;
			else if (arr[i] == arr[i-1]) {
				dp[i-1][i] = true;
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		
		makeFirst(arr, L);
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			sb.append(dp[a-1][b-1] ? 1 : 0);
			if (i != M-1) sb.append("\n");
		}
		System.out.print(sb);
	}

	private static void makeFirst(int[] arr, int L) {
		for (int l=3; l<=L; l++) {
			for (int s=0; s<L-l+1; s++) {
				int e = s+l-1;
				if (arr[s] != arr[e]) continue;
				if (dp[s+1][e-1]) dp[s][e] = true;
			}
		}
	}

}