import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Node {
	int friend;
	
	Node(){}
	
	Node(int friend) {
		this.friend = friend;
	}
	
}



public class Main{

	static boolean visited[];
	static ArrayList<Node>[] graph;
	static int ans, N;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ans = 0;
		
		graph = new ArrayList[N];
		
		for (int i=0; i<N; i++) {
			graph[i] = new ArrayList<Node>();
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			graph[a].add(new Node(b));
			graph[b].add(new Node(a));
		}
		for (int i=0; i<N; i++) {
			visited = new boolean[N];
			dfs(i, 0);
			if (ans == 1) break;
		}
		System.out.println(ans);
	}
	
	static void dfs(int idx, int cnt) {
		cnt++;
		
		if (cnt == 5) {
			ans = 1;
			return;
		}
		
		visited[idx] = true;
		
		for (Node e : graph[idx]) {
			
			if (visited[e.friend]) continue;
			
			dfs(e.friend, cnt);
			visited[e.friend] = false;
			if (ans == 1) return;
			
		}
	}
	
	
	
}
