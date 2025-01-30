import java.util.*;

class Solution {
    public int solution(String[] board) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int o = 0;
        int x = 0;
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                char c = board[i].charAt(j);
                boolean check = true;
                if (c == '.') continue;
                else if(c == 'X') {
                    x++;
                    check = false;
                }else o++;
                int t = 0;
                
                t = (j+1)*10 + (check?0:1);
                if (map.get(t) == null) map.put(t,0);
                map.put(t, map.get(t)+1);
                
                t = (i+1)*100 + (check?0:1);
                if (map.get(t) == null) map.put(t,0);
                map.put(t, map.get(t)+1);
                
                if (i == j) {
                    t = 1000 + (check?0:1);
                    if (map.get(t) == null) map.put(t,0);
                    map.put(t, map.get(t)+1);
                }if (i+j == 2) {
                    t = 2000 + (check?0:1);
                    if (map.get(t) == null) map.put(t,0);
                    map.put(t, map.get(t)+1);
                }
            }
        }
        
        if (x > o || o >= x+2) return 0;
        boolean rowCheck = false;
        boolean calCheck = false;
        for (int key : map.keySet()) {
            boolean isRow = key%1000/100 != 0;
            boolean isCal = !isRow && (key/1000 == 0);
            
            if (map.get(key) == 3) {
                if ((rowCheck && isRow) || (calCheck && isCal)) return 0;
                rowCheck = isRow ? true : rowCheck;
                calCheck = isCal ? true : calCheck;
                if ((key%10 == 1) && o != x) return 0;
                else if((key%10 == 0) && o != x+1) return 0;
            }
        }
        return 1;
    }
}