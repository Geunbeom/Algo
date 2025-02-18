import java.util.*;
import java.io.*;

public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		long max = getMax(N);
		
		String[] arr = new String[N];
		for (int i=0; i<N; i++) arr[i] = br.readLine();
		
		int K = Integer.parseInt(br.readLine());
		int[][] division = new int[N][K];
		LinkedList<Integer> q = new LinkedList<>();
		long[][] dp = new long[(1<<N)][K];
		
		for (int i=0; i<N; i++) {
			for (int j=0; j<K; j++) {
				division[i][j] = cal(j == 0 ? arr[i] : j+arr[i], K);
			}
			int k = division[i][0]*100_000 + (1<<i);
			q.offer(k);
			dp[k%100_000][k/100_000] = 1;
		}

		
		long answer = getDivision(division, q, dp);
		if (answer == max) sb.append("1/1");
		else if(answer == 0) sb.append("0/1");
		else {
			long t = getGCD(answer, max);
			sb.append(answer/t).append("/").append(max/t);
		}
		System.out.print(sb);
	}
	

	public static long getMax(int N) {
		long sum = 1;
		for (int i=N; i>=1; i--) sum*=i;
		return sum;
	}
	
	public static int cal(String str, int k) {
		int curr = 0;
		for (int i=0; i<str.length(); i++) {
			curr = curr*10 + (str.charAt(i) - '0');
			curr = curr%k;
		}
		return curr;
	}
	
	public static long getDivision(int[][] division, LinkedList<Integer> q, long[][] dp) {
		long sum = 0;
		int code = 100_000;
		int max = (1<<division.length)-1;
		while(!q.isEmpty()) {
			int curr = q.poll();
			int bit = curr%code;
			int next = curr/code;
			if (bit == max) {
				if (next == 0) sum += dp[bit][next];
				continue;
			}
			for (int i=0; i<division.length; i++) {
				if ((bit & (1<<i)) != 0) continue;
				int k = (division[i][next]*code) + (bit|(1<<i));
				
				if(dp[k%code][k/code] == 0) {
					q.offer(k);
				}
				dp[k%code][k/code] += dp[bit][next];
			}
			
		}
		
		return sum;
	}
	
	public static long getGCD(long a, long b){
        if(b==0) return a;
        else return getGCD(b, a%b);
    }
}