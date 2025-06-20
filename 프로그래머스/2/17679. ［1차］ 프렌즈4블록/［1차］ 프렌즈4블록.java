import java.util.*;
class Solution {
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        HashSet<Integer> set = new HashSet<>();
        
        while (true) {
            for (int r=0; r<m; r++) {
                for (int c=0; c<n; c++) {
                    char curr = board[r].charAt(c);
                    if (curr == '0') continue;
                    if (r+1==m || c+1==n) continue;
                    if (curr == board[r+1].charAt(c)
                       && curr == board[r].charAt(c+1)
                       && curr == board[r+1].charAt(c+1)) {
                        set.add(r*100+c);
                        set.add((r+1)*100+c);
                        set.add(r*100+c+1);
                        set.add((r+1)*100+c+1);
                    }
                }
            }
            if (set.size() == 0) break;
            answer += set.size();
            Iterator iter = set.iterator();
            
            while(iter.hasNext()) {
                int v = (int) iter.next();
                iter.remove();
                int r = v/100;
                int c = v%100;
                board[r]=board[r].substring(0, c) + "0" + board[r].substring(c+1, n);
            }
            
            for (int r=m-1; r>=0; r--) {
                for (int c=n-1; c>=0; c--) {
                    if (board[r].charAt(c) != '0') continue;
                    int r2 = r-1;
                    while (r2 >= 0) {
                        if (board[r2].charAt(c) == '0') r2 -= 1;
                        else {
                            board[r] = board[r].substring(0, c)
                                + board[r2].charAt(c) + board[r].substring(c+1, n);
                            board[r2] = board[r2].substring(0, c)
                                + "0" + board[r2].substring(c+1, n);
                            break;
                        }
                    }
                }
            }
        }
        
        return answer;
    }
}