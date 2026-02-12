import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static int N;
    static int[] dp;
    static public void main(String[] args) throws Exception {
        input();
        System.out.print(dp[N-1]);
    }

    static public void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        dp = new int[N];
        dp[0] = 1;
        if (N > 1) dp[1] = 2;
        for (int i=2; i<N; i++) {
            long k = (long) dp[i-1] + dp[i-2];
            dp[i] = (int) k % 10007;
        }
    }

}