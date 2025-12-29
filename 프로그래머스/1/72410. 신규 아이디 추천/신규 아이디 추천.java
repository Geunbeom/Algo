class Solution {
    public String solution(String new_id) {
        String answer = "";
        
        for (int i=0; i<new_id.length(); i++) {
            char c = new_id.charAt(i);
            if (c>='A'&&c<='Z') c += 32;
            if (c!='-' && c!='_' && c!='.' && !(c>='a' && c<='z') && !(c>='0'&&c<='9')) continue;
            
            if (c=='.') {
                if (answer.length() != 0 && answer.charAt(answer.length()-1) != '.') answer += String.valueOf(c);
            } else {
                answer += String.valueOf(c);
            }
            
            if (answer.length() == 15) {
                if (answer.charAt(14) == '.') return answer.substring(0, 14);
                else return answer;
            }
        }
        if (answer.length() == 0) return "aaa";
        else if (answer.charAt(answer.length()-1) == '.') answer = answer.substring(0, answer.length()-1);
        while (answer.length() < 3) answer += String.valueOf(answer.charAt(answer.length()-1));
        
        return answer;
    }
}