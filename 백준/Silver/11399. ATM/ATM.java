import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static PriorityQueue<int[]> pq;
    static int N, answer;

    static public void main(String[] args) throws Exception {
        input();
        System.out.print(answer);
    }

    static public void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        answer = 0;
        pq = new PriorityQueue<>((a, b) -> {
            return a[1]-b[1];
        });
        
        st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) {
            int k = Integer.parseInt(st.nextToken());
            pq.offer(new int[] {i, k});
        }
        
        int sum = 0;
        while (!pq.isEmpty()) {
            sum += pq.poll()[1];
            answer += sum;
        }
    }


}