import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

class Node {
    int idx;
    int cnt;
    
    Node() {}
    Node (int idx, int cnt) {
        this.idx = idx;
        this.cnt = cnt;
    }
    
    
}



public class Main{
    
    public static void main(String[] args) throws Exception {
        BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int ans = 0;
        int MAX = Integer.MAX_VALUE;
        Queue<Node> nodes = new LinkedList<>();
        Map<Integer, Integer> visited = new HashMap<>();
        
        Node n = new Node(N, 0);        
        nodes.offer(n);
        
        while (!nodes.isEmpty()) {
            Node now = nodes.poll();
            int X = now.idx;
            int cnt = now.cnt;

            if (MAX < cnt) break;
            
            if (X == K) {
            	MAX = cnt;
            	ans++;
            	continue;
            }
            
            if (visited.get(X) != null && visited.get(X) < cnt) continue;
            visited.put(X, cnt);
            
            
            
            ++cnt;
            if (X-1 >= 0)       	
            	nodes.offer(new Node(X-1, cnt));
            if (X+1 <= 100000)         	
            	nodes.offer(new Node(X+1, cnt));
            if (X*2 <= 200000)        	
            	nodes.offer(new Node(X*2, cnt));
        }
        
        System.out.println(MAX);
        System.out.println(ans);
    
    }
    
}