import java.util.*;
import java.io.*;

public class Main {

    static int N, answer;
    static int[][] arr, dp;
    static boolean[] visited;
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        input();
        play();
        System.out.print(dp[0][N-1]);
    }

    private static void play() throws Exception{
        for (int i=2; i<N; i++) {
            for (int r=0; r+i<N; r++) {
                dp[r][r+i] = Integer.MAX_VALUE;
                for (int c=r+1; c<=r+i; c++) {
                    int k = arr[r][0] * arr[c-1][1] * arr[r+i][1];
                    dp[r][r+i] = Math.min(dp[r][r+i], dp[r][c-1] + dp[c][r+i] + k);
                }
            }
        }
    }

    private static void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        arr = new int[N][2];
        dp = new int[N][N];

        for (int r=0; r<N; r++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[r] = new int[] {a, b};
            if (r > 0) dp[r-1][r] = arr[r-1][0]*arr[r][0]*arr[r][1];
        }
    }
}
