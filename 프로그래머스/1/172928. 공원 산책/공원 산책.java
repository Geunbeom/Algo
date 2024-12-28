class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {0, 0};
        int H = park.length;
        int W = park[0].length();
        
        for (int r=0; r<H; r++) {
            for (int c=0; c<W; c++) {
                if (park[r].charAt(c) == 'S') {
                    answer[0] = r;
                    answer[1] = c;
                    break;
                }
            }
        }
        int t = 0;
        for (int i=0; i<routes.length; i++) {
            int k = 0;
            switch(routes[i].charAt(0)) {
                
                case 'E' :
                    t = routes[i].charAt(2) - '0';
                    while(t != 0) {
                        k++;
                        if (answer[1]+k > W - 1 || park[answer[0]].charAt(answer[1]+k) == 'X') {
                            k = 0;
                            break;
                        }
                        t--;
                    }
                    answer[1] += k;
                    break;
                    
                case 'W' :
                    t = routes[i].charAt(2) - '0';
                    while(t != 0) {
                        k--;
                        if (answer[1]+k < 0 || park[answer[0]].charAt(answer[1]+k) == 'X') {
                            k = 0;
                            break;
                        }
                        t--;
                    }
                    answer[1] += k;
                    break;
                    
                case 'S' :
                    t = routes[i].charAt(2) - '0';
                    while(t != 0) {
                        k++;
                        if (answer[0]+k > H - 1 || park[answer[0]+k].charAt(answer[1]) == 'X') {
                            k = 0;
                            break;
                        }
                        t--;
                    }
                    answer[0] += k;
                    break;
                    
                case 'N' :
                    t = routes[i].charAt(2) - '0';
                    while(t != 0) {
                        k--;
                        if (answer[0]+k < 0 || park[answer[0]+k].charAt(answer[1]) == 'X') {
                            k = 0;
                            break;
                        }
                        t--;
                    }
                    answer[0] += k;
                    break;
                
            }
        }
        
        
        
        return answer;
    }
}