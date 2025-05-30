class Solution {
    public int solution(String s) {
        char c = s.charAt(0);
        return c == '+' ? Integer.parseInt(s.substring(1, s.length())) :
        (c == '-' ? -Integer.parseInt(s.substring(1, s.length())) :
        Integer.parseInt(s));
    }
}