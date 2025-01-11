import java.io.*;
import java.util.*;

public class Main {
	
	static int R = 0;
	static int G = 1;
	static int B = 2;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		
		int[][] dp = new int[3][3];
		int[] input = new int[3];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			input[R] = Integer.parseInt(st.nextToken());
			input[G] = Integer.parseInt(st.nextToken());
			input[B] = Integer.parseInt(st.nextToken());
			
			if(i == 0) first(dp, input);
			else cal(dp, input);
		}

		int Red = Math.min(dp[R][G], dp[R][B]);
		int Green = Math.min(dp[G][R], dp[G][B]);
		int Blue = Math.min(dp[B][R], dp[B][G]);
		System.out.println(Math.min(Red, Math.min(Green, Blue)));
		
	}
	
	static public void cal(int[][] dp, int[] input) {
		for (int i=0; i<3; i++) {
			int Red = Math.min(dp[i][G], dp[i][B]);
			int Green = Math.min(dp[i][R], dp[i][B]);
			int Blue = Math.min(dp[i][R], dp[i][G]);
			
			dp[i][R] = Red + input[R];
			dp[i][G] = Green + input[G];
			dp[i][B] = Blue + input[B];
			
		}
	}
	
	static public void first(int[][] dp, int[] input) {
		dp[R][R] = input[R];
		dp[R][G] = 10000;
		dp[R][B] = 10000;
		
		dp[G][R] = 10000;
		dp[G][G] = input[G];
		dp[G][B] = 10000;
		
		dp[B][R] = 10000;
		dp[B][G] = 10000;
		dp[B][B] = input[B];
	}
	
}