import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int N, M;
    static int[] arr;
    static boolean[] visited;

    static public void main(String[] args) throws Exception {
        input();
        play();
        System.out.print(sb);
    }

    static public void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N];
        visited = new boolean[N];
        
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
    }

    static void play() {
        dfs(0, new int[M]);
    }

    static void dfs(int k, int[] list) {
        if (k == M) {
            for (int i=0; i<k; i++) {
                sb.append(list[i]);
                if (i != k-1) sb.append(" ");
            }
            sb.append("\n");
            return;
        }
        int prev = 0;
        for (int i=0; i<N; i++) {
            if (visited[i]) continue;
            if (prev == arr[i]) continue;
            list[k] = arr[i];
            visited[i] = true;
            dfs(k+1, list);
            visited[i] = false;
            prev = arr[i];
        }

    }

}