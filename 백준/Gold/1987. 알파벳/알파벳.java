import java.util.*;
import java.io.*;

public class Main {
	
	static boolean[] visited = new boolean[26];
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static int N, M;
	static char[][] arr;
	static int d = 0;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new char[N][M];
		
		for (int r=0; r<N; r++) {
			String input = br.readLine();
			for (int c=0; c<M; c++) {
				arr[r][c] = input.charAt(c);
			}
		}
		visited[arr[0][0]-'A'] = true;
		dfs(0, 0, 1);
		System.out.println(d);
	}
	
	static public void dfs(int r, int c, int answer) {
		if (r == N-1 && c == M-1) {
			d = Math.max(answer, d);
			return;
		}
		for (int i=0; i<4; i++) {
			int R = r+dr[i];
			int C = c+dc[i];
			if (0 > R || 0 > C || R >= N || C >= M || visited[arr[R][C] - 'A']) continue;
			visited[arr[R][C] - 'A'] = true;
			dfs(R, C, answer+1);
			visited[arr[R][C] - 'A'] = false;
		}
		d = Math.max(answer, d);
	}
	
}
