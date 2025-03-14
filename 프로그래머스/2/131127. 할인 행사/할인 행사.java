import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        LinkedList<Integer> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        int answer = 0;
        int code = 0;
        int curr = -1;
        for (int i=0; i<number.length; i++) {
            code += (int) Math.pow(10, i)*(number[i]%10);
        }
        
        for (int i=0; i<discount.length; i++) {
            boolean check = false;
            while(q.size() >= 10) {
                int c = q.pop();
                if (c != -1) {
                    int k = (int) Math.pow(10, c);
                    if (curr==1) curr=-1;
                    else curr -= ((curr/k%10) == 0 ? (-9*k) : k);
                }
            }
            for (int j=0; j<want.length; j++) {
                if (want[j].equals(discount[i])) {
                    check = true;
                    q.offer(j);
                    int k = (int) Math.pow(10,j);
                    if (curr==-1) curr=0;
                    curr += ((curr/k%10) == 9 ? (-9*k) : k);
                }
            }
            if (!check) q.offer(-1);

            if (code == curr) answer += 1;
            
        }
        
        return answer;
    }
}