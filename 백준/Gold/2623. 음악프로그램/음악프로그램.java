import java.util.*;
import java.io.*;

public class Main {
	
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		ArrayList<Integer>[] nodes = new ArrayList[N+1];
		LinkedList<Integer> q = new LinkedList<>();
		int count = 0;
		
		int[] p = new int[N+1];
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int k = Integer.parseInt(st.nextToken());
			int[] arr = new int[k];
			for (int j=0; j<k; j++) {
				int curr = Integer.parseInt(st.nextToken());
				arr[j] = curr;
				if (nodes[curr] == null) nodes[curr] = new ArrayList<Integer>();
				if (j != 0) {
					p[curr]++;
					nodes[arr[j-1]].add(curr);
				}
			}
		}
		
		for (int i=1; i<=N; i++) {
			if (p[i] == 0) q.offer(i);
		}
		
		
		while (!q.isEmpty()) {
			int c = q.poll();
			sb.append(c + "\n");
			count++;
			if (nodes[c] == null) continue;
			for (int n : nodes[c]) {
				p[n]--;
				if (p[n] == 0) q.offer(n);
			}
		}
		if (count == N) System.out.println(sb);
		else System.out.println(0);
	}
}