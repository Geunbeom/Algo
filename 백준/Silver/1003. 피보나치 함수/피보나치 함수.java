import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int N, ans;
	static int[] memo;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for (int t=1; t<=T; t++) {
			N = Integer.parseInt(br.readLine());
			memo = new int[N+1];
			fibo(N);
			if (N >= 1) {
				System.out.println(memo[N-1] + " " + memo[N]);				
			}else if (N == 1) {
				System.out.println(0 + " " + 1);
			}else if (N == 0) {
				System.out.println(1 + " " + 0);
			}
			
			
		}
	
	}
	
	static int fibo(int k) {
		if (k == 0) {
			memo[k] = 0;
			return 0;
		}
		if (k == 1) {
			memo[k] = 1;
			return 1;
		}
		if (memo[k] == 0) {
			memo[k] = fibo(k-1) + fibo(k-2);
		}
		return memo[k];
		
	}
	
}