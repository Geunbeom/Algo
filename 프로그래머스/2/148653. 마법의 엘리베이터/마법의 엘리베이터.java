class Solution {
    public int solution(int storey) {
        int answer = 0;
        
        int k = 10;
        while((storey*10)/k != 0) {
            int c = (storey%k)/(k/10);
            int t = k*10;
            if (c < 5) answer += c;
            else if (c == 5 && (storey%t)/(t/10) < 5) {
                answer += c;
            }else {
                answer += (10-c);
                storey += k;
            }
            
            if (k == 1000000000) break;
            k *= 10;
        }
        return answer;
    }
}