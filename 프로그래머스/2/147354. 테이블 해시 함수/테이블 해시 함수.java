import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        final int t = col-1;
        int answer = 0;
        Arrays.sort(data, (a, b) -> {
            if (a[t] == b[t]) return b[0]-a[0];
            return a[t]-b[t];
        });
        for (int i=row_begin-1; i<=row_end-1; i++) {
            int bit = 0;
            for (int j=0; j<data[i].length; j++) {
                bit += (data[i][j]%(i+1));
            }
            answer ^= bit;
        }
        
        return answer;
    }
}