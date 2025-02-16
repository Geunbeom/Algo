class Solution {
    public String solution(int[] food) {
        String rev = "";
        String answer = "";
        
        for (int i=1; i<food.length; i++) {
            for (int j=0; j<food[i]/2; j++) {
                answer += i;
                rev = i + rev;
            }
        }
        
        return answer + "0" + rev;
    }
}