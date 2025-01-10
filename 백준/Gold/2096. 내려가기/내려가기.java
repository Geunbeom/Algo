import java.util.*;
import java.io.*;

public class Main {

	static int[] d = {-1, 0, 1};
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[][][] arr = new int[N][3][2];
		int[] answer = new int[2];
		answer[1] = Integer.MAX_VALUE;
		
		for (int r=0; r<N; r++) {
			st = new StringTokenizer(br.readLine());
			for (int c=0; c<3; c++) {
				int input = Integer.parseInt(st.nextToken());
				arr[r][c][0] += input;
				arr[r][c][1] += input;
				if(r == N-1) continue;
				
				int C = 0;
				for (int i=0; i<3; i++) {
					C = c + d[i]; 
					if (C < 0 || C > 2) continue;
					arr[r+1][C][0] = Math.max(arr[r+1][C][0], arr[r][c][0]);
					arr[r+1][C][1] = arr[r+1][C][1] == 0 ? arr[r][c][1] :
									Math.min(arr[r+1][C][1], arr[r][c][1]);
					
				}
				
			}
		}
		for (int i=0; i<3; i++) {
			answer[0] = Math.max(arr[N-1][i][0], answer[0]);
			answer[1] = Math.min(arr[N-1][i][1], answer[1]);
		}
		
		System.out.println(answer[0] + " " + answer[1]);
	}
}