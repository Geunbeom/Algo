import java.util.*;
import java.io.*;

public class Main {

    static int N, answer;
    static BufferedReader br;
    static StringTokenizer st;
    static PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
        if (a[0] == b[0]) return a[1]-b[1];
        return a[0]-b[0];
    });
    public static void main(String[] args) throws Exception{
        input();
        play();
        System.out.println(answer);
    }

    private static void play() throws Exception{
        int prev = pq.poll()[1];
        answer += 1;
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (curr[0] >= prev) {
                answer += 1;
                prev = curr[1];
                continue;
            }
            if (curr[1] < prev) {
                prev = curr[1];
            }
        }
    }

    private static void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        answer = 0;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int[] curr = new int[] {a, b};
            pq.offer(curr);
        }

    }

}
