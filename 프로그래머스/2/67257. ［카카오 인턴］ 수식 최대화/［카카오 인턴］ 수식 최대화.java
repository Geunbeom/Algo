import java.util.*;

class Solution {
    public long solution(String expression) {
        long answer = 0;
        ArrayList<Long> nums = new ArrayList<>();
        ArrayList<Character> chars = new ArrayList<>();
        
        String in = "";
        for (int i=0; i<expression.length(); i++) {
            char c = expression.charAt(i);
            if (c >= '0' && c <= '9') in += c;
            else {
                nums.add(Long.parseLong(in));
                chars.add(c);
                in = "";
            }
            if (i == expression.length()-1) nums.add(Long.parseLong(in));
        }
        answer = Math.max(cal(nums, chars, "+-*"),
                    Math.max(cal(nums, chars, "-+*"),
                    cal(nums, chars, "*-+")));
        return answer;
    }
    
    public long cal(ArrayList<Long> real_nums,
    ArrayList<Character> real_chars, String str) {
        
        char f = str.charAt(0);
        long out = 0;
        ArrayList<Long> nums = new ArrayList<>();
        ArrayList<Character> chars = new ArrayList<>();
        
        long curr = 0;
        boolean check = true;
        for (int i=0; i<real_chars.size(); i++) {
            if (real_chars.get(i) == f) {
                switch(f) {
                    case '+':
                        if (check) {
                            curr = real_nums.get(i) + real_nums.get(i+1);
                            check = false;
                        } else curr += real_nums.get(i+1);
                        break;
                    case '-':
                        if (check) {
                            curr = real_nums.get(i) - real_nums.get(i+1);
                            check = false;
                        } else curr -= real_nums.get(i+1);
                        break;
                    case '*':
                        if (check) {
                            curr = real_nums.get(i) * real_nums.get(i+1);
                            check = false;
                        } else curr *= real_nums.get(i+1);
                        break;
                }
            } else {
                if (check) nums.add(real_nums.get(i));
                else {
                    nums.add(curr);
                    check = true;
                }
                chars.add(real_chars.get(i));
            }
        }
        if (!check) nums.add(curr);
        else nums.add(real_nums.get(real_nums.size()-1));
        
        if (str.length() == 2) {
            out = cal(nums, chars, str.substring(1, 2));
        }else if (str.length() == 3) {
            out = Math.max(
                    cal(nums, chars, str.charAt(1) + "" + str.charAt(2)),
                    cal(nums, chars, str.charAt(2) + "" + str.charAt(1))
            );
        } else if(str.length() == 1) {
            return Math.abs(nums.get(0));
        }
        
        return out;
    }
    
}