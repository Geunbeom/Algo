import java.util.*;
import java.io.*;

public class Main {
	
	static int N, max;
	static Stack<int[]> stack;
	
	public static void main(String[] args) throws Exception{
		init();
		System.out.print(max);
	}

	private static void solution(int k) {
		int prev = 0;
		while (!stack.isEmpty() && stack.peek()[0] > k) {
			int[] t = stack.pop();
			max = Math.max(max, t[0]*(t[1]+prev));
			prev += t[1];
		}
		
		if (stack.isEmpty() || stack.peek()[0] < k) stack.push(new int[] {k, prev+1});
		else stack.peek()[1] += (prev+1);
	}

	private static void init() throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		max = 0;
		stack = new Stack<int[]>();
		
		for (int i=0; i<N; i++) {
			int k = Integer.parseInt(br.readLine());
			if (stack.isEmpty()) stack.push(new int[] {k, 1});
			else solution(k);
		}
		int prev = 0;
		while (!stack.isEmpty()) {
			int[] t = stack.pop();
			max = Math.max(max, t[0]*(t[1]+prev));
			prev += t[1];
		}
	}

}