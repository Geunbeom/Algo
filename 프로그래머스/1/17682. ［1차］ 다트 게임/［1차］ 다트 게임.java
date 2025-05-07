class Solution {
    public int solution(String dartResult) {
        int idx = 0;
        int[] a = new int[3];
        
        for (int i=0; i<3; i++) {
            a[i] = dartResult.charAt(idx)-'0';
            char c = dartResult.charAt(idx+1);
            if (c == '0') {
                a[i] = 10;
                c = dartResult.charAt(idx+2);
                idx += 1;
            }
            switch(c) {
                case 'S' :
                    break;
                case 'D' :
                    a[i] *= a[i];
                    break;
                case 'T' :
                    a[i] *= (a[i]*a[i]);
                    break;
            }
            idx += 2;
            if (idx < dartResult.length()) {
                c = dartResult.charAt(idx);
                idx += 1;
                if (c == '*') {
                    a[i] *= 2;
                    if (i != 0) a[i-1] *= 2;
                }else if (c == '#') {
                    a[i] *= -1;
                }else idx -= 1;
            }
            
        }
        
        return a[0] + a[1] + a[2];
    }
}