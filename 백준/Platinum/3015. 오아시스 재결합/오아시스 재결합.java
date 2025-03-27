import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		Stack<long[]> stack = new Stack<>();
		int N = Integer.parseInt(br.readLine());
		long sum = 0;
		long curr = Long.parseLong(br.readLine());
		stack.push(new long[] {curr, 1});
		
		for (int index=1; index<N; index++) {
			curr = Long.parseLong(br.readLine());
			
			if (stack.peek()[0] > curr) {
				stack.push(new long[] {curr, 1});
				continue;
			}else if (stack.peek()[0] == curr) {
				stack.peek()[1]+=1;
				continue;
			}
			
			while(!stack.isEmpty() && curr > stack.peek()[0]) {
				long next = stack.pop()[1];
				sum += (next*(next-1)/2); // 2개 뽑는 조합
				sum += next;
				if (!stack.isEmpty()) sum += next;
			}
			
			if (stack.isEmpty() || stack.peek()[0] != curr)
				stack.push(new long[] {curr, 1});
			else stack.peek()[1] += 1;
		}
		
		while(!stack.isEmpty()) {
			long next = stack.pop()[1];
			sum += (next*(next-1)/2);
			if (!stack.isEmpty()) sum += next;
		}
		
		System.out.println(sum);
	}
}