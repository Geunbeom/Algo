import java.util.*;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        int answer = 0;
        int idx = 1; 
        HashMap<String, int[]> map = new HashMap<String, int[]>();
        int[][] arr = new int[friends.length+1][friends.length+1];
        
        for (String f : friends) {
            // idx, 선물 지수, 받는 선물
            map.put(f, new int[] {idx++, 0, 0});
        }
        
        for (String g : gifts) {
            String[] gs = g.split(" ");
            int i = map.get(gs[0])[0];
            int j = map.get(gs[1])[0];
            arr[i][j]++;
            arr[0][j]++;
            arr[i][0]++;
        }
        
        for (int r=1; r<arr.length; r++) {
            map.get(friends[r-1])[1] = arr[r][0] - arr[0][r];
        }
        
        for (int r=1; r<arr.length; r++) {
            for (int c=r; c<arr.length; c++) {
                if (r == c) continue;
                
                if (arr[r][c] > arr[c][r]) {
                    map.get(friends[r-1])[2]++;
                }else if (arr[r][c] < arr[c][r]) {
                    map.get(friends[c-1])[2]++;
                }else if (map.get(friends[c-1])[1] > map.get(friends[r-1])[1]){
                    map.get(friends[c-1])[2]++;
                }else if (map.get(friends[c-1])[1] < map.get(friends[r-1])[1]){
                    map.get(friends[r-1])[2]++;
                }
                
            }
        }
        
        for (String key : map.keySet()) {
            // System.out.println(key + " " + map.get(key)[2]);
            answer = Math.max(map.get(key)[2], answer);
        }
        
        return answer;
    }
}