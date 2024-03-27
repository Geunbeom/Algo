import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
	int idx,w;
	
	Node() {}
	
	Node (int idx, int w) {
		this.idx = idx;
		this.w = w;
	}
	
	@Override
	public int compareTo(Node o) {
		return Integer.compare(this.w, o.w);
	}
}


public class Main {

	static BufferedReader br;
	static StringTokenizer st;
	static PriorityQueue<Node> pq = new PriorityQueue<>();
	static ArrayList<Node>[] graph, reverseGraph;
	static int[] dist, reverseDist;
	static boolean[] visited;
	
	public static void main(String[] args) throws Exception {
		br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int X = Integer.parseInt(st.nextToken());
		
		int max = 0;
		
		graph = new ArrayList[N+1];
		reverseGraph = new ArrayList[N+1];
		dist = new int[N+1];
		reverseDist = new int[N+1];
		visited = new boolean[N+1];
		
		for (int i=0; i<=N; i++) {
			graph[i] = new ArrayList<Node>();
			reverseGraph[i] = new ArrayList<Node>();
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Node(b, w));
			reverseGraph[b].add(new Node(a, w));
			
			// 각각의 노드에서 X 까지 최단경로
			// X 에서 각각 노드 까지의 최단경로
			// 역방향그래프 : X 에서 각각의 최단경로 = 각각에서 X 의 최단경로
		}
		
		dijkstra(X, dist, graph);
		visited = new boolean[N+1];
		dijkstra(X, reverseDist, reverseGraph);

		for (int i=1; i<=N; i++) {
			dist[i] += reverseDist[i];
			
			if (dist[i] > max) {
				max = dist[i];
			}
			
		}
		System.out.println(max);
		
	}
	
	static void dijkstra(int start, int[] dp, ArrayList<Node>[] graph1) {
		Node startNode = new Node(start, 0);
		pq.offer(startNode);
		
		while (!pq.isEmpty()) {
			
			Node now = pq.poll();
			int idx = now.idx;
			visited[idx] = true;
			
			for (Node nextNode : graph1[idx]) {
				
				if (visited[nextNode.idx]) continue;
				
				int next = nextNode.idx;
				int w = nextNode.w;
				
				if (dp[next] == 0 || dp[next] > dp[idx] + w) {
					dp[next] = dp[idx] + w;
				}
				pq.offer(new Node(next, dp[next]));
			}
	
		}
		
		
	}
	

}
