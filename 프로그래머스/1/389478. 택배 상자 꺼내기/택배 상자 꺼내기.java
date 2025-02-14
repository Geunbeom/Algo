class Solution {
    public int solution(int n, int w, int num) {
        int answer = 0;
        int floor = n/w;
        int currF = (num-1)/w;
        answer += (floor-currF);
        
        int a = currF%2 == 0 ? num - (currF)*w : -(num - (currF)*w);
        a = a < 0 ? (a + w + 1) : a;
        int b = floor%2 == 0 ? n-(w*floor) : -(n-(w*floor));
        if (b > 0 && a <= b) answer += 1;
        else if(b < 0 && b+w < a) answer += 1;
        return answer;
    }
}