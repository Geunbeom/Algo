class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        int[] arr = new int[26];
        for (int i=0; i<s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (arr[c] == 0) {
                arr[c] = i+1;
                answer[i] = -1;
            } else {
                answer[i] = i-arr[c]+1;
                arr[c] = i+1;
            }
        }
        
        return answer;
    }
}