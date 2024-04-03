import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int idx, d;
	
	Edge(){}
	Edge(int idx, int d) {
		this.idx = idx;
		this.d = d;
	}
	
	public int compareTo(Edge o) {
		return Integer.compare(this.d, o.d);
	}
}

public class Main{

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		ArrayList<Edge>[] graph = new ArrayList[N+1];
		boolean[] visited = new boolean[N+1];
		for (int i=1; i<=N; i++) {
			graph[i] = new ArrayList<Edge>();
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Edge(b, w));
			graph[b].add(new Edge(a, w));
		}
		
		pq.offer(new Edge(1, 0));
		int cnt = 0;
		int ans = 0;
		int k = 0;
		while (cnt != N) {
			Edge curr = pq.poll();
			
			if(visited[curr.idx]) continue;
			visited[curr.idx] = true;
			ans += curr.d;
			
			if (k < curr.d)
				k = curr.d;
			
			for (Edge e : graph[curr.idx]) {
				if (visited[e.idx]) continue;
				pq.offer(e);	
			}
			cnt++;
		}
		System.out.println(ans-k);
		

		
	}
	
}