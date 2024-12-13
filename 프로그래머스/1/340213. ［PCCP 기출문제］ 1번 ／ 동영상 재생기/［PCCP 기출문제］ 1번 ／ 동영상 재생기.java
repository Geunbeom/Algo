class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        pos = check(op_start, op_end, pos);
        for (int i=0; i<commands.length; i++) {
            if (commands[i].equals("prev")) {
                pos = prev(pos);
            }else {
                pos = next(video_len, pos);
            }
            pos = check(op_start, op_end, pos);
        }
        
        
        
        
        
        return pos;
    }
    
    public static String prev(String pos) {
        int pm = (pos.charAt(0) - '0') * 10 + (pos.charAt(1) - '0');
        int ps = (pos.charAt(3) - '0') * 10 + (pos.charAt(4) - '0') - 10;
        
        if (ps < 0) {
            ps = 60 + ps;
            pm -= 1;
        }
        if (pm < 0) {
            pm = 0;
            ps = 0;
        }
        
        return ((pm < 10 ? ("0" + pm) : pm) + ":" + (ps < 10 ? ("0" + ps) : ps));
    }
    
    public static String next(String video, String pos) {
        int min = (video.charAt(0) - '0') * 10 + (video.charAt(1) - '0');
        int sec = (video.charAt(3) - '0') * 10 + (video.charAt(4) - '0');
        int pm = (pos.charAt(0) - '0') * 10 + (pos.charAt(1) - '0');
        int ps = (pos.charAt(3) - '0') * 10 + (pos.charAt(4) - '0') + 10;
        
        if (ps > 60) {
            ps -= 60;
            pm += 1;
        }
        if (pm >= min && ps > sec) {
            pm = min;
            ps = sec;
        }
        
        
        return ((pm < 10 ? ("0" + pm) : pm) + ":" + (ps < 10 ? ("0" + ps) : ps));
    }
    
    public static String check(String start, String end, String pos) {
        int sm = (start.charAt(0) - '0') * 10 + (start.charAt(1) - '0');
        int ss = (start.charAt(3) - '0') * 10 + (start.charAt(4) - '0');
        int em = (end.charAt(0) - '0') * 10 + (end.charAt(1) - '0');
        int es = (end.charAt(3) - '0') * 10 + (end.charAt(4) - '0');
        int pm = (pos.charAt(0) - '0') * 10 + (pos.charAt(1) - '0');
        int ps = (pos.charAt(3) - '0') * 10 + (pos.charAt(4) - '0');
        
        if (sm * 60 + ss <= pm * 60 + ps && pm * 60 + ps < em * 60 + es) {
            return end;
        }
        
        return pos;
    }
    
}