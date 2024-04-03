import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] graph = new ArrayList[N+1];
		boolean[] visited = new boolean[N+1];
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
		
		
		int curr = 0;
		for (int j=1; j<=N; j++) {
			
			for (int i=1; i<=N; i++) {
				if(!visited[i] && degree[i] == 0) {
					visited[i] = true;
					curr = i;
					sb.append(curr +" ");
					break;
				}
			}
			
			for (int next : graph[curr]) {
				degree[next]--;
			}
		}
		
		System.out.println(sb);
		

		
	}
	
}