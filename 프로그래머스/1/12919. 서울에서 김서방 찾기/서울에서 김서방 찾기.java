class Solution {
    public String solution(String[] seoul) {
        String answer = "김서방은 ";
        String tail = "에 있다";
        for (int x=0; x<seoul.length; x++) if (seoul[x].equals("Kim")) return answer+x+tail;
        return answer;
    }
}