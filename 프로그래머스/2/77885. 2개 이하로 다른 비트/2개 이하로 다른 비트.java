class Solution {
    public long[] solution(long[] numbers) {
        long[] answer = new long[numbers.length];
        
        for (int i=0; i<numbers.length; i++) {
            if (numbers[i]%2==0) answer[i] = numbers[i]+1;
            else answer[i] = getBit(numbers[i]);
        }
        
        return answer;
    }
    
    static long getBit(long bit) {
        for (int i=0; i<64; i++) {
            if ((bit & ((long) 1<<i)) == 0) {
                bit |= ((long) 1<<i);
                bit ^= ((long) 1<<(i-1));
                return bit;
            }
        }
        return bit;
    }
    
}