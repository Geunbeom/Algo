class Solution {
    public int[] solution(String[] wallpaper) {
        int[] answer = {50, 50, 0, 0};
        
        for (int i=0; i<wallpaper.length; i++) {
            for (int j=0; j<wallpaper[0].length(); j++) {
                char c = wallpaper[i].charAt(j);
                if (c == '#') {
                    answer[0] = Math.min(answer[0], i);
                    answer[1] = Math.min(answer[1], j);
                    answer[2] = Math.max(answer[2], i+1);
                    answer[3] = Math.max(answer[3], j+1);
                }
                
            }
        }
        
        return answer;
    }
}