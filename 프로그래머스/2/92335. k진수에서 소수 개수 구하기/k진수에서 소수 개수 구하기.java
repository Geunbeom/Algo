import java.util.*;

class Solution {
    public int solution(int n, int k) {
        int answer = 0;
        String bit = Integer.toString(n, k);
        ArrayList<Long> arr = new ArrayList<>();
        
        String str = "";
        for (int i=0; i<bit.length(); i++) {
            if (bit.charAt(i) != '0') str += bit.charAt(i);
            else if(str.length() != 0){
                arr.add(Long.parseLong(str));
                str = "";
            }
            
            if (i == bit.length()-1 && str.length() != 0)
                arr.add(Long.parseLong(str));
        }
        
        for (long i : arr) if(isTrue(i)) answer++;
        
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