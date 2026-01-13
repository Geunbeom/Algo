import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int N, W, I;
    static int[][] ws;
    static int[][] dp;
    static int[][] dis;


    static public void main(String[] args) throws Exception {
        input();
        play();
        System.out.print(sb);
    }

    static public void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        W = Integer.parseInt(br.readLine());
        I = W + 1;
        ws = new int[W+1][2];
        dp = new int[W+1][W+1];
        dis = new int[W+1][W+1];
        
        for (int i=1; i<=W; i++) {
            st = new StringTokenizer(br.readLine());
            ws[i][0] = Integer.parseInt(st.nextToken());
            ws[i][1] = Integer.parseInt(st.nextToken());
        }
        dp[0][1] = distance(0, 1, N);
        dp[1][0] = distance(0, 1, 1);
    }

    static void play() {
        for (int r1=1; r1<W; r1++) {
            int k = r1+1;
            int t1 = distance(r1, k, N);
            int t2 = r1==0?distance(r1, k, 1):t1;
            for (int r2=0; r2<r1; r2++) {
                cal(r2, k, r2, r1, t1);
                cal(k, r2, r1, r2, t2);

                int k1 = distance(r2, k, N);
                int k2 = r2==0?distance(r2, k, 1):k1;
                cal(r1, k, r1, r2, k1);
                cal(k, r1, r2, r1, k2);
            }
        }
        int code = 0;
        int answer = Integer.MAX_VALUE;
        for (int i=0; i<W; i++) {
            if (dp[W][i] < answer) {
                answer = dp[W][i];
                code = W*I+i;
            }

            if (dp[i][W] < answer) {
                answer = dp[i][W];
                code = i*I+W;
            }
        }
        sb.append(answer).append("\n");
        dfs(code/I, code%I);

    }

    static int distance(int i, int f, int t) {
        return Math.abs((i==0?t:ws[i][0])-ws[f][0]) + Math.abs((i==0?t:ws[i][1])-ws[f][1]);
    }

    static void cal(int a, int b, int c, int d, int T) {
        if (dp[a][b] == 0 || dp[a][b] > dp[c][d]+T) {
            dp[a][b] = dp[c][d]+T;
            dis[a][b] = c*I+d;
        }
    }

    static void dfs(int r, int c) {
        if (r == 0 && c == 0) return;
        int r1 = dis[r][c]/I;
        int c1 = dis[r][c]%I;
        dfs(r1,c1);
        sb.append(r==r1?2:1).append("\n");
    }
}