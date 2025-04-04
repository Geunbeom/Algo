import java.util.*;

class Solution {
    
    static TreeMap<String, Integer> map;
    static int[] count;
    
    public String[] solution(String[] orders, int[] course) {
        ArrayList<String> answer = new ArrayList<>();
        map = new TreeMap<>();
        boolean[] isTrue = new boolean[11];
        count = new int[11];
        
        for (int i=0; i<course.length; i++) {
            isTrue[course[i]] = true;
        }
        
        for (int i=0; i<orders.length; i++) {
            for (int bit=0; bit<(1<<orders[i].length()); bit++) {
                if (!isTrue[Integer.bitCount(bit)]) continue;
                getString(orders[i], bit);
            }
        }
        
        map.forEach((k, v) -> {
            if (v < 2) return;
            if (count[k.length()] == v) answer.add(k); 
        });
        
        return answer.toArray(new String[0]);
    }
    
    static String getString(String curr, int bit) {
        String k = "";
        for (int i=0; i<curr.length(); i++) {
            if ((bit & (1<<i)) != 0)
            k += curr.charAt(i);
        }
        char[] arr = k.toCharArray();
        Arrays.sort(arr);
        k = new String(arr);
        map.put(k, map.getOrDefault(k, 0)+1);
        count[k.length()] = Math.max(count[k.length()], map.get(k));
        return k;
    }
    
}