class Solution {
    
    static String bit = new String();
    
    public int[] solution(String s) {
        int[] answer = new int[2];
        bit = s;
        while (bit.length() != 1) {
            answer[1] += remove(bit);
            answer[0]++;
            bit = makeBit(bit.length());
        }
        return answer;
    }
    
    static int remove(String s) {
        int count = s.length();
        bit = s.replace("0", "");
        count -= bit.length();
        
        return count;
    }
    
    static String makeBit(int n) {
        String k = "";
        boolean check = false;
        for (int i=31; i>=0; i--) {
            if ((n & (1<<i)) != 0) {
                k += "1";
                check = true;
            }else if (check) k += "0";
        }
        return k;
    }
    
}