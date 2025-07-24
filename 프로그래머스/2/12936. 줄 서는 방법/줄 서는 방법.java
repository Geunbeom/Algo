import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        int[] answer = new int[n];
        long code = 1;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=1; i<=n; i++) {
            list.add(i);
            code *= i;
        }
        int index = 0;
        while(n>0) {
            int s = (int) ((k-1)/(code/n));
            answer[index] = list.get(s);
            list.remove(s);
            index++;
            k = (k-1)%(code/n)+1;
            code /= n;
            n--;
        }
        
        return answer;
    }
}