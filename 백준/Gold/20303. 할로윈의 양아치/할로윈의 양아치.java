import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static int N, M, K; 
    static int[][] p;
    static int answer;

    static public void main(String[] args) throws Exception {
        input();
        play();
        System.out.println(answer);
    }

    static public void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        p = new int[N][3];

        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            p[i][0] = i;
            p[i][1] = 1;
            p[i][2] = Integer.parseInt(st.nextToken());
        }

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken())-1;
            int b = Integer.parseInt(st.nextToken())-1;
            int fa = find(a);
            int fb = find(b);
            if (fa!=fb) union(fa, fb);
        }
    }

    static void play() {
        int[] bag = new int[K];
        for(int i=0; i<N; i++) {
            if (i != p[i][0] || p[i][1] >= K) continue;
            
            int v = p[i][1];
            int k = p[i][2];
            for (int j=K-1; j>v; j--) {
                if (bag[j-v] == 0) continue;
                bag[j] = Math.max(bag[j], bag[j-v]+k);
            }

            if (bag[v] == 0) bag[v] = k;
            else bag[v] = Math.max(bag[v], k);
        }

        answer = 0;
        for (int i=1; i<K; i++) {
            answer = Math.max(bag[i], answer);
        }
    }

    static void union(int a, int b) {
        if (a < b) {
            p[b][0] = a;
            p[a][1] += p[b][1];
            p[a][2] += p[b][2];
        } else {
            p[a][0] = b;
            p[b][1] += p[a][1];
            p[b][2] += p[a][2];
        }
    }
    
    static int find(int k) {
        if (k == p[k][0]) return k;
        return find(p[k][0]);
    }

}