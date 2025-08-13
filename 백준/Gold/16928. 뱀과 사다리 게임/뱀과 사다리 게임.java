import java.util.*;
import java.io.*;

public class Main {

    static int N, M, answer;
    static HashMap<Integer, Integer> map;
    static boolean[] visited;
    static BufferedReader br;
    static StringTokenizer st;
    public static void main(String[] args) throws Exception{
        input();
        play();
        System.out.println(answer);
    }

    static void play() {
        LinkedList<Integer> q = new LinkedList<>();
        q.offer(1);
        visited[1] = true;

        out: while (!q.isEmpty()) {
            int l = q.size();
            answer++;
            for (int i=0; i<l; i++) {
                int curr = q.poll();
                
                for (int t=1; t<=6; t++) {
                    int next = curr+t;
                    if (next > 100 || visited[next]) continue;
                    if (next == 100) break out;
                    
                    if (map.get(next) == null && !visited[next]) {
                        q.offer(next);
                        visited[next] = true;
                    } else if (map.get(next) != null && !visited[map.get(next)]) {
                        q.offer(map.get(next));
                        visited[map.get(next)] = true;
                    }
                }

            }
        }
    }

    private static void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new HashMap<>();
        visited = new boolean[100+1];
        answer = 0;

        for (int i=0; i<N+M; i++) {
            st = new StringTokenizer(br.readLine());
            map.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

    }

}