class Solution {
    
    static char[] arr = {'A', 'E', 'I', 'O', 'U'};
    static String ans;
    static int count = -1;
        
    public int solution(String word) {
        int answer = 0;
        ans = word;
        dfs("", 0);
        return count;
    }
    
    static boolean dfs(String curr, int index) {
        count++;
        if (curr.equals(ans)) {
            return true;
        }
        if (curr.length() > 4) return false;
        
        for (int i=0; i<5; i++) {
            if(dfs(curr+arr[i], i)) return true;
        }
        
        return false;
    }
    
}