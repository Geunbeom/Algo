import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
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
        M = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        HashMap<String, String> map = new HashMap<>();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();
            map.put(a, b);
        }
        for (int i=0; i<M; i++) {
            sb.append(map.get(br.readLine()));
            if (i != i-M) {
                sb.append("\n");
            }
        }
    }

}