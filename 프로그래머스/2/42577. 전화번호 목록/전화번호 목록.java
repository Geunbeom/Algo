import java.util.*;
class Solution {
    public boolean solution(String[] phone_book) {
        HashSet<String> set = new HashSet<>();
        Arrays.sort(phone_book, (a, b) -> {
            return a.length()-b.length();
        });
        for (String s : phone_book) {
            String t = "";
            for (int i=0; i<s.length(); i++) {
                t += s.charAt(i);
                if (set.contains(t)) return false;
            }
            set.add(s);
        }
        
        
        return true;
    }
}