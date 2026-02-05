import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, T, answer;
    static boolean[] visited;
    static boolean[][] map;

    static public void main(String[] args) throws Exception {
        input();
        play(0);
        System.out.print(answer);
    }

    static public void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        T = Integer.parseInt(br.readLine());
        answer = 0;
        visited = new boolean[N];
        visited[0] = true;
        map = new boolean[N][N];
        for (int i=0; i<T; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            map[a][b] = true;
            map[b][a] = true;
        }
    }

    static void play(int t) {
        for (int i=0; i<N; i++) {
            if (map[t][i] && !visited[i]) {
                visited[i] = true;
                answer += 1;
                play(i);
            }
        }
        
    }


}