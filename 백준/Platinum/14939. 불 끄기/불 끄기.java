import java.util.*;
import java.io.*;

public class Main {

	static int[] state;
	static int count;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int r = 0;
		int min = Integer.MAX_VALUE;
		state = new int[10];
		String curr = "";
		while(r<100) {
			if (r%10 == 0) curr = br.readLine();
			if (curr.charAt(r%10) == 'O') state[r/10] |= (1<<(r%10));
			r++;
		}
		for (int i=0; i<1024; i++) {
			count = 0;
			getMin(getCurr(state[0], i), state[1]^i, 2);
			min = Math.min(min, count);
		}
		sb.append(min == Integer.MAX_VALUE ? -1 : min);
		System.out.print(sb);
	}

	private static void getMin(int curr, int next, int idx) {
		if (idx == 10) {
			if (getCurr(next, curr) != 0) {
				count = Integer.MAX_VALUE;
			}
			return;
		}
		
		if (curr == 0) {
			getMin(next, state[idx], idx+1);
		}else {
			getMin(getCurr(next, curr), state[idx]^curr, idx+1);			
		}
	}

	private static int getCurr(int curr, int bit) {
		for (int i=0; i<10; i++) {
			if ((bit & (1 << i)) != 0) {
				count++;
				int b = 1<<i;
				if (i > 0) b|=1<<(i-1);
				if (i < 9) b|=1<<(i+1);
				curr ^= b;
			}
		}
		return curr;
	}
}