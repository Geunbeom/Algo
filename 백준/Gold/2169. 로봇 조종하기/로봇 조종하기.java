import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] map = new int[N][M];
		int[][] dp = new int[N][M];
		int[] curr = new int[M];
		
		for (int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c=0; c<M; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		dp[0][0] = map[0][0];
		for (int i=1; i<M; i++) {
			dp[0][i] = dp[0][i-1]+map[0][i];
		}
		
		for (int r=1; r<N; r++) {
			
			for (int c=0; c<M; c++) {
				// 위에서 내려온 curr
				curr[c] = dp[r-1][c] + map[r][c];
				if (c==0) dp[r][c] = curr[c];
				else dp[r][c] = Math.max(curr[c], dp[r][c-1] + map[r][c]);
			}
			
			for (int c=M-1; c>=0; c--) {
				if (c!=M-1) curr[c] = Math.max(curr[c], curr[c+1]+map[r][c]);
				dp[r][c] = Math.max(dp[r][c], curr[c]);
			}
		}

		System.out.println(dp[N-1][M-1]);
	}
}