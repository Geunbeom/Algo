import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        String[] d = today.split("[.]");
        int day = 0;
        day += Integer.parseInt(d[0])*10000;
        day += Integer.parseInt(d[1])*100;
        day += Integer.parseInt(d[2]);
        
        ArrayList<Integer> list = new ArrayList<>();
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i=0; i<terms.length; i++) {
            String[] term = terms[i].split(" ");
            map.put(term[0].charAt(0), Integer.parseInt(term[1]));
        }
        
        for (int i=0; i<privacies.length; i++) {
            String[] curr = privacies[i].split(" ");
            String[] cd = curr[0].split("[.]");
            
            int k = map.get(curr[1].charAt(0));
            int t = k%12*100 + k/12*10000;
            t += Integer.parseInt(cd[0])*10000;
            t += Integer.parseInt(cd[1])*100;
            t += Integer.parseInt(cd[2]);
            
            if (t%10000 > 1300) {
                t -= 1200;
                t += 10000;
            }
            
            if (t <= day) {
                list.add(i+1);
            }
            
        }
        
        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}