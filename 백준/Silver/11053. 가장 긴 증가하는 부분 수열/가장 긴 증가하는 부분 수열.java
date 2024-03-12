import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int[] dp, arr;
	static int A, endIdx, ans;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		ans = 0;
		endIdx = 0;
		arr = new int[A];
		dp = new int[A];
		
		st = new StringTokenizer(br.readLine());
		
		for (int i=0; i<A; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		dp[endIdx] = arr[0];
		
		for (int i=1; i<A; i++) {
			if (arr[i] > dp[endIdx]) {
				dp[++endIdx] = arr[i];
			}else if (arr[i] < dp[endIdx]) {
				int j = binarySearch(endIdx, arr[i]);
				dp[j] = arr[i];
			}
		}
		
		
		System.out.println(endIdx+1);

	}
	
	static int binarySearch(int end, int n) {
		int start = 0;
		int mid = 0;
		
		while (start < end) {
			mid = (start+end)/2;
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
