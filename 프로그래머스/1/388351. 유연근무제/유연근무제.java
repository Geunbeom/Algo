class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = schedules.length;
        
        for (int i=0; i<schedules.length; i++) {
            
            int time = schedules[i]/100*60 + schedules[i]%100 + 10;
            
            for (int j=0; j<7; j++) {
                int k = (startday+j) == 7 ? 6 : (startday+j)%7-1;
                if (k == 5 || k == 6) continue;
                
                int curr = timelogs[i][j]/100*60 + timelogs[i][j]%100;
                if (curr > time) {
                    answer -= 1;
                    break;
                }
            }
        }
        
        return answer;
    }
}