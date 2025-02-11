import java.util.*;
import java.io.*;

public class Main {
	
	static int N, purpose, min, code;
	static int[][] graph;
	static HashMap<Integer, Integer> dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		min = Integer.MAX_VALUE;
		graph = new int[N][N];
		dp = new HashMap<>();
		purpose = 0;
		code = 100000;
		
		for (int i=0; i<N; i++) {
			int c = 1 << i;
			purpose+=c;
			dp.put(i*code+(1<<i), 0);
		}
		
		for (int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c=0; c<N; c++) {
				graph[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		bfs(0);
		System.out.println(min);
	}
	
	static public void bfs(int n) {
		LinkedList<Integer> q = new LinkedList<>();
		q.offer(n*code + (1<<n));
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			int bit = curr%code;
			int index = curr/code;
			
			if (bit == purpose && graph[index][n] != 0) {
				min = Math.min(min, dp.get(curr)+graph[index][n]);
				continue;
			}
			for (int i=0; i<N; i++) {
				if (graph[index][i] == 0 || (bit & (1<<i)) != 0) continue;
				
				int next = i*code + (bit | (1<<i));
				int val = dp.get(curr)+graph[index][i];
				if (dp.get(next) == null || dp.get(next) > val) {
					if (dp.get(next) == null) q.offer(next);
					dp.put(next, val);
				}
			}
		}
	}
}