import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main{
	static int[] degree;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[] degree = new int[N+1];
		boolean[] visited = new boolean[N+1];
		ArrayList<Integer>[] graph = new ArrayList[N+1];
		Queue<Integer> queue = new LinkedList<>();
		
		for (int i=0; i<=N; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(b);
			degree[b]++;
		}
		
		for (int i=1; i<=N; i++) {
			if(degree[i] == 0) {
				queue.offer(i);
				visited[i] = true;
			}
		}
		
		while(!queue.isEmpty()) {
			
			int curr = queue.poll();
			sb.append(curr+" ");
			for (int i : graph[curr]) {
				if (visited[i]) continue;
				if (degree[i] > 0) degree[i]--;
				if(degree[i] == 0) {
					queue.offer(i);
					visited[i] = true;
				}
			}
		}
		System.out.println(sb);
		
		
		
	}
}