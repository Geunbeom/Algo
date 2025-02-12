import java.util.*;
import java.io.*;

public class Main {
	
	static long[] dp;
	static int code = 1_000_000_007;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		long[] arr = new long[N];
		dp = new long[N];
		dp[0] = 1;
		long answer = 0;
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) arr[i] = Long.parseLong(st.nextToken());
		
		Arrays.sort(arr);
		for (int i=0; i<N; i++) {
			long k = cal(i);
			answer += arr[i]*k;
			answer -= arr[N-1-i]*k;
			answer %= code;
		}
		
		System.out.println(answer);
	}
	
	static public long cal(int l) {
		if (l == 0) return 1;
		if (l == 1) return 2;
		
		boolean check = (l%2 == 1);
		if (dp[l/2] == 0) dp[l/2] = cal(l/2) % code;
		if (check && dp[l/2+1] == 0) dp[l/2+1] = cal(l/2+1) % code;
		
		return check ? (dp[l/2]*dp[l/2+1]) % code : (dp[l/2]*dp[l/2]) % code;
	}

}