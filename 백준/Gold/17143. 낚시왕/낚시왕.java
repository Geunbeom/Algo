import java.io.*;
import java.util.*;

public class Main {
	
	static int[][] degree = new int[][] {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};
	static int R;
	static int C;
	
	static class Shark {
		int r;
		int c;
		int s;
		int d;
		int z;
		
		public Shark(int r, int c, int s, int d, int z) {
			this.r = r;
			this.c = c;
			this.s = s;
			this.d = d-1;
			this.z = z;
		}
		
		public void move() {
			if (degree[d][0] == 0) {
				c += s*degree[d][1];
				
				if (c < 0) {
					c = turn(c, C);
				}else if(c >= C){
					c = turn(c, C);
				}
			}else {
				r += s*degree[d][0];
				
				if (r < 0) {
					r = turn(r, R);
				}else if(r >= R){
					r = turn(r, R);
				}
			}
		}
		
		int turn(int p, int T) {
			while(p < 0 || p >= T) {
				if (p < 0) {
					p = -p;
					this.d = this.d == 0 ? 1 : 2;
				}
				if (p >= T) {
					p = 2 * T - p - 2;
					this.d = this.d == 1 ? 0 : 3;
				}
			}
			return p;
		}
		
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int answer = 0;
		
		int[][] map = new int[R][C];
		Shark[] sharks = new Shark[M+1];
		
		for (int i=1; i<=M; i++) {
			st = new StringTokenizer(br.readLine());
			int r = Integer.parseInt(st.nextToken())-1;
			int c = Integer.parseInt(st.nextToken())-1;
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			
			sharks[i] = new Shark(r, c, s, d, z);
			map[r][c] = i;
		}
		
		for (int c=0; c<C; c++) {

			for (int r=0; r<R; r++) {
				if(map[r][c] == 0) continue;
				answer += sharks[map[r][c]].z;
				sharks[map[r][c]] = null;
				map[r][c] = 0;
				break;
			}
			
			for (int i=1; i<=M; i++) {
				if (sharks[i] == null) continue;
				
				// 자신의 위치 초기화
				if (map[sharks[i].r][sharks[i].c] == i) map[sharks[i].r][sharks[i].c] = 0;
				
				sharks[i].move();
				
				// 이동 후, 아직 이동 전인 상어라면 덮어쓴다.
				int on = map[sharks[i].r][sharks[i].c];
				
				if (on == 0 || on >= i)
					map[sharks[i].r][sharks[i].c] = i;
				else {
					if (sharks[on].z < sharks[i].z) {
						sharks[on] = null;
						map[sharks[i].r][sharks[i].c] = i;
					}else {
						sharks[i] = null;
					}
				}
			}
			
		}
		
		System.out.println(answer);
	}
	
}