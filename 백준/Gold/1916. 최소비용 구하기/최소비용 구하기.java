import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Node implements Comparable<Node>{
    int idx;
    int w;
    
    Node() {}
    
    Node(int idx, int w) {
        this.idx = idx;
        this.w = w;
    }

    @Override
    public int compareTo(Node o) {
        // TODO Auto-generated method stub
        return Integer.compare(this.w, o.w);
    }
    
}

public class Main{
    
    static ArrayList<Node>[] graph;
    static BufferedReader br;
    static StringTokenizer st;
    static PriorityQueue<Node> pq = new PriorityQueue<Node>();
    static int startIdx, endIdx;
    static boolean visited[];
    static int[] dist;
    
    public static void main(String[] args) throws Exception {
        br= new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        graph = new ArrayList[N+1];
        visited = new boolean[N+1];
        dist = new int[N+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for (int i=0; i<=N; i++) {
            graph[i] = new ArrayList<Node>();
        }
        
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
        
            graph[start].add(new Node(end, value));
            
        }
        
        st = new StringTokenizer(br.readLine());
        startIdx = Integer.parseInt(st.nextToken());
        endIdx = Integer.parseInt(st.nextToken());
        dist[startIdx] = 0;
        
        dijkstra(startIdx);
        System.out.println(dist[endIdx]);
        
        
    }
    static void dijkstra (int start) {
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            int nowN = pq.poll().idx;
            
            if (visited[nowN]) continue;
            visited[nowN] = true;
            
            for(Node nextN : graph[nowN]) {
                if (visited[nextN.idx]) continue;
                if (dist[nextN.idx] > dist[nowN] + nextN.w) {
                    dist[nextN.idx] = dist[nowN] + nextN.w;
                    pq.offer(new Node(nextN.idx, dist[nextN.idx]));
                }
                

            }

        }
        
        
        
    }
    
    
    
}