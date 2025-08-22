import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static int bit;
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    public static void main(String[] args) throws Exception{
        input();
        System.out.print(sb);
    }

    private static void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        bit = 0;
        sb = new StringBuilder();
        int k = 0;

        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            char code = st.nextToken().charAt(1);
            if (code!='m' && code!='l') k = Integer.parseInt(st.nextToken())-1;

            if (code=='d') {
                bit |= (1<<k);
            }
            else if (code=='h') {
                sb.append(((bit&(1<<k)) != 0 )?1:0).append("\n");
            }
            else if (code=='e') {
                bit &= ~(1<<k);
            }
            else if (code=='o') {
                bit ^= (1<<k);
            }
            else if (code=='l') {
                bit = (int) Math.pow(2, 20) - 1;
            }
            else if (code=='m') {
                bit = 0;
            }

        }
    }

}