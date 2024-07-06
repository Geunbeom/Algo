import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {

	int index;
	int cost;

	Node(int index, int cost) {
		this.index = index;
		this.cost = cost;
	}

	@Override
	public int compareTo(Node o) {

		return Integer.compare(this.cost, o.cost);
	}

}

public class Main {

	static ArrayList<Node>[] graph;
	static int start;
	static PriorityQueue<Node> pq;
	static boolean[] visited;
	static int[] dp;

	public static void main(String args[]) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());

		graph = new ArrayList[V + 1];
		pq = new PriorityQueue<>();
		visited = new boolean[V + 1];
		start = Integer.parseInt(br.readLine());
		dp = new int[V + 1];

		for (int i=0; i<V+1; i++) {
			graph[i] = new ArrayList<Node>();
		}
		
		for (int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine());

			int index = Integer.parseInt(st.nextToken());
			int next = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[index].add(new Node(next, w));
		}
		
		pq.offer(new Node(start, 0));
		dijkstra();

		for (int i = 1; i <= V; i++) {
			if (i == start)
				sb.append(0 + "\n");
			else if (dp[i] == 0)
				sb.append("INF\n");
			else
				sb.append(dp[i] + "\n");
		}

		bw.write(sb + "");
		bw.flush();
		bw.close();
	}

	static void dijkstra() {

		while (!pq.isEmpty()) {
			int nowV = pq.poll().index;

			if (visited[nowV])
				continue;

			visited[nowV] = true;

			for (Node next : graph[nowV]) {
				if (dp[next.index] == 0 || dp[next.index] > dp[nowV] + next.cost) {
					dp[next.index] = dp[nowV] + next.cost;;
					pq.offer(new Node(next.index, dp[next.index]));
				}
			}
		}
	}

}
