import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Obj{
	int w, v;
	
	Obj(){}
	Obj(int w, int v){
		this.w = w;
		this.v = v;
	}
}

public class Main{

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[N+1][K+1];
		Obj[] objs = new Obj[N+1];
		
		for (int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			int w = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			objs[i] = new Obj(w, v);
		}
		
		for (int j=1; j<=N; j++) {
			int V = objs[j].v;
			int W = objs[j].w;
			for (int i=0; i<=K; i++) {
				dp[j][i] = dp[j-1][i];
				if (i >= W) {
					dp[j][i] = Math.max(dp[j-1][i-W]+V, dp[j-1][i]);					
				}
			}			
		}
		System.out.println(dp[N][K]);
	}
	
}