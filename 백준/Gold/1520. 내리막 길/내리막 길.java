import java.util.*;
import java.io.*;

public class Main {
	
	static int N, M;
	static int[][] arr, dp;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) throws Exception{
		init();
		int answer = solution();
		System.out.print(answer == -1 ? 0 : answer);
	}

	private static int solution() {
		int answer = dfs(0, 0);
		return answer;
	}

	private static int dfs(int r, int c) {
		if (r == N-1 && c == M-1) {
			return 1;
		}
		
		int k = 0;
		int t = 0;
		for (int i=0; i<4; i++) {
			int R = r + dr[i];
			int C = c + dc[i];
			if (R < 0 || C < 0 || R >= N || C >= M) continue;
			if (arr[r][c] <= arr[R][C]) continue;
			if (dp[R][C] == -1) continue;
			
			if (dp[R][C] != 0) {
				k += dp[R][C];
			}else {
				t = dfs(R, C);
				if (t != -1) k += t;
			}
		}
		if (k == 0) dp[r][c] = -1;
		else dp[r][c] = k;
		return dp[r][c];
	}

	private static void init() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N][M];
		dp = new int[N][M];
		
		for (int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c=0; c<M; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
			}
		}
	}

}