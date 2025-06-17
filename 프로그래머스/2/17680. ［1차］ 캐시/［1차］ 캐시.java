import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length*5;
        
        int answer = 0;
        LinkedHashSet<String> set = new LinkedHashSet<>();
        
        for (int i=0; i<cities.length; i++) {
            String city = cities[i].toLowerCase();
            if (set.contains(city)) {
                set.remove(city);
                set.add(city);
                answer += 1;
            } else {
                set.add(city);
                answer += 5;
            }
            if (set.size() > cacheSize) set.remove(set.iterator().next());
        }
        return answer;
    }
}