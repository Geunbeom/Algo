import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        int t = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i=0; i<tangerine.length; i++) {
            map.put(tangerine[i],
                    map.get(tangerine[i]) == null ? 1
                    : map.get(tangerine[i])+1
            );
        }
        List<Integer> keySet = new ArrayList<>(map.keySet());
        Collections.sort(keySet, (a, b) -> {
            return map.get(b) - map.get(a);
        });
        
        for (int i=0; i<keySet.size(); i++) {
            int curr = map.get(keySet.get(i));
            t += curr;
            if (t >= k) {
                answer = i+1;
                break;
            }
        }
        
        return answer;
    }
}