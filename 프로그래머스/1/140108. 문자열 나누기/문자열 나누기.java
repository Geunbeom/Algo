class Solution {
    public int solution(String s) {
        int x1 = 0;
        int x2 = 0;
        int answer = 0;
        char x = 'a';
        for (int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            if (i != s.length()-1 && x1 == 0 && x2 == 0) {
                x = c;
                x1 += 1;
                continue;
            } else if(i == s.length()-1 && x1 == 0 && x2 == 0) {
                answer += 1;
                continue;
            }
            if (x == c) x1++;
            else x2++;
            
            if(x1 == x2) {
                answer += 1;
                x1 = 0;
                x2 = 0;
                continue;
            }
            if (i == s.length()-1) answer += 1;
            System.out.print(i+" ");
        }
    
        return answer;
    }
}