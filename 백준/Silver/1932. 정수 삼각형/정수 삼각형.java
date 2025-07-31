import java.util.*;
import java.io.*;

public class Main {

    static int N, answer;
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        input();
    }

    private static void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        LinkedList<Integer> q = new LinkedList<>();
        for (int i=0; i<N; i++) {
            String[] curr = br.readLine().split(" ");
            if (q.isEmpty()) q.offer(Integer.parseInt(curr[0]));
            else {
                int l = q.size();
                int prev = 0;
                int next = 0;
                for (int t=0; t<l; t++){
                    int c = q.poll();
                    prev = Math.max(next, Integer.parseInt(curr[t]) + c);
                    next = Integer.parseInt(curr[t+1]) + c;
                    q.offer(prev);
                    if (t==l-1) q.offer(next);
                }
            }

        }
        answer = 0;
        while (!q.isEmpty()) {
            answer = Math.max(q.poll(), answer);
        }
        System.out.println(answer);
    }
}
