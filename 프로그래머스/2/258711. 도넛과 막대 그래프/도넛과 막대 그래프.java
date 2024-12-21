import java.util.*;

class Solution {
    public int[] solution(int[][] edges) {
        int[] answer = {0, 0, 0, 0};
        int count = 0;
        HashMap<Integer, ArrayList<Integer>> nodes = new HashMap<>();
        HashMap<Integer, Boolean> visited = new HashMap<>();
        
        for (int[] edge : edges) {
            if (nodes.get(edge[0]) == null) {
                nodes.put(edge[0], new ArrayList<Integer>());
                visited.put(edge[0], false);
                nodes.get(edge[0]).add(0); // 0번째는 out 값.
                nodes.get(edge[0]).add(0); // 1번째는 in 값.
            }
            if (nodes.get(edge[1]) == null) {
                nodes.put(edge[1], new ArrayList<Integer>());
                visited.put(edge[1], false);
                nodes.get(edge[1]).add(0); // 0번째는 out 값.
                nodes.get(edge[1]).add(0); // 1번째는 in 값.
            }
            nodes.get(edge[0]).add(edge[1]);
            nodes.get(edge[0]).set(0, nodes.get(edge[0]).get(0) + 1);
            nodes.get(edge[1]).set(1, nodes.get(edge[1]).get(1) + 1);
        }
        
        for (int node : nodes.keySet()) {
            // 정점을 찾음.
            if (nodes.get(node).get(0) >= 2 && nodes.get(node).get(1) == 0) {
                answer[0] = node;
                count = nodes.get(node).get(0);
                break;
            }
        }
        // System.out.println(count);
        
        LinkedList<Integer> queue = new LinkedList<>();
        queue.offer(answer[0]);
        visited.put(answer[0], true);
        
        int n = nodes.size() - 1;
        int m = edges.length - nodes.get(answer[0]).get(0);
        int k = n - m;
        
        // 막대 찾기
        while(!queue.isEmpty()) {
            int curr = queue.poll();
            
            if (nodes.get(curr).get(0) == 0) {
                answer[2]++;
                count--;
                k--;
                continue;
            }
            
            for (int i=2; i < nodes.get(curr).size(); i++) {
                int next = nodes.get(curr).get(i);
                if (visited.get(next)) continue;
                visited.put(next, true);
                queue.offer(next);
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