import java.util.*;

class Solution {
    public int solution(String dirs) {
        int curr = 60;
        HashSet<Integer> set = new HashSet<>();
        
        for (int i=0; i<dirs.length(); i++) {
            switch(dirs.charAt(i)) {
                case 'U' :
                    if (curr+11 > 120) break;
                    set.add(curr*1000 + (curr+11));
                    set.add(curr + (curr+11)*1000);
                    curr += 11;
                    break;
                case 'D' :
                    if (curr-11 < 0) break;
                    set.add(curr*1000 + (curr-11));
                    set.add(curr + (curr-11)*1000);
                    curr -= 11;
                    break;
                case 'R' :
                    if (curr%11 == 10) break;
                    set.add(curr*1000 + (curr+1));
                    set.add(curr + (curr+1)*1000);
                    curr += 1;
                    break;
                case 'L' :
                    if (curr%11 == 0) break;
                    set.add(curr*1000 + (curr-1));
                    set.add(curr + (curr-1)*1000);
                    curr -= 1;
                    break;
            }
        }
        return set.size()/2;
    }
}