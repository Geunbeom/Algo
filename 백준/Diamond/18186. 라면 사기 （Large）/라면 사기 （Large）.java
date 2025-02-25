import java.util.*;
import java.io.*;


public class Main {
	
	static long A;
	static long B;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		A = Long.parseLong(st.nextToken());
		B = Long.parseLong(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		long answer = 0;
		int index = 0;
		long[] arr = new long[3];
		if (A > B) {
			for (int i=0; i<N; i++) {
				long c = Long.parseLong(st.nextToken());
				if (c == 0) {
					answer = getAnswer(arr, index, answer);
					index = getIndex(arr);
					continue;
				}
				arr[index++] = c;
				if (index == 3) {
					answer = getAnswer(arr, index, answer);
					index = getIndex(arr);
				}
			}
			if (index != 0) answer += getFinal(arr);
		}else {
			for (int i=0; i<N; i++) {
				long c = Long.parseLong(st.nextToken());
				if (c != 0) answer += A*c;
			}
		}
		
		System.out.println(answer);
		
	}

	static long getAnswer(long[] arr, int index, long answer) {
		if (index == 0) return answer;
		else if(index == 1) answer += erase1(arr);
		else if (index == 2) answer += (erase2(arr) + erase1(arr));
		else if (index == 3) {
			if (arr[1] > arr[0] && arr[1] > arr[2]) {
				answer += erase2(arr);
			}
			answer += (erase3(arr) + erase2(arr) + erase1(arr));
			while(arr[0] == 0 && index > 0) {
				arr[0] = arr[1];
				arr[1] = arr[2];
				arr[2] = 0;
				index--;
			}
		}
		
		return answer;
	}
	
	static int getIndex(long[] arr) {
		if(arr[1] != 0) return 2;
		else if(arr[0] != 0) return 1;
		return 0;
	}
	
	static long getFinal(long[] arr) {
		long out = 0;
		out += erase3(arr);
		if (arr[0] == 0) {
			arr[0] = arr[1];
			arr[1] = arr[2];
			arr[2] = 0;
		}
		
		out += erase2(arr);
		if (arr[0] == 0) {
			arr[0] = arr[1];
			arr[1] = 0;
		}
		out += erase1(arr);
		
		return out;
	}
	
	static long erase1(long[] arr) {
		long out = arr[0];
		arr[0] = 0;
		return out*A;
	}
	
	static long erase2(long[] arr) {
		long out = Math.min(arr[0], arr[1] > arr[2] ? (arr[1] - arr[2]) : arr[1]);
		arr[0] -= out;
		arr[1] -= out;
		return out*(A+B);
	}
	
	static long erase3(long[] arr) {
		long out = Math.min(arr[0], Math.min(arr[1], arr[2]));
		arr[0] -= out;
		arr[1] -= out;
		arr[2] -= out;
		return out*(A+B+B);
	}
}