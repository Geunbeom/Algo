import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        ArrayList<String> list = new ArrayList<>();
        String in = "님이 들어왔습니다.";
        String out = "님이 나갔습니다.";
        
        HashMap<String, String> map = new HashMap<>();
        for (int i=0; i<record.length; i++) {
            String[] curr = record[i].split(" ");
            if (curr[0].charAt(0) == 'E') {
                map.put(curr[1], curr[2]);
                list.add(curr[1] + " 0");
            }else if (curr[0].charAt(0) == 'L') {
                list.add(curr[1] + " 1");
            }else {
                map.put(curr[1], curr[2]);
            }
        }
        String[] answer = new String[list.size()];
        
        for (int i=0; i<answer.length; i++) {
            String[] curr = list.get(i).split(" ");
            answer[i] =
                map.get(curr[0]) + (curr[1].charAt(0) == '0' ? in : out);
        }
        
        return answer;
    }
}