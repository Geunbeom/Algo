import java.util.*;

class Solution {
    
    static int index = 0;
    static int[] f;
    
    public int[] solution(int[] fees, String[] records) {
        HashMap<Integer, Integer> map = new HashMap<>();
        TreeMap<Integer, Integer> result = new TreeMap<>();
        f = fees;
        for (int i=0; i<records.length; i++) {
            String[] curr = records[i].split(" ");
            int t =  Integer.parseInt(curr[0].substring(0, 2))*60
                + Integer.parseInt(curr[0].substring(3, 5));
            int index = Integer.parseInt(curr[1]);
            if (curr[2].equals("IN")) {
                map.put(index, t);
            } else {
                result.put(index, (result.get(index) == null ? 0 :
                result.get(index)) + (t-map.get(index)));
                map.put(index, -1);
            }
        }
        map.forEach((k, v) -> {
            if (v != -1) {
                result.put(k, (result.get(k)==null ? 0 :
                result.get(k)) + (1439-v));
            }
        });
        
        
        int[] answer = new int[result.size()];
        result.forEach((k, v) -> {
            int t = (v-f[0] < 0 ? 0 : v-f[0]);
            answer[index] = f[1] + (t%f[2] == 0 ? t/f[2] : t/f[2]+1)*f[3];
            index += 1;
        });
        
        return answer;
    }
}