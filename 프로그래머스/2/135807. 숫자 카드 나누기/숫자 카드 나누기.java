class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int a = arrayA[0];
        int b = arrayB[0];
        
        for (int i=1; i<arrayA.length; i++) {
            a = getD(a, arrayA[i]);
            b = getD(b, arrayB[i]);
        }
        
        for (int i=0; i<arrayA.length; i++) {
            if (a == 0 && b == 0) return 0;
            if (a != 0) a = arrayB[i]%a == 0 ? 0 : a;
            if (b != 0) b = arrayA[i]%b == 0 ? 0 : b;
            
        }
        
        return a > b ? a : b;
    }
    
    public int getD(int a, int b) {
        return b == 0 ? a : getD(b, a%b);
    }
        
    
}