import java.util.*;

class Solution {
    static int answer = 0;
    static int l;
    static String number;
    static boolean[] visited;
    static HashSet<Integer> set = new HashSet<>();
    public int solution(String numbers) {
        number = numbers;
        l = number.length();
        visited = new boolean[l];
        dfs("");
        return answer;
    }
    
    public void dfs(String str) {
        if (str.length() != 0) {
            int T = Integer.parseInt(str);
            if (T>=2 && !set.contains(T) && find(T)) {
                set.add(T);
                answer++;
            }
        }
        
        for (int i=0; i<l; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(str+number.charAt(i));
                visited[i] = false;
            }
            
        }
    }
    
    public boolean find(int nu) {
        for (int i=2; i<=Math.sqrt(nu); i++) {
            if (nu%i == 0) return false;
        }
        return true;
    }
    
}