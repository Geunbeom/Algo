import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] dp1 = new int[N];
		int[] dp2 = new int[N];
		int MAX = 0;
		
		st = new StringTokenizer(br.readLine());
		
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		// 5   0 4 / 1 3 / 2 2
		// 6   0 5 / 1 4 / 2 3 / 3 2
		for (int i=0; i<N; i++) {
			int k = N-i-1;
			dp1[i] = 1;
			dp2[k] = 1;
			for (int j=0; j<i; j++) {
				if (arr[i] > arr[j] && dp1[j]+1 > dp1[i]) dp1[i] = dp1[j]+1;
			}
			for (int j=N-1; j>=k; j--) {
				if (arr[k] > arr[j] && dp2[j]+1 > dp2[k]) dp2[k] = dp2[j]+1;
			}
		}

		for (int i=0; i<N; i++) {
			dp1[i] += dp2[i];
			MAX = Math.max(MAX, dp1[i]);
		}
		
		System.out.println(MAX-1);
		

	}
}
