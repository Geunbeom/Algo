import java.util.*;

class Solution {
    public double[] solution(int k, int[][] ranges) {
        double[] answer = new double[ranges.length];
        ArrayList<Integer> h = new ArrayList<>();
        h.add(k);
        while (k != 1) {
            if (k % 2 == 1) k= k*3+1;
            else k = k/2;
            h.add(k);
        }
        
        double[] sum = new double[h.size()];
        for (int i=1; i<sum.length; i++) {
            double h1 = (double) h.get(i-1);
            double h2 = (double) h.get(i);
            double t = h1 < h2 ? h1+(h2-h1)/2 : h2+(h1-h2)/2;
            sum[i] = sum[i-1]+t;
        }
        
        for (int i=0; i<ranges.length; i++) {
            int s = ranges[i][0];
            int e = h.size()+ranges[i][1]-1;
            if (s > e) answer[i] = -1;
            else answer[i] = sum[e]-sum[s];
        }
        return answer;
    }
}