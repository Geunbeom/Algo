import java.util.*;

class Solution {
    
    static String answer = "";
    
    public String solution(String p) {
        check(p);
        return answer;
    }
    
    static boolean isTrue(String p) {
        Stack<Boolean> stack = new Stack<>();
        for (int i=0; i<p.length(); i++) {
            if (p.charAt(i) == '(') stack.push(true);
            else {
                try {
                    stack.pop();
                }catch (Exception e) {
                    return false;
                }
            }
        }
        return true;
    }
    
    static void check(String str) {
        if (str.length() == 0) return;
        
        int s = 0;
        int e = 0;
        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == '(') s++;
            else e++;
            if (s == e) {
                String u = str.substring(0, i+1);
                if (isTrue(u)) {
                    answer += u;
                    check(str.substring(i+1, str.length()));
                }else {
                    answer += "(";
                    check(str.substring(i+1, str.length()));
                    answer += ")";
                    for (int j=1; j<u.length()-1; j++) {
                        if (u.charAt(j) == '(') answer += ")";
                        else answer += "(";
                    }
                }
                break;
            }
            
        }
    }
}