import java.util.*;
import java.io.*;

public class Main {

    static int N;
    static BufferedReader br;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        input();
    }

    private static void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> {
            int a1 = Math.abs(a);
            int b1 = Math.abs(b);
            return a1!=b1?(a1-b1):a-b;
        });

        for (int i=0; i<N; i++) {
            int c = Integer.parseInt(br.readLine());
            if (c == 0) {
                sb.append(pq.isEmpty()?0:pq.poll());
                if (i != N-1) sb.append("\n");
            } else pq.offer(c);

        }
        
        System.out.println(sb);
    }
}
