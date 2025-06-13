import java.util.*;

class Node {
    String name;
    int number;
    int idx;
    
    Node(String name, int number, int idx) {
        this.name = name;
        this.number = number;
        this.idx = idx;
    }
}

class Solution {
    public String[] solution(String[] files) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> {
            if (!a.name.equals(b.name)) return a.name.compareTo(b.name);
            if (a.number != b.number) return a.number-b.number;
            return a.idx-b.idx;
        });
        String[] answer = new String[files.length];
        
        for (int i=0; i<files.length; i++) {
            int idx = 0;
            String n1 = "";
            while(true) {
                char c = files[i].charAt(idx);
                if (c <= '9' && c >= '0') break;
                n1 += (c >= 'A' && c <= 'Z') ? c : (char) (c-32);
                idx++;
            }
            
            String n2 = "";
            boolean check = true;
            char c = files[i].charAt(idx);
            int count = 0;
            
            while(idx < files[i].length()) {
                c = files[i].charAt(idx);
                count++;
                if (count == 6) break;
                if (c > '9' || c < '0') break;
                idx++;
                if (check && c == '0') {
                    continue;
                }
                check = false;
                n2 += c;
            }
            pq.offer(new Node(n1, Integer.parseInt(n2.equals("") ? "0" : n2), i));
            
        }
        for (int i=0; i<files.length; i++) {
            answer[i] = files[pq.poll().idx];
        }
        return answer;
    }
}