import java.util.*;
import java.io.*;

public class Main {

    static int N, M;
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

        HashSet<String> set = new HashSet<>();
        PriorityQueue<String> pq = new PriorityQueue<>();

        for (int i=0; i<N; i++) {
            String str = br.readLine();
            set.add(str);
        }
        for (int i=0; i<M; i++) {
            String str = br.readLine();
            if (set.contains(str)) pq.offer(str);
        }

        sb.append(pq.size()).append("\n");
        while(!pq.isEmpty()) sb.append(pq.poll()).append("\n");
    }

}