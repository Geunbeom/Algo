import java.util.*;
import java.util.Map.Entry;
import java.io.*;

public class Main {
	
	static HashMap<Integer, Integer> visited;
	static int[] check;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int TC = Integer.parseInt(st.nextToken());

		for (int tc=0; tc<TC; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			
			int[] arr = new int[N+1];
			int answer = 0;
			visited = new HashMap<>();
			check = new int[N+1];

			st = new StringTokenizer(br.readLine());
			for (int i=1; i<=N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			for (int i=1; i<=N; i++) {
				if (visited.get(i) != null) {
					answer += visited.get(i) == 2 ? 0 : 1;
				} else {
					if (arr[i] == i) {
						visited.put(i, 2);
					} else {
						visited.put(i, 1);
						int t = dfs(arr, arr[i], i);
						if (t != i) {
							visited.put(i, 0);
							answer += 1;
						}else {
							visited.put(i, 2);
						}
					}
				}
			}
			sb.append(answer + "\n");
		}
		System.out.println(sb);
	}
	
	static public int dfs(int[] arr, int i, int j) {
		if (visited.get(i) != null) {
			if (visited.get(i) == 2 || visited.get(i) == 0) {
				return -1;
			} else {
				return i;
			}
		}
		
		visited.put(i, 1);
		int k = dfs(arr, arr[i], j);
		if (k == -1){
			visited.put(i, 0);
			return -1;
		}else if (k == i){
			visited.put(i, 2);
			return -1;
		}else {
			visited.put(i, 2);
			return k;
		}
	}
}
