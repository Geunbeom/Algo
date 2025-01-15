import java.io.*;
import java.util.*;

public class Main {
	
	static int[] p;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int answer = 0;
		boolean check = true;
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		p = new int[N];
		
		for (int i=0; i<N; i++) {
			p[i] = i;
		}
		
		for (int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int fa = findSet(Integer.parseInt(st.nextToken()));
			int fb = findSet(Integer.parseInt(st.nextToken()));
		
			if (fa != fb) union(fa, fb);
			else if(check){
				answer = i+1;
				check = false;
			}
		}

		System.out.println(answer);
		
	}
	
	static public int findSet(int k) {
		if (p[k] != k) return findSet(p[k]);
		return k;
	}
	
	static public void union(int a, int b) {
		if(p[a] < p[b]) p[b] = a;
		else p[a] = b;
	}
}