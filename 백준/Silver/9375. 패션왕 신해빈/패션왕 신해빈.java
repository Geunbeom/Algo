import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int N, T, sum;
    static HashMap<String, Integer> map;

    static public void main(String[] args) throws Exception {
        input();
        System.out.print(sb);
    }

    static public void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        T = Integer.parseInt(br.readLine());
        for (int tc=0; tc<T; tc++) {
            N = Integer.parseInt(br.readLine());
            map = new HashMap<>();
            sum = 1;
            for (int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                s = st.nextToken();
                map.put(s, map.getOrDefault(s, 1 )+1);
            }
            map.forEach((k, v) -> {
                sum *= v;
            });
            sb.append(sum-1).append("\n");

        }
    }

}