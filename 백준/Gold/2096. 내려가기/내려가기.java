import java.util.*;
import java.io.*;

public class Main {

	static int[] d = {-1, 0, 1};
	static StringTokenizer st;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[][] curr = new int[3][2];
		int[][] next = new int[3][2];
		boolean change = false;
		
		for (int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			change = change ? false : true;
			if (change) todo(curr, next);
			else todo(next, curr);
		}
		
		System.out.println(
			change ? Math.max(Math.max(next[0][0], next[1][0]), next[2][0]) 
					+ " " + Math.min(Math.min(next[0][1], next[1][1]), next[2][1]) :
					Math.max(Math.max(curr[0][0], curr[1][0]), curr[2][0]) 
					+ " " + Math.min(Math.min(curr[0][1], curr[1][1]), curr[2][1])
		);
	}
	
	static public void todo(int[][] curr, int[][] next) {
		for (int c=0; c<3; c++) {
			int input = Integer.parseInt(st.nextToken());
			next[c][1] = Integer.MAX_VALUE;
			for (int i=0; i<3; i++) {
				int C = c + d[i]; 
				if (C < 0 || C > 2) continue;
				next[c][0] = Math.max(curr[C][0]+input, next[c][0]);
				next[c][1] = Math.min(curr[C][1]+input, next[c][1]);
			}
		}
	}
}