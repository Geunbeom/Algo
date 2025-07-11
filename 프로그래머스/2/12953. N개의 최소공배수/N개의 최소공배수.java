class Solution {
    public int solution(int[] arr) {
        int prev = arr[0];
        for (int i=1; i<arr.length; i++) {
            prev = (prev*arr[i])/div(prev, arr[i]);
        }
        return prev;
    }
    
    public int div(int a, int b) {
        return b==0?a:div(b, a%b);
    }
}