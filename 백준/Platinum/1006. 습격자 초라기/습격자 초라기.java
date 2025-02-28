import java.util.*;
import java.io.*;

public class Main {
	
	static int N, W;
	static int[][] dp;
	static String[] first, second;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(st.nextToken());
		
		while(TC > 0) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			first = br.readLine().split(" ");
			second = br.readLine().split(" ");
			
			int answer = Integer.MAX_VALUE;
			dp = new int[N+1][4];
			for (int i=0; i<dp.length; i++) {
				Arrays.fill(dp[i], Integer.MAX_VALUE/2);
			}
			
			boolean[] check = new boolean[4];
			dp[0][0] = 2;
			if (Integer.parseInt(first[N-1])+Integer.parseInt(first[0]) <= W) check[0] = true;
			if (Integer.parseInt(second[N-1])+Integer.parseInt(second[0]) <= W) check[1] = true;
			check[2] = (check[0] && check[1]);
			if (Integer.parseInt(first[0])+Integer.parseInt(second[0]) <= W) check[3] = true;
			
			for (int i=0; i<5; i++) {
				if(i != 0 && !check[i-1]) continue;
				int k = 0;
				dp[0][0] = i == 0 ? 2 : Integer.MAX_VALUE/2;
				dp[0][1] = i == 1 ? 2 : Integer.MAX_VALUE/2;
				dp[0][2] = i == 2 ? 2 : Integer.MAX_VALUE/2;
				dp[0][3] = i == 3 ? 2 : Integer.MAX_VALUE/2;
				dp[0][3] = i == 4 ? 1 : dp[0][3];
				makedp();
				
				switch(i) {
				case 0 :
					k = Math.min(Math.min(dp[N-1][0], dp[N-1][1]),
					Math.min(dp[N-1][2], dp[N-1][3]));
					break;
				case 1 :
					k = Math.min(Math.min(dp[N-1][0]-1, dp[N-1][1]+1),
					Math.min(dp[N-1][2]-1, dp[N-1][3]+1));
					break;
				case 2 :
					k = Math.min(Math.min(dp[N-1][0]-1, dp[N-1][1]-1),
					Math.min(dp[N-1][2]+1, dp[N-1][3]+1));
					break;
				case 3 :
					k = Math.min(Math.min(dp[N-1][0]-2, dp[N-1][1]),
					Math.min(dp[N-1][2], dp[N-1][3]+2));
					break;
				case 4 :
					k = Math.min(Math.min(dp[N-1][0], dp[N-1][1]),
					Math.min(dp[N-1][2], dp[N-1][3]));
					break;
				}
				answer = Math.min(k, answer);
			}
			sb.append(answer);
			if (TC-- != 1)sb.append("\n");
		}
		System.out.print(sb);
	}
	
	private static void makedp() {
		for (int i=1; i<N; i++) {
			int a1 = Integer.parseInt(first[i-1]);
			int b1 = Integer.parseInt(second[i-1]);
			int a2 = Integer.parseInt(i < N ? first[i] : first[0]);
			int b2 = Integer.parseInt(i < N ? second[i] : second[0]);
			dp[i][0] = Integer.MAX_VALUE/2;
			dp[i][1] = Integer.MAX_VALUE/2;
			dp[i][2] = Integer.MAX_VALUE/2;
			dp[i][3] = Integer.MAX_VALUE/2;
			
			dp[i][0] = Math.min(
				Math.min(dp[i-1][0], dp[i-1][1]),
				Math.min(dp[i-1][2], dp[i-1][3])
			) + 2;
			
			// case 1
			if (a1+a2 <= W) dp[i][1] = Math.min(dp[i-1][0]+1, dp[i-1][2]+1);
			
			// case 2
			if (b1+b2 <= W) dp[i][2] = Math.min(dp[i-1][0]+1, dp[i-1][1]+1);
			
			// case 3
			if (a2+b2 <= W) dp[i][3] = dp[i][0]-2+1;
			if (a1+a2<=W && b1+b2<=W) dp[i][3] = Math.min(dp[i][3], dp[i-1][0]);

		}
	}
}