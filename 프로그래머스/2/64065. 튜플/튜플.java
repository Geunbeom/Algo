import java.util.*;

class Solution {
    public int[] solution(String s) {
        PriorityQueue<ArrayList<Integer>> pq = new PriorityQueue<>((a, b) -> {
           return a.size()-b.size(); 
        });
        HashSet<Integer> set = new HashSet<>();
        
        String str = "";
        ArrayList<Integer> list = new ArrayList<>();
        boolean check = false;
        for (int i=1; i<s.length()-1; i++) {
            char c = s.charAt(i);
            if (c >= '0' && c <='9') str += c;
            else if (c == '{') {
                list = new ArrayList<Integer>();
                check = true;
            }else if (c == '}') {
                list.add(Integer.parseInt(str));
                pq.offer(list);
                check = false;
                str = new String();
            }else if (c == ',') {
                if (!check) continue;
                list.add(Integer.parseInt(str));
                str = new String();
            }
        }
        
        int[] answer = new int[pq.size()];
        int index = 0;
        while(!pq.isEmpty()) {
            list = pq.poll();
            for (int i : list) {
                if (set.contains(i)) continue;
                answer[index++] = i;
                set.add(i);
            }
        }
        
        return answer;
    }
}