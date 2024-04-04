import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main{

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N+1];
		int[] walk = new int[N+1];
		int[] jump = new int[N+1];
		
		for (int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for (int i=1; i<=N; i++) {
			
			if (i >= 2) {
				jump[i] = Math.max(walk[i-2] + arr[i], jump[i-2]+arr[i]);
				walk[i] = jump[i-1]+arr[i];
				continue;
			}
			
			jump[i] = arr[i];
			walk[i] = arr[i];
		}
//		System.out.println(Arrays.toString(jump));
//		System.out.println(Arrays.toString(walk));
		System.out.println(Math.max(walk[N], jump[N]));

		
		
		
	}
	
}