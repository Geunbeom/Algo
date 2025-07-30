import java.util.*;
import java.io.*;

public class Main {

    static int N, M, Q, answer;
    static ArrayList<Integer>[] graph;
    static int[] counts;
    static boolean[] visited;
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws Exception{
        input();
        play();
        System.out.print(sb);
    }

    private static void play() throws Exception{
        for (int i=0; i<Q; i++) {
            int q = Integer.parseInt(br.readLine());
            sb.append(counts[q]);
            if (i != Q-1) sb.append("\n");
        }
    }

    private static void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];
        counts = new int[N+1];
        visited = new boolean[N+1];

        for (int r=0; r<N-1; r++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (graph[a] == null) graph[a] = new ArrayList<Integer>();
            if (graph[b] == null) graph[b] = new ArrayList<Integer>();
            graph[a].add(b);
            graph[b].add(a);
        }
        visited[M] = true;
        makeTree(M);
    }

    private static int makeTree(int idx) {
        int count = 1;
        for (int k : graph[idx]) {
            if (visited[k]) continue;
            visited[k] = true;
            count += makeTree(k);
        }
        counts[idx] = count;
        return count;
    }

}
