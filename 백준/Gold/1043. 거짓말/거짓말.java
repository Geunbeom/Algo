import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer>[] people = new ArrayList[N];
		ArrayList<Integer>[] partys = new ArrayList[M];
		LinkedList<Integer> q = new LinkedList<>();
		boolean[] pv = new boolean[N];
		boolean[] pav = new boolean[M];
		
		for (int i=0; i<(N<=M?M:N); i++) {
			if (i < N) people[i] = new ArrayList<Integer>();
			if (i < M) partys[i] = new ArrayList<Integer>();
		}
		
		st = new StringTokenizer(br.readLine());
		int t = Integer.parseInt(st.nextToken());
		for (int i=0; i<t; i++) {
			int a = Integer.parseInt(st.nextToken())-1;
			q.offer(a);
			pv[a] = true;
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			t = Integer.parseInt(st.nextToken());
			for (int j=0; j<t; j++) {
				int c = Integer.parseInt(st.nextToken())-1;
				partys[i].add(c);
				people[c].add(i);
			}
		}
		
		while(!q.isEmpty()) {
			int curr = q.poll();
			for(int p : people[curr]) {
				if (pav[p]) continue;
				pav[p] = true;
				for (int pa : partys[p]) {
					if (pv[pa]) continue;
					pv[pa] = true;
					q.offer(pa);
				}
			}
		}
		int answer = 0;
		for (int i=0; i<M; i++) {
			if(pav[i]) continue;
			answer++;
		}
		System.out.println(answer);
	}
}
