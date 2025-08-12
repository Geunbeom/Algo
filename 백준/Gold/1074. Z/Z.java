import java.util.*;
import java.io.*;

public class Main {

    static int N, r, c, answer;
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        input();
        System.out.println(answer);
    }

    private static void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int K = (int) Math.pow(2, N);
        answer = 0;

        for (int i=0; i<N; i++) {
            int r1 = K/2 > r ? 0 : 1;
            int c1 = K/2 > c ? 1 : 3;

            // 1(좌상) 3(우상) 2(좌하) 4(우하)
            int T = K * K / 4;
            switch(c1+r1) {
                case 1:
                    answer += 0;
                    break;
                case 3:
                    answer += T;
                    break;
                case 2:
                    answer += 2*T;
                    break;
                case 4:
                    answer += 3*T;
                    break;
            }

            K /= 2;
            r %= K;
            c %= K;
        }

    }

}