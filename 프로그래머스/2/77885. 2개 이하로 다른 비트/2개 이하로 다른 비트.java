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
        if (bit%2 == 0) return bit+1;
        
        int k = 0;
        for (int i=0; i<64; i++) {
            if ((bit & ((long) 1<<i)) == 0) {
                k = i;
                break;
            }
        }

        bit |= ((long) 1<<k);
        bit ^= ((long) 1<<(k-1));
        
        return bit;
    }
    
}