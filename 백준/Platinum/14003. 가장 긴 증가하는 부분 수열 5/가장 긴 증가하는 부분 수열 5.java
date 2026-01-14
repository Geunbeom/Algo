import java.util.*;
import java.io.*;

class Node {
    int k;
    Node prev;

    public Node(int k) {
        this.k = k;
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
        st = new StringTokenizer(br.readLine());
    }

    static void play() {
        list = new ArrayList<>();
        for(int i=0; i<N; i++) {
            Node curr = new Node(Integer.parseInt(st.nextToken()));
            int index = binarySearch(0, list.size(), curr.k);
            if (list.size() == index) list.add(curr);
            else list.set(index, curr);
            curr.prev = index==0?null:list.get(index-1);
        }

        sb.append(list.size()).append("\n");
        dfs(list.get(list.size()-1));

    }

    static int binarySearch(int s, int e, int target) {
        while(s < e) {
          int mid = (s+e)/2;
            if (list.get(mid).k >= target) {
                e = mid;
            } else {
                s = mid+1;
            }
        }
        return s;
    }

    static void dfs(Node curr) {
        if (curr.prev == null) {
            sb.append(curr.k).append(" ");
            return;
        }
        dfs(curr.prev);
        sb.append(curr.k).append(" ");
    }
}