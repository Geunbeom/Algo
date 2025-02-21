import java.util.*;
import java.io.*;


public class Main {
	
	static final int code = 10007;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int k = N/4;
		long sum = 0;
		
		if (k == 0) System.out.println(sum);
		else {
			long[] dp = new long[k];
			Arrays.fill(dp, 1);
			makedp(dp, N-4);
			
			for (int i=1; i<=k; i++) {
				long c = combination(13, i)%code;
				if (i%2==1) sum = (sum+(c*dp[i-1])%code)%code;
				else sum = (sum-(c*dp[i-1])%code + code)%code;
			}
			System.out.print(sum);
			
		}
	}
	
	static void makedp(long[] dp, int N) {
		int t = 44;
		int index = 0;
		for (int i=48; i>48-N; i--) {
			if (i == t) {
				t -= 4;
				index += 1;
			}
			if (i > t) dp[index] = (dp[index]*i)%code;
		}

		for (int l=1; l<dp.length; l++) {
			for (int i=0; i<l; i++) dp[i] = (dp[i]*dp[l])%code;
		}
		
		long c = 1;
		index = dp.length-1;
		t = N%4;
		if (t==0) {
			t += 4;
			index -= 1;
		}
		for (int j=1; j<=N; j++) {
			c = (c*j)%code;
			if (j == t) {
				dp[index] = (dp[index]*mod(c))%code;
				t += 4;
				index-=1;
			}
		}
	}
	
	static long mod(long c) {
		long ans = 1;
		int exp = code-2;
		
		while(exp > 0) {
			if (exp%2 == 1) ans = (ans*c)%code;
			c = (c*c)%code;
			exp /= 2;
		}
		return ans;
	}
	
	static long combination(int r, int c) {
		long out1 = 1;
		long out2 = 1;
		for (int i=0; i<c; i++) {
			out1 *= (r-i);
			out2 *= (i+1);
		}
		
		return out1/out2;
	}
	
}