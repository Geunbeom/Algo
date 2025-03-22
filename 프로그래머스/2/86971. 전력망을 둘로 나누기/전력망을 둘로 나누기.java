import java.util.*;

class Solution {
    
    static ArrayList<Integer>[] tree;
    static boolean[] visited;
    static int min, K;
    
    public int solution(int n, int[][] wires) {
        tree = new ArrayList[n+1];
        visited = new boolean[n+1];
        min = 1000;
        K = n;
        
        for (int[] curr : wires) {
            if (tree[curr[0]] == null) tree[curr[0]] = new ArrayList<Integer>();
            if (tree[curr[1]] == null) tree[curr[1]] = new ArrayList<Integer>();
            tree[curr[0]].add(curr[1]);
            tree[curr[1]].add(curr[0]);
        }
        visited[1] = true;
        searchTree(1);
        return min;
    }
    
    static int searchTree(int index) {
        int sum = 1;
        for (int next : tree[index]) {
            if (visited[next]) continue;
            visited[next] = true;
            sum += searchTree(next);
        }
        min = Math.min(min, Math.abs((K-sum)-sum));
        
        return sum;
    }
    
}