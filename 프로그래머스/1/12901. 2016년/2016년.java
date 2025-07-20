class Solution {
    public String solution(int a, int b) {
        int[] arr = new int[] {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30};
        String[] week = new String[] {"THU", "FRI", "SAT", "SUN", "MON", "TUE", "WED"};
        int k = 0;
        for (int i=0; i<a-1; i++) k += arr[i];
        k += b;
        k %= 7;
        return week[k];
    }
}