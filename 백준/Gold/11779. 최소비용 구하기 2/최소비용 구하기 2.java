import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node> {
	int idx, w, pre;

	Node() {
	}

	Node(int idx, int w) {
		this.idx = idx;
		this.w = w;
	}

	Node(int idx, int w, int pre) {
		this.idx = idx;
		this.w = w;
		this.pre = pre;
	}

	@Override
	public int compareTo(Node o) {
		if (this.w != o.w) {
			return Integer.compare(this.w, o.w);
		}

		return this.pre - o.pre;
	}
}

public class Main {

	static ArrayList<Node>[] graph;
	static ArrayList<Integer>[] direction;
	static int[] dist;
	static boolean[] visited;
	static PriorityQueue<Node> pq = new PriorityQueue<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(br.readLine());
		int INF = Integer.MAX_VALUE;

		graph = new ArrayList[N + 1];
		direction = new ArrayList[N + 1];
		dist = new int[N + 1];
		visited = new boolean[N + 1];
		Arrays.fill(dist, INF);

		for (int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<Node>();
			direction[i] = new ArrayList<Integer>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			graph[a].add(new Node(b, w));

		}
		st = new StringTokenizer(br.readLine());
		int s = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(st.nextToken());

		dijkstra(s, t);
		for (int i=0; i<=N; i++) {
			if(dist[i] == INF) dist[i] = 0;
		}
		
		int size = direction[t].size();
		System.out.println(dist[t]);
		System.out.println(size);
		for (int i = 0; i < size; i++) {
			System.out.print(direction[t].get(i) + " ");
		}

	}

	static void dijkstra(int start, int finish) {
		dist[start] = 0;
		direction[start].add(start);
		Node startNode = new Node(start, 0, 0);
		pq.offer(startNode);
		
		while (!pq.isEmpty()) {
			Node nowNode = pq.poll();

			int idx = nowNode.idx;
			int pre = nowNode.pre;
			int w = nowNode.w;

			if (idx != start && direction[idx].isEmpty()) {
				direction[idx].addAll(direction[pre]);
				direction[idx].add(idx);
			}

			if (idx == finish) {

				return;
			}

			visited[idx] = true;

			for (Node next : graph[idx]) {
				if (visited[next.idx])
					continue;

				int cost = w + next.w;

				if (dist[next.idx] > cost) {
					dist[next.idx] = cost;
					pq.offer(new Node(next.idx, cost, idx));
				}
			}
		}
	}
}
