import java.util.*;
import java.io.*;


public class Main {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		
		long answer = 0;
		int index = 0;
		int[] arr = new int[3];
		for (int i=0; i<N; i++) {
			int c = Integer.parseInt(st.nextToken());
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
		
		System.out.println(answer);
		
	}

	static long getAnswer(int[] arr, int index, long answer) {
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
	
	static int getIndex(int[] arr) {
		if(arr[1] != 0) return 2;
		else if(arr[0] != 0) return 1;
		return 0;
	}
	
	static int getFinal(int[] arr) {
		int out = 0;
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
	
	static int erase1(int[] arr) {
		int out = arr[0];
		arr[0] = 0;
		return out*3;
	}
	
	static int erase2(int[] arr) {
		int out = Math.min(arr[0], arr[1] > arr[2] ? (arr[1] - arr[2]) : arr[1]);
		arr[0] -= out;
		arr[1] -= out;
		return out*5;
	}
	
	static int erase3(int[] arr) {
		int out = Math.min(arr[0], Math.min(arr[1], arr[2]));
		arr[0] -= out;
		arr[1] -= out;
		arr[2] -= out;
		return out*7;
	}
}