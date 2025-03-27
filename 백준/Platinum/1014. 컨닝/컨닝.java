import java.io.*;
import java.util.*;

public class Main {
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static StringTokenizer st;
	static int[][] dp;
	static int[] arr;
	static int N, M;
	static ArrayList<Integer> list;
	
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(br.readLine());
		
		while(TC > 0) {
			init();
			dp = new int[N][list.size()];
			sb.append(solution());
			
			if (TC != 1) sb.append("\n");
			TC--;
		}
		System.out.print(sb);
		
	}

	private static int solution() {
		
		// 0번째
		int max = 0;
		for (int c=0; c<dp[0].length; c++) {
			int bit = list.get(c) & arr[0];
			if (bit != 0) continue;
			bit = count(list.get(c));
			dp[0][c] = bit;
		}
		
		// 1번째 이후
		for (int r=1; r<N; r++) {
			for (int prev=0; prev<dp[0].length; prev++) {
				for (int curr=0; curr<dp[0].length; curr++) {
					
					if (!isTrue(list.get(prev), list.get(curr))) continue;
					if ((list.get(curr) & arr[r]) != 0) continue;
					
					int k = count(list.get(curr));
					dp[r][curr] = Math.max(dp[r][curr], dp[r-1][prev]+k);
				}
			}
		}
		
		for (int c=0; c<list.size(); c++) {
			max = Math.max(max, dp[N-1][c]);
		}
		
		return max;
	}

	private static boolean isTrue(int prev, int curr) {
		for (int i=0; i<M; i++) {
			if ((prev & (1<<i)) != 0) {
				if ((i<M-1 && (curr & (1<<(i+1))) != 0)
					|| (i>0 && (curr & (1<<(i-1))) != 0)){
					return false;
				}
				
			}
		}
		
		
		return true;
	}

	private static int count(int bit) {
		int num = 0;
		
		for (int i=0; i<M; i++) {
			if ((bit & (1<<i)) != 0) num+= 1;
		}
		
		return num;
	}

	private static void init() throws Exception{
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		list = new ArrayList<>();
		
		for (int r=0; r<N; r++) {
			String line = br.readLine();
			int bit = 0;
			
			for (int c=0; c<M; c++) {
				char curr = line.charAt(c);
				if (curr == 'x') bit |= (1<<c);
			}
			arr[r] = bit;
		}
		
		
		for (int bit=0; bit<(1<<M); bit++) {
			boolean check = false;
			for (int c=0; c<M-1; c++) {
				int b = 1<<c;
				if ((bit & b) != 0 && (bit & b<<1) != 0) check = true;
			}
			if (!check) list.add(bit);
		}
	}
}