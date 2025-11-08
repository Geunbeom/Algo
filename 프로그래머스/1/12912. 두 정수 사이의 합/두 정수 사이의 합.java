class Solution {
    public long solution(int a, int b) {
        int min = Math.min(a, b);
        int max = Math.max(a, b);
        int n = max-min+1;
        
        return (long) n*(max+min)/2;
    }
}