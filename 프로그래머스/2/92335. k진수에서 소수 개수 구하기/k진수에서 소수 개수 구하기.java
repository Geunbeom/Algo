import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String bit = Integer.toString(n, k);
        
        String str = "";
        for (int i=0; i<bit.length(); i++) {
            if (bit.charAt(i) != '0') str += bit.charAt(i);
            else if(str.length() != 0){
                if(isTrue(Long.parseLong(str))) answer++;
                str = "";
            }
            
            if (i == bit.length()-1 && str.length() != 0)
                if(isTrue(Long.parseLong(str))) answer++;
        }
        
        return answer;
    }
    
    static boolean isTrue(long k) {
        if (k == 1) return false;
        
        for (int i=2; i<=(long) Math.sqrt(k); i++) {
            if (k%i == 0) return false;
        }
        return true;
    }
    
}