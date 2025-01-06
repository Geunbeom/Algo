import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for (int tc=0; tc<T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N];
			int[] p = new int[N];
			int[] dp = new int[N];
			HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
			LinkedList<Integer> queue = new LinkedList<>();
			
			st = new StringTokenizer(br.readLine());
			for (int n=0; n<N; n++) {
				arr[n] = Integer.parseInt(st.nextToken());
			}
			
			for (int i=0; i<K; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken()) - 1;
				int b = Integer.parseInt(st.nextToken()) - 1;
				if (map.get(a) == null) map.put(a, new ArrayList<Integer>());
				map.get(a).add(b);
				p[b]++;
			}

			for (int n=0; n<N; n++) {
				if(p[n] == 0) {
					queue.offer(n);
					dp[n] = arr[n];
				}
			}
			
			st = new StringTokenizer(br.readLine());
			int W = Integer.parseInt(st.nextToken());
			
			while(!queue.isEmpty()) {
				int l = queue.size();
				for (int i=0; i<l; i++) {
					int curr = queue.poll();
					if (map.get(curr) == null) continue;
					for(int k : map.get(curr)) {
						dp[k] = Math.max(dp[k], arr[k]+dp[curr]);
						p[k]--;
						if (p[k] == 0) {
							queue.offer(k);
						}
					}
				}
			}
			System.out.println(dp[W-1]);
		}
	}
}
