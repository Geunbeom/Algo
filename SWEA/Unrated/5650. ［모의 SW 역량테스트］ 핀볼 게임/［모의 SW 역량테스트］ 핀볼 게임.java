import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

class Direction{
	Direction next;
	Direction pre;
	Direction mirror;
	int currDir;
	
	Direction(){}
	Direction(int currDir) {
		this.currDir = currDir;
	}

}

class Ball {
	// dir 은 방향, 1, 2, 3, 4 순으로 상우하좌
	Direction ballDir;
	int count;
	
	public void wall(int i) {
		if (i == 5) {
			this.ballDir = this.ballDir.mirror;
			return;
		}
		
		i +=1;
		if (i > 3) i -= 4;
		
		if (i == this.ballDir.currDir) {
			this.ballDir = this.ballDir.pre;
			return;
		}
		
		i += 1;
		if (i > 3) i -= 4;
		
		if (i == this.ballDir.currDir) {
			this.ballDir = this.ballDir.next;
			return;
		}
		
		this.ballDir = this.ballDir.mirror;
//		1 : 2->1 or 3->0
//		2 : 3->2 or 0->1
//		3 : 0->3 or 1->2
//		4 : 1->0 or 2->3	
	}
}

public class Solution {
	
	static int[][] arr;
	static int[] dr = {-1, 0, 1, 0}, dc = {0, 1, 0, -1};
	static int N;
	static int[][] worm;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		Direction up = new Direction(0);
		Direction right = new Direction(1);
		Direction down = new Direction(2);
		Direction left = new Direction(3);
		
		up.next = right;
		up.pre = left;
		up.mirror = down;

		right.next = down;
		right.pre = up;
		right.mirror = left;

		down.next = left;
		down.pre = right;
		down.mirror = up;

		left.next = up;
		left.pre = down;
		left.mirror = right;
		
		int T = Integer.parseInt(st.nextToken());
		for (int tc=1; tc<=T; tc++) {
			sb.append("#").append(tc).append(" ");
			
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			arr = new int[N][N];
			worm = new int[5][4];
			
            for (int i=0; i<5; i++) {
            	Arrays.fill(worm[i], -1);
            }
			
			for (int r=0; r<N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c=0; c<N; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
					if (arr[r][c] > 5 && arr[r][c] <= 10) {
						if (worm[arr[r][c]-6][0] == -1) {
							worm[arr[r][c]-6][0] = r;
							worm[arr[r][c]-6][1] = c;							
						}else {
							worm[arr[r][c]-6][2] = r;
							worm[arr[r][c]-6][3] = c;
						}
					}
				}
			}
			Ball ball = new Ball();	
			int ans = 0;
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					if(arr[r][c] == 0) {
						ball.ballDir = up;
						ball.count = 0;
						ballGame(r, c, ball);
						ans = Math.max(ans, ball.count);
						arr[r][c] = 0;
						
						ball.ballDir = right;
						ball.count = 0;
						ballGame(r, c, ball);
						ans = Math.max(ans, ball.count);
						arr[r][c] = 0;
						
						ball.ballDir = down;
						ball.count = 0;
						ballGame(r, c, ball);
						ans = Math.max(ans, ball.count);
						arr[r][c] = 0;
						
						ball.ballDir = left;
						ball.count = 0;
						ballGame(r, c, ball);
						ans = Math.max(ans, ball.count);
						arr[r][c] = 0;
					}
				}
			}
			sb.append(ans);
			sb.append("\n");

		}
		bw.write(sb+"");
		bw.flush();
		bw.close();
	}
	static int ballGame(int r, int c, Ball ball) {
		arr[r][c] = 100;
		int R = r;
		int C = c;
		while (true) {
			int dir = ball.ballDir.currDir;
			r += dr[dir];
			c += dc[dir];
			
			if (r < 0 || c < 0 || r >= N || c >= N) {
				ball.count++;
				ball.wall(5);
				continue;
			}
			
			if (arr[r][c] == -1 || arr[r][c] == 100) {
				return ball.count;
			}
			
				
			if (arr[r][c] > 0 && arr[r][c] <= 5) {
				ball.count++;
				ball.wall(arr[r][c]);
				continue;
			}
			
			if (arr[r][c] > 5 && arr[r][c] <= 10) {
				int[] map = wormHall(r, c, arr[r][c]-6);
				r = map[0]; c = map[1];
				continue;
			}
		}
	}
	
	static int[] wormHall(int r, int c, int k) {
		int[] map = new int[2];
		if (worm[k][0] == r && worm[k][1] == c) {
			map[0] = worm[k][2];
			map[1] = worm[k][3];
		}else {
			map[0] = worm[k][0];
			map[1] = worm[k][1];
		}
		return map;
	}
	
	
}
