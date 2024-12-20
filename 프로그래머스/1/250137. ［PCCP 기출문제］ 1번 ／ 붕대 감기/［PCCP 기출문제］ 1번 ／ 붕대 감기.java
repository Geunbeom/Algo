class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int answer = health;
        int con = 0;
        int idx = 0;
        for(int t=1; t<=attacks[attacks.length-1][0]; t++) {
            if (attacks[idx][0] == t) {
                answer -= attacks[idx++][1];
                con = 0;
                if (answer <= 0) {
                    answer = -1;
                    break;
                }
                continue;
            }
            
            if (answer < health) {
                answer += bandage[1];
            }
            if (++con == bandage[0]) {
                con = 0;
                answer += bandage[2];
            }
            if (answer > health) answer = health;
        }
        
        
        
        return answer;
    }
}