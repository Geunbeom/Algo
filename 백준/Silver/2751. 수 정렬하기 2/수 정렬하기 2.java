import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static StringBuilder sb;
    static int N;
    static PriorityQueue<Integer> pq;
    static public void main(String[] args) throws Exception {
        input();
        System.out.print(sb);
    }

    static public void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>((a,b) -> {
          return a-b;
        });
        for (int tc=0; tc<N; tc++) {
            int k = Integer.parseInt(br.readLine());
            pq.offer(k);
        }

        while(!pq.isEmpty()) {
            sb.append(pq.poll()).append("\n");
        }
    }

}