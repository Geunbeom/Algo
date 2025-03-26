class Solution {
    public long solution(int price, int money, int count) {
        int k = count%2 == 0 ? (count/2*(1+count)) : (count/2*(1+count)+(count/2+1));
        long t = (long) k*price;
        return (long) t <= (long) money ? 0 : ((long) t-money);
    }
}