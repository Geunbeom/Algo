import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int N;
    static HashSet<Integer> set;
    static public void main(String[] args) throws Exception {
        input();
        System.out.print(sb);
    }

    static public void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        set = new HashSet<>();
        
        st = new StringTokenizer(br.readLine());
        for (int tc=0; tc<N; tc++) {
            int c = Integer.parseInt(st.nextToken());
            set.add(c);
        }

        N = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        for (int tc=0; tc<N; tc++) {
            int c = Integer.parseInt(st.nextToken());
            if (set.contains(c)) {
              sb.append(1).append("\n");
            } else {
              sb.append(0).append("\n");
            }
        }
    }

}