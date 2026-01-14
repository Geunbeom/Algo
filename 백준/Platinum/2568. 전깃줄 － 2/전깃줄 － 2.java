import java.util.*;
import java.io.*;

class Node {
    int index;
    int a;
    int b;
    Node prev;

    public Node(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public void setNode(Node prev) {
        this.prev = prev;
    }
}

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static StringBuilder sb;
    static int N;
    static ArrayList<Node> list;
    static boolean[] visited;
    static Node[] nodes;
    // 8 2 9 1 4 6 7 10
    // 7 8 9 2 5 10 3 4 6

    static public void main(String[] args) throws Exception {
        input();
        play();
        System.out.print(sb);
    }

    static public void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        visited = new boolean[N];
        nodes = new Node[N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            nodes[i] = new Node(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(nodes, (a, b) -> a.a-b.a);
    }

    static void play() {
        list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            Node curr = nodes[i];
            curr.index = i;
            int index = binarySearch(0, list.size(), curr.b);
            if (list.size() == index) list.add(curr);
            else list.set(index, curr);
            curr.prev = index==0?null:list.get(index-1);
        }

        sb.append(N-list.size()).append("\n");
        dfs(list.get(list.size()-1));
        for (int i=0; i<N; i++) {
            if (visited[i]) continue;
            sb.append(nodes[i].a).append("\n");
        }

    }

    static int binarySearch(int s, int e, int target) {
        while(s < e) {
          int mid = (s+e)/2;
            if (list.get(mid).b >= target) {
                e = mid;
            } else {
                s = mid+1;
            }
        }
        return s;
    }

    static void dfs(Node curr) {
        if (curr.prev == null) {
            visited[curr.index] = true;
            return;
        }
        dfs(curr.prev);
        visited[curr.index] = true;
    }
}