import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int[] dp;
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        input();
        System.out.println(dp[N]);
    }

    private static void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());

        dp = new int[N+1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i=2; i<=N; i++) {
            dp[i] = (dp[i-1] + 2*dp[i-2])%10007;
        }
    }

}