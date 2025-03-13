import java.util.*;

class Solution {
    public int solution(int[] elements) {
        HashSet<Integer> set = new HashSet<>();
        int l = elements.length;
        for (int i=0; i<l; i++) {
            int k = 0;
            for (int j=0; j<l; j++) {
                int c = (i+j) < l ? (i+j) : (i+j-l);
                k+=elements[c];
                set.add(k);
            }
        }
        
        
        return set.size();
    }
}