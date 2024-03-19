import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, cnt, wall = 3, max = 0;
	static boolean[][] visited;
	static int[][] arr;
	static int[] dr = {1, -1, 0, 0}, dc = {0, 0, 1, -1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int [N][M];
		visited = new boolean[N][M];
		
		for (int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c=0; c<M; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
				if (arr[r][c] == 1 || arr[r][c] == 2) {
					visited[r][c] = true;	
				}
			}	
		}
		
		dfs(0, 0);
		System.out.println(max);
		
	}
	
	static void bfs () {
		Queue<int[]> queue = new LinkedList<>();
		int[] map = new int[2];
		boolean[][] visi = new boolean[N][M];
		
		for (int r=0; r<N; r++) {
			for (int c=0; c<M; c++) {
				if (arr[r][c] == 2) {
					map = new int[] {r, c};
					queue.offer(map);
					visi[r][c] = true;
				}else if (arr[r][c] == 1) visi[r][c] = true;
			}
		}
		
		while(!queue.isEmpty()) {
			for (int size = queue.size(), i=0; i<size; i++) {
				map = queue.poll();
				
				for (int j=0; j<4; j++) {
					int r = dr[j]+map[0];
					int c = dc[j]+map[1];
					if (r >= 0 && r < N && c >= 0 && c < M && arr[r][c] == 0 && !visi[r][c]) {
						visi[r][c] = true;
						queue.offer(new int[] {r, c});
					}
				}
			}
			
		}
		
		cnt = 0;
		
		for (int r=0; r<N; r++) {
			for (int c=0; c<M; c++) {
				if (!visi[r][c]) cnt++;
			}
		}
		
		if (max < cnt) max = cnt;
	}
	
	static void dfs (int a, int b) {
		if (wall == 0) {
			bfs();
			return;
		}
		for (int r=a; r<N; r++) {
			for (int c=b; c<M; c++) {
				if (arr[r][c] == 0) {
					arr[r][c] = 1;
					wall--;
					dfs(r, c);
					wall++;
					arr[r][c] = 0;
				}
			}
			b = 0;
		}
	}
}