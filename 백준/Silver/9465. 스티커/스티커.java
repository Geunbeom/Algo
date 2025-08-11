import java.util.*;
import java.io.*;

public class Main {

    static int TC, N;
    static int[][] arr;
    static int[] dp1, dp2;
    static BufferedReader br;
    static StringTokenizer st1, st2;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));

        TC = Integer.parseInt(br.readLine());        
        for (int i=0; i<TC; i++) {
            input();
            for (int t=0; t<N; t++) {
                int c = 0;
                if (t%2==0) c = play(t, dp1, dp2);
                else c = play(t, dp2, dp1);
                
                if (t == N-1) sb.append(c);
            }
            if (i != TC-1) sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int play(int n, int[] prev, int[] next) {
        next[0] = Math.max(prev[1], prev[2]);
        next[1] = arr[n][0] + Math.max(prev[0], prev[2]);
        next[2] = arr[n][1] + Math.max(prev[0], prev[1]);

        return Math.max(next[0], Math.max(next[1], next[2]));
    }

    private static void input() throws Exception{
        N = Integer.parseInt(br.readLine());
        arr = new int[N][2];
        dp1 = new int[3];
        dp2 = new int[3];

        st1 = new StringTokenizer(br.readLine());
        st2 = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i][0] = Integer.parseInt(st1.nextToken());
            arr[i][1] = Integer.parseInt(st2.nextToken());
        }

    }

}