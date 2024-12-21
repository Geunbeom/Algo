import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = {0, 0, 0, 0};
        int count = 0;
        HashMap<Integer, ArrayList<Integer>> nodes = new HashMap<>();
        
        for (int[] edge : edges) {
            if (nodes.get(edge[0]) == null) {
                nodes.put(edge[0], new ArrayList<Integer>());
                nodes.get(edge[0]).add(0); // 0번째는 out 값.
                nodes.get(edge[0]).add(0); // 1번째는 in 값.
            }
            if (nodes.get(edge[1]) == null) {
                nodes.put(edge[1], new ArrayList<Integer>());
                nodes.get(edge[1]).add(0); // 0번째는 out 값.
                nodes.get(edge[1]).add(0); // 1번째는 in 값.
            }
            nodes.get(edge[0]).add(edge[1]);
            nodes.get(edge[0]).set(0, nodes.get(edge[0]).get(0) + 1);
            nodes.get(edge[1]).set(1, nodes.get(edge[1]).get(1) + 1);
        }
        
        int n = nodes.size() - 1;
        int m = edges.length;
        int k = n - m;
        
        for (int node : nodes.keySet()) {
            
            // 정점을 찾음.
            if (nodes.get(node).get(0) >= 2 && nodes.get(node).get(1) == 0) {
                answer[0] = node;
                count += nodes.get(node).get(0);
                k += nodes.get(answer[0]).get(0);
                continue;
            }
            
            // 막대를 찾음.
            if (nodes.get(node).get(0) == 0) {
                answer[2]++;
                count--;
                k--;
            }
        }
        
        // 그 외 찾기
        if (k < 0){
            answer[3] -= k;
            count += k;
        }
        answer[1] += count;
        
        return answer;
    }
}
