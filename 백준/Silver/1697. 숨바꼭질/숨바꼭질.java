import java.util.*;
import java.io.*;

public class Main {

    static int N, M, answer;
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        input();
    }

    private static void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        boolean[] visited = new boolean[N>M?N+1:M*2+1];
        answer = 0;
        
        LinkedList<Integer> q = new LinkedList<>();
        q.offer(N);
        visited[N] = true;

        out: while(true) {
            int l = q.size();
            
            for (int i=0; i<l; i++) {
                int curr = q.poll();
                if (curr == M) break out;
                if (curr < M) {
                    if (curr > 0 && !visited[curr*2]) {
                        q.offer(curr*2);
                        visited[curr*2] = true;
                    }
                    if (!visited[curr+1]) {
                        q.offer(curr+1);
                        visited[curr+1] = true;
                    }
                }
                if (curr > 0 && !visited[curr-1]) {
                    q.offer(curr-1);
                    visited[curr-1] = true;
                }
            }
            answer++;
        }
        
        System.out.println(answer);
    }
}