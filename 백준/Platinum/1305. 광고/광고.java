import java.util.*;
import java.io.*;

public class Main {

    static int N, answer;
    static String code;
    static int[] p;
    static BufferedReader br;
    static StringTokenizer st1, st2;
    public static void main(String[] args) throws Exception{
        input();
        kmp();
        play();
        System.out.println(answer);
    }

    private static void play() {
        while (true) {
            int idx = N-1;
            if ((N%2==0 && p[idx] < N/2) || (N%2 != 0 && p[idx] <= N/2)) {
                answer = N-p[idx];
                break;
            }
            N = p[idx];
        }
    }

    private static void kmp() throws Exception {
        p = new int[N];
        int j=0;
        for (int i=1; i<N; i++) {
            while(true) {
                if (code.charAt(i) == code.charAt(j)) {
                    p[i] = ++j;
                    break;
                }

                if (j == 0) break;
                j = p[j-1];
            }
        }
    }

    private static void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        code = br.readLine();
        answer = 0;
    }
}
