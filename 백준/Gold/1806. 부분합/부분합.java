import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int ans = 0;
		
		int[] arr = new int[N+1];
		int[] sumArr = new int[N+1];
		
		st = new StringTokenizer(br.readLine());
		for (int i=1; i<=N; i++) {
			int a = Integer.parseInt(st.nextToken());
			
			arr[i] = a;
			sumArr[i] = sumArr[i-1] + a;
		}
		
		if (sumArr[N] < M) ans = 0;
		
		else {
			int start = 0;
			int end = 0;
			ans = N;
			while(end <= N) {
				int k = sumArr[end]-sumArr[start];
				
				if (k < M) {
					end++;
				}else if (k >= M) {
					int m = end-start;
					if (m < ans) ans = m;
					start++;
				}
			}
		}
		
		System.out.println(ans);
		

		
	}
	
}