import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	static int N, ans;
	static int[][] color, memo, DP;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		memo = new int[N][3];
		DP = new int[N][3];
		
		color = new int[N][3];
		
		for (int r=0; r<N; r++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int c=0; c<3; c++) {
				color[r][c] = Integer.parseInt(st.nextToken());
			}
		}
		memo[0][0] = color[0][0];
		memo[0][1] = color[0][1];
		memo[0][2] = color[0][2];
		
		memo(1);
		
		if (memo[N-1][0] <= memo[N-1][1]) {
			ans = memo[N-1][0];
		}else ans = memo[N-1][1];
		
		if (ans > memo[N-1][2]) {
			ans = memo[N-1][2];
		}
		
		System.out.println(ans);
		
	}

	static void memo(int n) {
		if (n == N) return;
		
		for (int i=0; i<3; i++) {
			int a = i+1;
			int b = i+2;
			
			if (a == 2) {
				b = 0;
			}if (a == 3) {	
				a = 0; b = 1;
			}
			
			if (memo[n-1][a] < memo[n-1][b]) {
				memo[n][i] = color[n][i] + memo[n-1][a];
			}else {
				memo[n][i] = color[n][i] + memo[n-1][b];
			}
		}
		memo(n+1);
		
	}

}