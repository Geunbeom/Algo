class Solution {
    public int solution(int[] mats, String[][] park) {
        int answer = -1;
        int N = park.length;
        int M = park[0].length;
        int max = -1;
        
        for (int r=0; r<N; r++) {
            for (int c=0; c<M; c++) {
                if (!park[r][c].equals("-1")) continue;
                if (max == -1) max = 1;
                max = Math.max(check(park, r, c), max);
            }
        }
        for (int i=0; i<mats.length; i++) {
            if (mats[i] < max) {

                answer = Math.max(answer, mats[i]);
            }
        }
        
        
        return answer;
    }
    public static int check(String[][] park, int r, int c) {
        int min = 1;
        int max = Math.min(park[0].length-c, park.length-r);
        // System.out.println(max + " " + r + " " + c);
        out : for (min = 2; min<=max; min++) {
            for (int R = r; R<r+min; R++) {
                if (R+1 != r+min) {
                    if (!park[R][c+min-1].equals("-1")) break out;
                    continue;
                }
                for (int C=c; C<c+min; C++) {
                    if (!park[R][C].equals("-1")) break out;
                }
            }
        }
        
        
        return min;
    }
}