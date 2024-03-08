import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws Exception{
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		if (N < 3) {
			sb.append(2+"\n");
			N = 3;
		}
		
		if (N%2 == 1) {
			for (int i=N; i<=M; i+=2) {
				boolean check = true;
				for (int j=3; j<=Math.sqrt(i); j+=2) {
					if (i % j == 0) {
						check = false;
						break;
					}
				}
				if (check) sb.append(i+"\n");
			}
		}else {
			N+=1;
			for (int i=N; i<=M; i+=2) {
				boolean check = true;
				for (int j=3; j<=Math.sqrt(i); j+=2) {
					if (i % j == 0) {
						check = false;
						break;
					}
				}
				if (check) sb.append(i+"\n");
			}
		}
		
		System.out.println(sb);
	
		
	}
	
}
