import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		long[] h;
		long max;
		Stack<Integer> stack;
		
		while (N != 0) {
			max = 0;
			h = new long[N+1];
			stack = new Stack<>();
			
			for (int i=0; i<N; i++) {
				h[i] = Integer.parseInt(st.nextToken());
			}
			
			int i = 0;
	        while (i < N) {
	            if (stack.isEmpty() || h[stack.peek()] <= h[i]) {
	                stack.push(i++);
	            } else {
	                long height = h[stack.pop()];
	                long width = stack.isEmpty() ? i : i - stack.peek() - 1;
	                max = Math.max(max, (long) height * width);
	            }
	        }

	        while (!stack.isEmpty()) {
	            long height = h[stack.pop()];
	            long width = stack.isEmpty() ? i : i - stack.peek() - 1;
	            max = Math.max(max, (long) height * width);
	        }
	        
			sb.append(max);
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if (N != 0) sb.append("\n");
		}
		System.out.println(sb);
	}
}