class Solution
{
    public int solution(int n, int a, int b)
    {
        int answer = 1;
        a -= 1;
        b -= 1;
        for (int i=2; i<=n; i*=2) {
            a /= 2;
            b /= 2;
            if (a == b) {
                break;
            }
            answer++;
        }

        return answer;
    }
}