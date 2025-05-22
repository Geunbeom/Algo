class Solution {
    public int[] solution(long n) {
        String str = Long.toString(n);
        int l = str.length()-1;
        int[] answer = new int[l+1];
        for (int i=l; i>=0; i--) answer[l-i]=str.charAt(i)-'0';
        return answer;
    }
}