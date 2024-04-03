import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] graph = new ArrayList[N+1];
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int[] degree = new int[N+1];
		
		for (int i=1; i<=N; i++) {
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
			if(degree[i] == 0) pq.offer(i);
		}
		
		while (!pq.isEmpty()) {
			int curr = pq.poll();
			sb.append(curr+" ");
			for (int next : graph[curr]) {
				degree[next]--;
				if(degree[next] == 0) pq.offer(next);
			}
		}
		
		System.out.println(sb);
		

		
	}
	
}