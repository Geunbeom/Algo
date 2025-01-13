import java.util.*;
import java.io.*;

public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int answer = 0;
		PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
			if (a[0] != b[0]) return a[0]-b[0];
			else return Math.abs(M-a[1])-Math.abs(M-b[1]);
		});
		HashSet<Integer> set = new HashSet<>();
		
		pq.offer(new int[] {0, N});
		
		while(!pq.isEmpty()) {
			int[] curr = pq.poll();
			if (set.contains(curr[1])) continue;
			set.add(curr[1]);
			if (curr[1] == M) {
				answer = curr[0];
				break;
			}else if (curr[1] < M) {
				if (curr[1] != 0 && !set.contains(curr[1]*2)) {
					pq.offer(new int[] {curr[0], curr[1]*2});
				}if(!set.contains(curr[1]+1)) {
					pq.offer(new int[] {curr[0]+1, curr[1]+1});	
				}
			}
			if (curr[1] > 0 && !set.contains(curr[1]-1)) {
				pq.offer(new int[] {curr[0]+1, curr[1]-1});
			}
		}
		System.out.println(answer);
	}
}