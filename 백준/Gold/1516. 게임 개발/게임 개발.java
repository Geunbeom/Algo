import java.util.*;
import java.io.*;

public class Main {
	
	static int N;
	static int[] p, t, answer;
	static ArrayList<Integer>[] graph;
	static LinkedList<Integer> q;
	
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		init();
		solution();
		for (int time : answer) sb.append(time + "\n");
		System.out.print(sb);
	}

	private static void solution() {
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			answer[curr] += t[curr];
			
			for (int i=0; i<graph[curr].size(); i++) {
				int next = graph[curr].get(i);
				p[next] -= 1;
				answer[next] = Math.max(answer[next], answer[curr]);
				if (p[next] == 0) q.offer(next);
			}
		}
		
	}

	private static void init() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		p = new int[N];
		t = new int[N];
		answer = new int[N];
		graph = new ArrayList[N];
		q = new LinkedList<>();
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			if (graph[i] == null) graph[i] = new ArrayList<Integer>();
			int time = Integer.parseInt(st.nextToken());
			t[i] = time;
			while(true) {
				int curr = Integer.parseInt(st.nextToken())-1;
				if (curr == -2) break;
				if (graph[curr] == null) graph[curr] = new ArrayList<Integer>();
				graph[curr].add(i);
				p[i]++;
			}
			if (p[i] == 0) q.offer(i);
		}
	}

}