import java.util.*;
import java.io.*;

public class Main {
	
	static int T, N, M, MAX;
	static long answer;
	static int[] A, B;
	static HashMap<Integer, Integer> mapA = new HashMap<>();
	static HashMap<Integer, Integer> mapB = new HashMap<>();
	
	public static void main(String[] args) throws Exception{
		init();
		System.out.print(answer);
	}

	private static void solution() {
		
		for (int i=0; i<MAX; i++) {
			
			if (i < N) mapA.put(A[i], mapA.getOrDefault(A[i], 0)+1);
			if (i < M) mapB.put(B[i], mapB.getOrDefault(B[i], 0)+1);
			
			for (int j=0; j<i; j++) {
				if (i < N) mapA.put(A[i]-A[j], mapA.getOrDefault(A[i]-A[j], 0)+1);
				if (i < M) mapB.put(B[i]-B[j], mapB.getOrDefault(B[i]-B[j], 0)+1);
			}
		}
		
		mapA.forEach((k, v) -> {
			if (mapB.containsKey(T-k)) answer += ((long) v*mapB.get(T-k));
		});
	}

	private static void init() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		N = Integer.parseInt(br.readLine());
		A = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		A[0] = Integer.parseInt(st.nextToken());
		for (int i=1; i<N; i++) A[i] = A[i-1] + Integer.parseInt(st.nextToken());
		
		M = Integer.parseInt(br.readLine());
		B = new int[M];
		
		st = new StringTokenizer(br.readLine());
		B[0] = Integer.parseInt(st.nextToken());
		for (int i=1; i<M; i++) B[i] = B[i-1] + Integer.parseInt(st.nextToken());
		
		MAX = Math.max(M, N);
		answer = 0;
		
		solution();
	}

}