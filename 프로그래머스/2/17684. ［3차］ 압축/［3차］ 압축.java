import java.util.*;

class Solution {
    public int[] solution(String msg) {
        HashMap<String, Integer> dic = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        char c = 'A';
        for (int i=1; i<=26; i++) dic.put("" + (char) c++, i);
        String str = ""+msg.charAt(0);
        int idx = dic.get(str);
        int end = 27;
        for (int i=1; i<msg.length(); i++) {
            char next = msg.charAt(i);
            if (dic.get(str+next) != null) {
                str += next;
            }else {
                list.add(idx);
                dic.put(str+next, end++);
                str = "" + next;
            }
            idx = dic.get(str);
        }
        if (str.length() != 0 && dic.get(str) != null) list.add(idx);
        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) answer[i] = list.get(i);
        return answer;
    }
}