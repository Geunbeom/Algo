class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        int l = 10;
        int r = 12;
        
        for (int i=0; i<numbers.length; i++) {
            if (numbers[i] == 1 || numbers[i] == 4 || numbers[i] == 7) {
                answer += "L";
                l = numbers[i];
            }else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9) {
                answer += "R";
                r = numbers[i];
            }else {
                if (numbers[i] == 0) numbers[i] = 11;
                int a = getManhattan(l, numbers[i]);
                int b = getManhattan(r, numbers[i]);
                if (a > b) {
                    answer += "R";
                    r = numbers[i];
                }else if (a < b){
                    answer += "L";
                    l = numbers[i];
                }else {
                    if (hand.charAt(0) == 'l') {
                        answer += "L";
                        l = numbers[i];
                    }else {
                        answer += "R";
                        r = numbers[i];
                    }
                }
            }
        }
        
        return answer;
    }
    
    static int getManhattan(int s, int e) {
        return Math.abs(((s-1)/3)-((e-1)/3))
            + Math.abs(((s-1)%3)-((e-1)%3));
    }
    
}