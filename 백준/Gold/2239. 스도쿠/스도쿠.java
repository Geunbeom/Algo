import java.util.*;
import java.io.*;

public class Main {
	
	static HashMap<Integer, boolean[]> map = new HashMap<>();
	static int max = 0;
	static int[][] answer = new int[10][10];
	static ArrayList<Integer> arr = new ArrayList<>();
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for (int i=1; i<=9; i++) {
			String input = br.readLine();
			map.put(i, new boolean[10]);
			
			for (int j=1; j<=9; j++) {
				int curr = input.charAt(j-1) - '0';
				int group = ((i-1)/3+1)+((j-1)/3+1)*10;
				
				if (i == 1) map.put(j*10, new boolean[10]);
				if (map.get(group) == null) map.put(group, new boolean[10]);
				
				if(curr == 0) {
					max = i+j*10;
					arr.add(max);
					continue;
				}
				
				map.get(i)[curr] = true;
				map.get(j*10)[curr] = true;
				map.get(group)[curr] = true;
				answer[i][j] = curr;
			}
		}
		dfs(0);
		for (int r=1; r<=9; r++) {
			for (int c=1; c<=9; c++) {
				System.out.print(answer[r][c]);
			}
			System.out.println();
		}
	}
	
	static public boolean dfs(int index) {
		int r = arr.get(index)%10;
		int c = arr.get(index)/10;
		int g = ((r-1)/3+1) + ((c-1)/3+1)*10;
		if (arr.get(index) == max) {
			for (int i=1; i<=9; i++) {
				if (!map.get(r)[i] && !map.get(c*10)[i] && !map.get(g)[i]) {
					answer[r][c] = i;
					return true;
				}
			}
			return false;
		}
		
		for (int i=1; i<=9; i++) {
			if (map.get(r)[i] || map.get(c*10)[i] || map.get(g)[i]) continue;
			
			map.get(r)[i] = true;
			map.get(c*10)[i] = true;
			map.get(g)[i] = true;
			if (dfs(index+1)) {
				answer[r][c] = i;
				return true;
			}
			map.get(r)[i] = false;
			map.get(c*10)[i] = false;
			map.get(g)[i] = false;
		}
		return false;
	}
}