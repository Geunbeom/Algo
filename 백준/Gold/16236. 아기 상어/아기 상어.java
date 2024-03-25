import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = { 1, -1, 0, 0 }, dc = { 0, 0, 1, -1 };
	static int[][] map;
	static boolean[][] visited;
	static int N, ans, sharkSize = 2, level = 2;
	static boolean check = false;
	static Queue<int[]> queue = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		visited = new boolean[N][N];
		
		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c = 0; c < N; c++) {
				map[r][c] = Integer.parseInt(st.nextToken());

				if (map[r][c] == 9) {
					queue.offer(new int[] { r, c });
					visited[r][c] = true;
					map[r][c] = 0;
				}

			}
		}
		bfs();
		System.out.println(ans);
		

	}

	static void bfs() {
		int cnt = 0;
		int r, c, R, C;
		int[] arr;
		check = false;
		
		while (!queue.isEmpty()) {
			cnt++;
			for (int i = 0, size = queue.size(); i < size; i++) {

				arr = queue.poll();
				r = arr[0];
				c = arr[1];

				for (int j = 0; j < 4; j++) {
					R = r + dr[j];
					C = c + dc[j];

					if (R < 0 || C < 0 || R >= N || C >= N)
						continue;

					if (map[R][C] <= sharkSize && !visited[R][C]) {
						queue.offer(new int[] { R, C });
						visited[R][C] = true;

						if (map[R][C] != 0 && map[R][C] != sharkSize) {
							check = true;
						}

					}
				}

			}
			if (check) {
				R = N;
				C = N;
				int[] arr1 = new int[2];
				while (!queue.isEmpty()) {

					arr = queue.poll();
					r = arr[0];
					c = arr[1];
					
					if (map[r][c] == 0 || map[r][c] == sharkSize) continue;
					
					if (r < R) {
						R = r;
						C = c;
						arr1[0] = r;
						arr1[1] = c;
					}
					if (r == R && c < C) {
						C = c;
						arr1[0] = r;
						arr1[1] = c;
					}
				}
				queue.offer(arr1);
				map[arr1[0]][arr1[1]] = 0;
				ans += cnt;
				level--;
				
//				for (int a=0; a<N; a++) {
//					System.out.println();
//					for (int b=0; b<N; b++) {
//						System.out.print(map[a][b]+" ");
//					}
//				}
//				System.out.println(cnt + " "+arr1[0]+" "+arr1[1]);

				if (level == 0) {
					level = ++sharkSize;
				}
				visited = new boolean[N][N];
				bfs();
				return;
			}

		}

	}

}