import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static long K;
    static int[][] arr;
    public static void main(String[] args) throws Exception{
        StringBuilder answer = new StringBuilder();
        input();
        int[][] out = division(K);
        for (int r=0; r<N; r++) {
            for (int c=0; c<N; c++) {
                answer.append(out[r][c]);
                if (c != N-1) answer.append(" ");
            }
            if (r != N-1) answer.append("\n");
        }
        System.out.print(answer);
    }

    private static int[][] division(long n) {
        if (n == 1) return arr;
        else {
            int[][] C = division(n/2);
            return div(C, n%2==1?div(C, arr) : C);
        }
    }

    public static int[][] div(int[][] A, int[][] B) {
        int[][] out = new int[N][N];
        for (int r=0; r<N; r++) {
            for (int c=0; c<N; c++) {
                for (int k=0; k<N; k++) {
                    out[r][c] += (A[r][k]*B[k][c])%1000;
                }
                out[r][c] %= 1000;
            }
        }
        return out;
    }


    public static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Long.parseLong(st.nextToken());
        arr = new int[N][N];
        for (int r=0; r<N; r++) {
            st = new StringTokenizer(br.readLine());
            for (int c=0; c<N; c++) {
                arr[r][c] = Integer.parseInt(st.nextToken())%1000;
            }
        }
    }

}