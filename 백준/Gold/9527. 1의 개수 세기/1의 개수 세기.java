import java.util.*;
import java.io.*;

public class Main {
	
	static long[] arr;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long a = Long.parseLong(st.nextToken()) - (long) 1;
		long b = Long.parseLong(st.nextToken());
		
		int startA = 0;
		int startB = 0;
		
		arr = new long[56];
		arr[0] = 0;
		arr[1] = 1;
		
		for (int i=0; i<56; i++) {
			long c = (long) 1<<i;
			if ((a & c) != 0) startA = Math.max(startA, i);
			if ((b & c) != 0) startB = Math.max(startB, i);
			if (i > 1) {
				arr[i] = (long) ((long) arr[i-1] + arr[i-1] + ((long) 1<<(i-2)));
				if (i > 2) arr[i-1] = arr[i-1] + arr[i-2];
			}
		}
		arr[55] = arr[55] + arr[54];

		System.out.println(cal(startB, b) - cal(startA, a));

	}
    
	static public long cal(int start, long k) {
		long sum = 0;
		long t = 0;
		for (int i=start; i>=0; i--) {
			long c = (long) 1<<i;
			if ((c & k) == 0) {
				continue;
			}
			t += c;
			sum += (arr[i] + (k-t)+1);
		}
		return sum;
	}
}
