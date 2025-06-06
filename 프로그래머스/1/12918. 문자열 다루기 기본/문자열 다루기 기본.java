class Solution {
    public boolean solution(String s) {
        int l = s.length();
        if (l != 4 && l != 6) return false;
        for (int i=0; i<l; i++)
            if(s.charAt(i) > '9' || s.charAt(i) < '0') return false;
        return true;
    }
}