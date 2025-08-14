class Solution {
    public String solution(String s) {
        char[] a = s.toCharArray();
        int l = s.length();
        return l%2==1?(""+a[l/2]):(a[l/2-1]+""+a[l/2]);
    }
}