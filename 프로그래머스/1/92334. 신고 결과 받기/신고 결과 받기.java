import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        HashMap<String, int[]> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        
        for (int i=0; i<id_list.length; i++) {
            map.put(id_list[i], new int[] {i, 0}); // {idx, 신고횟수}
        }
        
        for (int i=0; i<report.length; i++) {
            String[] curr = report[i].split(" ");
            int t = map.get(curr[0])[0] * 1000 + map.get(curr[1])[0];
            if (!set.contains(t)) {
                set.add(t);
                map.get(curr[1])[1]++;
            }
        }
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()) {
            int n = it.next();
            if (map.get(id_list[n%1000])[1] >= k) {
                answer[n/1000]++;
            }
        }
        
        return answer;
    }
}