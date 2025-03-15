class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int count = 0;
        int l = queue1.length;
        long q1 = 0;
        long q2 = 0;
        for (int i=0; i<queue1.length; i++) {
            q1 += queue1[i];
            q2 += queue2[i];
        }
        
        int index1 = 0;
        int index2 = 0;
        while (true) {
            if (q1 == q2) return count;
            count++;
            if (q1 > q2) {
                int k = (index1 < l ? queue1[index1] : queue2[index1-l]);
                q1-=k;
                q2+=k;
                index1++;
            }else if (q1 < q2) {
                int k = (index2 < l ? queue2[index2] : queue1[index2-l]);
                q2-=k;
                q1+=k;
                index2++;
            }
            if (index2 == 2*l || index1 == 2*l) break;
        }
        if (q1 == q2) return count;
        return -1;
    }
}