import java.util.*;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int answer = 0;
        int max = picks[0] + picks[1] + picks[2];
        int[] arr = new int[minerals.length/5+1];
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i=0; i<minerals.length; i++) {
            if (i/5 == max) break;
            switch(minerals[i]) {
                case ("diamond") :
                    arr[i/5] += 100;
                    break;
                case ("iron") :
                    arr[i/5] += 10;
                    break;
                case ("stone") :
                    arr[i/5] += 1;
                    break;
            }
        }
        
        Arrays.sort(arr);
        
        for (int i=arr.length-1; i>=0; i--) {
            if (arr[i] == 0) continue;
            if (picks[0] != 0) {
                picks[0]--;
                answer += (arr[i]/100 + arr[i]%100/10 + arr[i]%10);
            }else if (picks[1] != 0) {
                picks[1]--;
                answer += (arr[i]/100*5 + arr[i]%100/10 + arr[i]%10);
            }else if (picks[2] != 0) {
                picks[2]--;
                answer += (arr[i]/100*25 + arr[i]%100/10*5 + arr[i]%10);
            }
        }
        
        return answer;
    }
}