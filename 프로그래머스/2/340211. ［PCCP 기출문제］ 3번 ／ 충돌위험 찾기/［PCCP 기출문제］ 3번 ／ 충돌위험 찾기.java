class Solution {
    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int[][] robots = new int[routes.length][3];
        int[][] map = new int[101][101];
    
        for (int i=0; i<routes.length; i++) {
            robots[i][0] = points[routes[i][0]-1][0];
            robots[i][1] = points[routes[i][0]-1][1];
            if (map[robots[i][0]][robots[i][1]] == 1) answer++;
            map[robots[i][0]][robots[i][1]]++;
            
        }
        
        int count = 0;
        while(true) {
            map = new int[101][101];
            for (int i=0; i<robots.length; i++) {
                int[] curr = robots[i];
                
                int p = robots[i][2];
                if (routes[i].length == p+1) {
                    continue;
                }
                move(routes[i][p+1], points, curr);
                int[] goal = points[routes[i][p+1]-1];
                
                if (goal[0] == curr[0] && goal[1] == curr[1]) robots[i][2]++;
                robots[i] = new int[] {curr[0], curr[1], robots[i][2]};
                if (map[curr[0]][curr[1]] == 1) {
                    answer++;
                }
                map[curr[0]][curr[1]]++;
                
                if (routes[i].length == robots[i][2]+1) {
                    count++;
                }
            }
            if (count == robots.length) break;
        }
        
        
        return answer;
    }
    
    static public void move(int a, int[][] points, int[] curr) {
        int[] next = points[a-1];
        
        if (next[0] > curr[0]) curr[0]++;
        else if(next[0] < curr[0]) curr[0]--;
        else {
            if (next[1] > curr[1]) curr[1]++;
            else if (next[1] < curr[1]) curr[1]--;
        }
    }
    
}