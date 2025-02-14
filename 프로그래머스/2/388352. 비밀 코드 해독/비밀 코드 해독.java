import java.util.*;
import java.io.*;

class Solution {
    
    static Set<Integer> set;
    
    public int solution(int n, int[][] q, int[] ans) {
        set = new HashSet<>();
        cal(0, 0, n, 0);
        
        for (int r=0; r<q.length; r++) {
            Iterator<Integer> iter = set.iterator();
            while (iter.hasNext()) {
                int v = iter.next();
                int bit = 0;
                int count = 0;

                for (int c = 0; c < 5; c++) {
                    bit = (1 << (q[r][c] - 1));
                    if ((v & bit) != 0) count++;
                }
                
                if (count != ans[r]) iter.remove();
            }
        }

        int answer = set.size();
        return answer;
    }
    
    public static void cal(int count, int i, int n, int bit) {
        if (count == 5) {
            set.add(bit);
            return;
        }
        
        for (int t=i; t<n; t++) {
            cal(count+1, t+1, n, bit|(1<<t));
        }
    }
}