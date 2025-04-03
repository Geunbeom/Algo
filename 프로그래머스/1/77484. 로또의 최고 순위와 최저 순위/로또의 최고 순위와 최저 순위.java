class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int[] answer = new int[2];
        int count = 0;
        int t = 0;
        
        for (int r=0; r<6; r++) {
            if (lottos[r] == 0) {
                t++;
                continue;
            }
            
            for (int c=0; c<6; c++) {
                if (lottos[r] == win_nums[c]) count++;
            }
        }
        answer[0] = (7-t-count != 7 ? 7-t-count : 6);
        answer[1] = (7-count != 7 ? 7-count : 6);
        
        return answer;
    }
}