import java.util.*;
import java.io.*;

class Node {
    int n; // 노드 번호
    int v; // 가중치

    public Node(int n, int v) {
        this.n = n;
        this.v = v;
    }

}

public class Main {

    static int N, E, N1, N2;
    static ArrayList<Node>[] graph;
    public static void main(String[] args) throws Exception{
        input();
        int[] dp1 = dijkstra(1);
        dp1[1] = 0;
        int[] dp2 = dijkstra(N1);
        dp2[N1] = 0;
        int[] dp3 = dijkstra(N2);
        dp3[N2] = 0;
        int answer;
        if (dp1[N] == 0 || (N1 != 1 && dp1[N1] == 0) || (N2 != 1 && dp1[N2] == 0)) answer = -1;
        else answer = Math.min(dp1[N1]+dp2[N2]+dp3[N], dp1[N2]+dp3[N1]+dp2[N]);
        System.out.print(answer);
    }


    public static int[] dijkstra(int s) {
        int[] out = new int[N+1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            return a[1]-b[1];
        });
        pq.offer(new int[] {s, 0});

        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            if (graph[curr[0]]==null) continue;
            for (Node next : graph[curr[0]]) {
                if (out[next.n] != 0 && out[next.n] <= out[curr[0]]+next.v) continue;
                out[next.n] = out[curr[0]]+next.v;
                pq.offer(new int[] {next.n, out[next.n]});
            }
        }
        return out;
    }


    public static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N+1];

        for (int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            if (graph[n1] == null) graph[n1] = new ArrayList<Node>();
            if (graph[n2] == null) graph[n2] = new ArrayList<Node>();
            graph[n1].add(new Node(n2, v));
            graph[n2].add(new Node(n1, v));
        }

        st = new StringTokenizer(br.readLine());
        N1 = Integer.parseInt(st.nextToken());
        N2 = Integer.parseInt(st.nextToken());
    }

}