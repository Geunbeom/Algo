class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i=0; i<numbers.length; i++) {
            long k = getBit(numbers[i]);
            answer[i] = k;
        }
        
        return answer;
    }
    
    static long getBit(long bit) {
        long k = 0;
        int min = 64;
        int max = 0;
        
        for (int i=0; i<64; i++) {
            if ((bit & ((long) 1<<i)) != 0) max = Math.max(max, i);
            else min = Math.min(min, i);
        }
        
        if (min > max) {
            k = bit | ((long) 1<<min);
            k = k ^ ((long) 1<<max);
        }else {
            if (bit%2 == 0) k = bit+1;
            else {
                k = bit | ((long) 1<<min);
                k = k ^ ((long) 1<<(min-1));
            }
        }
        
        
        return k;
    }
    
}