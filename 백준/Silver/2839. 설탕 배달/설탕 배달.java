import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
	
	static int N, ans;
	static int[] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N/5 + 1];
		for (int a=0; a<arr.length; a++) {
			arr[a] = 5*a;
		}
		car(N/5);
		System.out.println(ans);
	
	}
	
	static void car(int k) {
		for (int i=k; i>=0; i--) {
			if ( (N-arr[i]) % 3 == 0) {
				ans = i + ((N-arr[i]) / 3);
				return;
			}
		}
		ans = -1;
		return;
		
	}
	
}