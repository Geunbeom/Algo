import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int N;
    static PriorityQueue<int[]> pq;
    static public void main(String[] args) throws Exception {
        input();
        System.out.print(sb);
    }

    static public void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>((a,b) -> {
            if (a[1] == b[1]) {
                return a[0]-b[0];
            } else {
                return a[1] - b[1];
            }
        });
        for (int tc=0; tc<N; tc++) {
            st = new StringTokenizer(br.readLine());
            pq.offer(new int[] {Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        while(!pq.isEmpty()) {
            int[] curr = pq.poll();
            sb.append(curr[0]).append(" ").append(curr[1]).append("\n");
        }
    }

}