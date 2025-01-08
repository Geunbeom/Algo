import java.util.*;
import java.io.*;

public class Main {
	
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int[] answer = new int[N];
		HashMap<Integer, Integer> map = new HashMap<>();
		
		st = new StringTokenizer(br.readLine());
		for (int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			map.put(arr[i], i);
		}
		
		for (int i=0; i<N; i++) {
			for (int j=1; j<=Math.sqrt(arr[i]); j++) {
				if (arr[i] % j != 0) continue;
				if (map.get(j) != null) {
					answer[i]--;
					answer[map.get(j)]++;			
				} if ((j != arr[i]/j) && map.get(arr[i]/j) != null) {
					if (j != 1) {
						answer[i]--;
						answer[map.get(arr[i]/j)]++;							
					}
				}
			}
		}
		
		for (int i=0; i<N; i++) {
			System.out.print(answer[i] + " ");
		}
	}
}
