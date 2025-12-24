import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static StringTokenizer st;

    static int N;
    static int[][] arr;
    static long answer;

    static public void main(String[] args) throws Exception {
        input();
        play();
        System.out.println(answer);
    }

    static public void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[4][N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<4; j++) {
                int k = Integer.parseInt(st.nextToken());
                arr[j][i] = k;
                if (i==N-1) {
                    Arrays.sort(arr[j]);
                }
            }
        }
    }

    static void play() {
        answer = 0;

        PriorityQueue<int[]> pq12 = new PriorityQueue<>((a,b)->a[2]-b[2]);
        PriorityQueue<int[]> pq34 = new PriorityQueue<>((a,b)->b[2]-a[2]);
        boolean[][] visited12 = new boolean[N][N];
        boolean[][] visited34 = new boolean[N][N];

        pq12.offer(new int[]{0, 0, arr[0][0]+arr[1][0]});
        pq34.offer(new int[]{N-1, N-1, arr[2][N-1]+arr[3][N-1]});
        visited12[0][0] = true;
        visited34[N-1][N-1] = true;

        while(!pq12.isEmpty() && !pq34.isEmpty()) {
            if (pq12.peek()[2]+pq34.peek()[2] == 0) {
                int a = 0;
                int b = 0;
                
                int k = pq12.peek()[2];
                while(!pq12.isEmpty() && k == pq12.peek()[2]) {
                    add_t(pq12, visited12);
                    a += 1;
                }

                k = pq34.peek()[2];
                while(!pq34.isEmpty() && k == pq34.peek()[2]) {
                    add_b(pq34, visited34);
                    b += 1;
                }
                answer += (long) a*b;
            } else if(pq12.peek()[2]+pq34.peek()[2] > 0) {
                add_b(pq34, visited34);
            } else {
                add_t(pq12, visited12);
            }
        }

    }

    static void add_b(PriorityQueue<int[]> pq, boolean[][] visited) {
        int[] curr = pq.poll();
        if (curr[0]-1 >= 0 && !visited[curr[0]-1][curr[1]]) {
            pq.offer(new int[]{curr[0]-1, curr[1], arr[2][curr[0]-1] + arr[3][curr[1]]});
            visited[curr[0]-1][curr[1]] = true;
        }
        if (curr[1]-1 >= 0 && !visited[curr[0]][curr[1]-1]) {
            pq.offer(new int[]{curr[0], curr[1]-1, arr[2][curr[0]] + arr[3][curr[1]-1]});
            visited[curr[0]][curr[1]-1] = true;
        }
    }

        static void add_t(PriorityQueue<int[]> pq, boolean[][] visited) {
        int[] curr = pq.poll();
        if (curr[0]+1 < N && !visited[curr[0]+1][curr[1]]) {
            pq.offer(new int[]{curr[0]+1, curr[1], arr[0][curr[0]+1] + arr[1][curr[1]]});
            visited[curr[0]+1][curr[1]] = true;
        }
        if (curr[1]+1 < N && !visited[curr[0]][curr[1]+1]) {
            pq.offer(new int[]{curr[0], curr[1]+1, arr[0][curr[0]] + arr[1][curr[1]+1]});
            visited[curr[0]][curr[1]+1] = true;
        }
    }
}