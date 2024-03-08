import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Edge {
	int v;
	int cost;
	
	Edge(int v, int cost) {
		this.v=v;
		this.cost=cost;
	}
}

public class Main {
	
	static ArrayList<Edge>[] tree;
	static int dp[];
	static boolean visited[];
	static int max, vIndex;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		
		int V = Integer.parseInt(br.readLine());
		
		visited = new boolean[V+1];
		tree = new ArrayList[V+1];
		
		for (int i=0; i<=V; i++) {
			tree[i] = new ArrayList<Edge>();
		}
		
		for (int i=0; i<V; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int v1 = Integer.parseInt(st.nextToken());
			int v2 = Integer.parseInt(st.nextToken());
			
			while (v2 != -1) {
				int w = Integer.parseInt(st.nextToken());
				
				tree[v1].add(new Edge(v2, w));
				
				v2 = Integer.parseInt(st.nextToken());
			}
			
		}
		
		treeSearch(1, 0);
		max = 0;
		visited = new boolean[V+1];
		treeSearch(vIndex, 0);
		System.out.println(max);
	}
	
	static void treeSearch(int v, int costSum) {
		
		if (tree[v].size() == 1 && visited[tree[v].get(0).v]) {
			max = Math.max(max, costSum);
			if (max == costSum) vIndex = v;
			return;
		}
		
		visited[v] = true;
		for (Edge e : tree[v]) {
			if (visited[e.v]) continue;
			visited[e.v] = true;
			treeSearch(e.v, costSum+e.cost);
		}
		
	}
	
}
