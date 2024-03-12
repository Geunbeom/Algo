import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dp, arr;
	static int A, MAX;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		MAX = 0;
		arr = new int[A];
		dp = new int[A];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i=0; i<A; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i=0; i<A; i++) {
			dp[i] = arr[i];
			for (int j=0; j<i; j++) {
				if (arr[i] > arr[j] && dp[i] < arr[i]+dp[j]) {
					dp[i] = arr[i] + dp[j];
				}
			}
			if(dp[i] > MAX) MAX = dp[i];
		}
		
		
		System.out.println(MAX);

	}
	
}
