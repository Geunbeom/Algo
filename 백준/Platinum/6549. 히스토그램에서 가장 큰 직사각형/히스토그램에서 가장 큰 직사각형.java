import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int[] h;
		long max;
		Stack<Integer> stack;
		
		while (N != 0) {
			max = 0;
			h = new int[N];
			stack = new Stack<>();
			
			for (int i=0; i<=N; i++) {
				int c = -1;
				if (i != N) {
					c = Integer.parseInt(st.nextToken());
					h[i] = c;
				}

				while (!stack.isEmpty() && h[stack.peek()] > c) {
					int height = h[stack.pop()];
					int width = stack.isEmpty() ? i : i-stack.peek()-1;
					max = Math.max(max, (long) height*width);
				}
				stack.push(i);
			}
			sb.append(max);
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			if (N != 0) sb.append("\n");
		}
		System.out.println(sb);
	}
}