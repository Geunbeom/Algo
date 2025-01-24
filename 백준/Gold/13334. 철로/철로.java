import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[][] arr = new int[N][2];
		PriorityQueue<Integer> start = new PriorityQueue<>();
		PriorityQueue<Integer> end = new PriorityQueue<>();
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		st = new StringTokenizer(br.readLine());
		int L = Integer.parseInt(st.nextToken());
		
		int m = 0;
		int M = 0;
		for (int i=0; i<N; i++) {
			if (arr[i][0] > arr[i][1]) {
				m = arr[i][1];
				M = arr[i][0];
			}else {
				m = arr[i][0];
				M = arr[i][1];
			}
			if (M-m > L) continue;
			start.add(M-L);
			end.add(m+1);
		}
		int max = 0;
		int answer = 0;
		while(!start.isEmpty()) {
			if(start.peek() < end.peek()) {
				start.poll();
				max++;
				answer = Math.max(max, answer);
			} else {
				end.poll();
				max--;
			}
		}
		System.out.println(answer);
	}
}