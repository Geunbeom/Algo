class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        
        for (int i=0; i<n; i++) {
            int bit = (arr1[i] | arr2[i]);
            String str = "";
            
            for (int j=n-1; j>=0; j--) {
                if ((bit & (1<<j)) != 0) str += "#";
                else str += " ";
            }
            answer[i] = str;
        }
        
        return answer;
    }
}