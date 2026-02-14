import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static StringBuilder sb;
    static int N;
    static PriorityQueue<String> pq;
    // -1 갯수 + -2*2 갯수
    static public void main(String[] args) throws Exception {
        input();
        System.out.print(sb);
    }

    static public void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        pq = new PriorityQueue<>((a,b) -> {
            if (a.length() == b.length()) {
                return a.compareTo(b);
            } else {
                return a.length() - b.length();
            }
        });
        for (int tc=0; tc<N; tc++) {
            String str = br.readLine();
            pq.offer(str);
        }

        String prev ="";
        while(!pq.isEmpty()) {
            String curr = pq.poll();
            if (!prev.equals(curr)) {
                sb.append(curr).append("\n");
            }
            prev = curr;
        }
    }

}