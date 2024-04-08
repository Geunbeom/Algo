import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dp;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		dp = new int[N];
	
		st = new StringTokenizer(br.readLine());	
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[0] = arr[0];
		int endIdx = 0;
		for (int i=1; i<N; i++) {
			
			if (arr[i] > dp[endIdx]) {
				dp[++endIdx] = arr[i];
			}else {
				int j = binarySearch(endIdx, arr[i]);
				dp[j] = arr[i];
			}
		}

		System.out.println(endIdx+1);
	}
	
	static int binarySearch(int end, int n) {
		int mid = 0;
		int start = 0;
		
		while (start < end) {
			mid = (start+end) / 2;
			if (dp[mid] == n) return mid;
			if (dp[mid] < n) {
				start = mid+1;
			}else {
				end = mid;
			}
			
		}
		return end;
	}
}
