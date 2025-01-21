import java.util.*;
import java.io.*;

public class Main {
	
	static ArrayList<Integer> list = new ArrayList<>();
	static ArrayList<int[]> walls = new ArrayList<>();
	static int[][] arr;
	static int[][] answer;
	static boolean[][] visited;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int N, M;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		int index = 2;
		arr = new int[N][M];
		answer = new int[N][M];
		visited = new boolean[N][M];
		
		for (int r=0; r<N; r++) {
			String k = br.readLine();
			for (int c=0; c<M; c++) {
				arr[r][c] = k.charAt(c) - '0';
				if (arr[r][c] == 1) walls.add(new int[] {r, c});
			}
		}
		
		list.add(0);
		list.add(0); // index 는 2부터 시작
		
		for (int r=0; r<N; r++) {
			for (int c=0; c<M; c++) {
				if (arr[r][c] != 0) continue;
				list.add(1);
				bfs(r, c, index++);
			}
		}
		for (int r=0; r<N; r++) {
			for (int c=0; c<M; c++) {
				if(arr[r][c] != 1) {
					sb.append(0);
					continue;
				}
				int k = 1;
				int[] cc = {0, 0, 0, 0};
				for (int i=0; i<4; i++) {
					int R = r+dr[i];
					int C = c+dc[i];
					if (check(R, C) || arr[R][C] == 1) continue;
					cc[i] = arr[R][C];
					if (i == 0)k += list.get(arr[R][C]);
					else {
						for (int j=0; j<i; j++) {
							if (cc[j] == cc[i]) {
								break;
							}if (j == i-1)
								k += list.get(arr[R][C]);
						}
					}
				}
				sb.append(k%10);
			}
			if (r != N-1)sb.append("\n");
		}
		System.out.println(sb);
	}
	
	static public void bfs(int r, int c, int index) {
		LinkedList<int[]> q = new LinkedList<>();
		arr[r][c] = index;
		q.offer(new int[] {r, c});
		
		while(!q.isEmpty()) {
			int[] curr = q.poll();
			for (int i=0; i<4; i++) {
				int R = curr[0]+dr[i];
				int C = curr[1]+dc[i];
				if (check(R, C) || arr[R][C] != 0) continue;
				q.offer(new int[] {R, C});
				arr[R][C] = index;
				list.set(index, list.get(index)+1);
			}
		}
	}
	
	static public boolean check(int R, int C) {
		if (R < 0 || C < 0 || R >= N || C >= M) return true;
		return false;
	}
}