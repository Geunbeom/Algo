import java.util.*;

class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        
        for (int i=0; i<players.length; i++) {
            map.put(players[i], i);
        }
        
        for (int i=0; i<callings.length; i++) {
            String tmp = callings[i];
            int now = map.get(tmp);
            
            players[now] = players[now-1];
            players[now-1] = tmp;
            map.put(players[now], now);
            map.put(players[now-1], now-1);
            
        }
        
        
        
        return players;
    }
}