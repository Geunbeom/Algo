import java.util.*;

class Solution {
    public int solution(String str1, String str2) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        int a = 0;
        int b = 0;
        for (int i=0; i<str1.length()-1; i++) {
            char c = str1.charAt(i);
            char n = str1.charAt(i+1);
            if (c >= 'A' && c <= 'Z') c = (char) (c+32);
            if (n >= 'A' && n <= 'Z') n = (char) (n+32);
            if (c >= 'a' && c <= 'z' && n >= 'a' && n <= 'z') {
                map.put(c*1000+n, map.getOrDefault(c*1000+n, 0)+1);
                b += 1;
            }
        }
        for (int i=0; i<str2.length()-1; i++) {
            char c = str2.charAt(i);
            char n = str2.charAt(i+1);
            if (c >= 'A' && c <= 'Z') c = (char) (c+32);
            if (n >= 'A' && n <= 'Z') n = (char) (n+32);
            if (c >= 'a' && c <= 'z' && n >= 'a' && n <= 'z') {
                if (map.getOrDefault(c*1000+n, 0) != 0) {
                    a += 1;
                    map.put(c*1000+n, map.get(c*1000+n)-1);
                } else {
                    b += 1;
                }
            }
        }
        if (b == 0) {
            b = 1;
            a = 1;
        }
        return (int) (((double) a / (double) b) * 65536);
    }
    
    public int match(String str1, String str2) {
        int a = 0;
        int b = 0;
        char prev1 = (char) (str1.charAt(0) + (str1.charAt(0) < 97 ? 32 : 0));
        char prev2 = (char) (str2.charAt(0) + (str2.charAt(0) < 97 ? 32 : 0));
        String s1 = "";
        String s2 = "";
        for (int i=1; i<str1.length(); i++) {
            if (i < str2.length()) {
                char a1 = (char) (str1.charAt(i) + (str1.charAt(i) < 97 ? 32 : 0));
                char a2 = (char) (str2.charAt(i) + (str2.charAt(i) < 97 ? 32 : 0));
                if (prev1 >= 'a' && prev1 <= 'z'
                   && a1 >= 'a' && a1 <= 'z') s1 = prev1 + "" + a1;
                else s1 = "";
                if (prev2 >= 'a' && prev2 <= 'z'
                   && a2 >= 'a' && a2 <= 'z') s2 = prev2 + "" + a2;
                else s2 = "";
                prev1 = a1;
                prev2 = a2;
            }else {
                char a1 = (char) (str1.charAt(i) + (str1.charAt(i) < 97 ? 32 : 0));
                if (prev1 >= 'a' && prev1 <= 'z'
                   && a1 >= 'a' && a1 <= 'z') s1 = prev1 + "" + a1;
                else s1 = "";
                prev1 = a1;
            }
            
            if (s1.equals(s2)) {
                System.out.println(s1 + " " + s2);
                b+=1;
                a+=1;
            }else {
                b+=2;
            }
        }
        return (int) (((double) a / (double) b) * 65536);
    }
    
    
}