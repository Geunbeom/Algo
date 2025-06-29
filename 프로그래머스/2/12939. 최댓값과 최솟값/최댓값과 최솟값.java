class Solution {
    public String solution(String s) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        String[] sarr = s.split(" ");
        for (String str : sarr) {
            max = Math.max(Integer.parseInt(str), max);
            min = Math.min(Integer.parseInt(str), min);
        }
        return min+" "+ max;
    }
}