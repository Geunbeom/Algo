import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	
	static int N, M, cnt, sum, max, min = 2100000000, house;
	static int[][] arr;
	static int[] dr = {1, -1, 0, 0}, dc = {0, 0, 1, -1};
	static Queue<int[]> queue = new LinkedList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int [N][N];
		
		for (int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c=0; c<N; c++) {
				arr[r][c] = Integer.parseInt(st.nextToken());
				if (arr[r][c] == 2) arr[r][c] = 3;
			}
		}
		
		dfs(0, 0);
		System.out.println(min);
		
		
	}
	
	static void dfs(int a, int b) {
		
		if (M == 0) {
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					if (arr[r][c] == 2) queue.offer(new int[] {r, c});
					else if (arr[r][c] == 1) house++;
				}
			}
			bfs();
			return;
		}
		
		for (int r=a; r<N; r++) {
			for (int c=b; c<N; c++) {
				if (arr[r][c] == 3) {
					arr[r][c] = 2;
					M--;
					dfs(r, c);
					arr[r][c] = 3;
					M++;
				}
			}
			b=0;
		}
	}
	
	static void bfs() {
		boolean[][] visited = new boolean[N][N];
		max = 0;
		sum = 1;
		out: while (!queue.isEmpty()) {
			
			for (int size= queue.size(), i=0; i<size; i++) {
				int[] map = queue.poll();
				
				for (int j=0; j<4; j++) {
					int r = map[0]+dr[j], c = map[1]+dc[j];
					
					if (r>=0 && r<N && c>=0 && c<N && arr[r][c] == 1 && !visited[r][c]) {
						max += sum;
						house--;
						queue.offer(new int[] {r, c});
						visited[r][c] = true;
						
					}else if (r>=0 && r<N && c>=0 && c<N && (arr[r][c] == 0 || arr[r][c] == 3)
							&& !visited[r][c]) {
						
						queue.offer(new int[] {r, c});
						visited[r][c] = true;
						
					}if (house == 0) {
						for (int i2=0, size2 = queue.size(); i2<size2; i2++) {
							queue.poll();
						}
						break out;
					}
				}
			}
			sum++;
		}
		
		min = Math.min(max, min);
	}
	
}