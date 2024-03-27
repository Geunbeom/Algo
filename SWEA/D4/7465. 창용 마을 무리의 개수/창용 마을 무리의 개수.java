import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
     
    static int N, M, cnt;
    static boolean arr[][];
    static boolean[] visited;
     
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 
        int T = Integer.parseInt(br.readLine());
         
        for (int t=1; t<=T; t++) {
             
            StringTokenizer st = new StringTokenizer(br.readLine());
             
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            cnt = 0;
            arr = new boolean[N+1][N+1];
            visited = new boolean[N+1];
            visited[0] = true;
             
            for (int i=0; i<M; i++) {
                st = new StringTokenizer(br.readLine());
                int r = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                 
                arr[r][c] = true; arr[c][r] = true;
            }
             
            for (int i=1; i<N+1; i++) {
                if (!visited[i]) {
                    search(i);
                    cnt++;
                }
            }
             
            System.out.println("#" + t+ " " + cnt);
             
             
        }
 
    }
     
    static void search(int n) {
        visited[n] = true;
        for (int c=1; c<N+1; c++) {
            if (arr[n][c] && !visited[c]) {
                search(c);
            }
        }
    }
 
}