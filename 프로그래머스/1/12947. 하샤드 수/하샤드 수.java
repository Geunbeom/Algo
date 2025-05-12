class Solution {
    public boolean solution(int x) {
        boolean answer = true;
        int k = 0;
        for (int i=1; i<=1000; i*=10) {
            if (x/i == 0) break;
            k += (x%(i*10))/i;
        }
        
        return x%k==0;
    }
}