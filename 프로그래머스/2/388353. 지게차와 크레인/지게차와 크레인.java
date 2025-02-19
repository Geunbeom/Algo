import java.util.*;

class Solution {
    public int solution(String[] storage, String[] requests) {
        int answer = 0;
        int N = storage.length;
        int M = storage[0].length();
        LinkedList<Integer> q = new LinkedList<>();
        
        for (int i=0; i<requests.length; i++) {
            char c = requests[i].charAt(0); 
            if (requests[i].length() == 1) {
                check1(storage, c, q);
            }else {
                check2(storage, c, q);
            }
            while(!q.isEmpty()) {
                int index = q.poll();
                storage[index/M] =
                    storage[index/M].substring(0, index%M) + '0'
                    + storage[index/M].substring(index%M+1);
            }
        }
        for (int r=0; r<N; r++) {
            for (int c=0; c<M; c++) {
                if(storage[r].charAt(c) != '0') answer += 1;
            }
        }
        
        return answer;
    }
    
    static void check1(String[] storage, char c, LinkedList<Integer> q) {
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        int N = storage.length;
        int M = storage[0].length();
        
        for (int i=0; i<N; i++) {
            out : for (int j=0; j<M; j++) {
                if (storage[i].charAt(j) != c) continue;
                for (int k=0; k<4; k++) {
                    int R = dr[k] + i;
                    int C = dc[k] + j;
                    if (R < 0 || R >= N || C < 0 || C >= M) {
                        q.offer(i*M+j);
                        continue out;
                    }else if (storage[R].charAt(C) == '0') {
                        if (check3(storage, i, j)) {
                            q.offer(i*M+j);
                            continue out;
                        }
                    }
                }
            }
        }
    }
    
    static void check2(String[] storage, char c, LinkedList<Integer> q) {
        int N = storage.length;
        int M = storage[0].length();
        
        for (int i=0; i<N; i++) {
            for (int j=0; j<M; j++) {
                if (storage[i].charAt(j) == c) q.offer(i*M+j);
            }
        }
    }
    
    static boolean check3(String[] storage, int r, int c) {
        int N = storage.length;
        int M = storage[0].length();
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        LinkedList<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[N*M];
        q.offer(r*M+c);
        visited[r*M+c] = true;
        
        while(!q.isEmpty()) {
            int curr = q.poll();
            int cr = curr/M;
            int cc = curr%M;
            
            for (int i=0; i<4; i++) {
                int R = dr[i] + cr;
                int C = dc[i] + cc;
                if (R < 0 || C < 0 || R >= N || C >= M
                    || storage[R].charAt(C) != '0') continue;
                if (R == 0 || C == 0 || R == N-1 || C == M-1) return true;
                if (visited[R*M+C]) continue;
                q.offer(R*M+C);
                visited[R*M+C] = true;
            }
        }
        
        
        return false;
    }
    
}