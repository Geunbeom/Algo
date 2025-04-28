import java.util.*;
import java.io.*;

class Face {
	char org;
	Code[] codes = new Code[9];
	Code[] line = new Code[12];
	
	Face(char color) {
		this.org = color;
		for (int i=0; i<9; i++) codes[i] = new Code(color);
	}
	
	void reset() {
		for (Code c : this.codes) {
			c.color = this.org;
		}
	}
	
	void spin(boolean dir) {
		if (dir) {
			char tmp = codes[0].color;
			codes[0].color = codes[6].color;
			codes[6].color = codes[8].color;
			codes[8].color = codes[2].color;
			codes[2].color = tmp;

			tmp = codes[1].color;
			codes[1].color = codes[3].color;
			codes[3].color = codes[7].color;
			codes[7].color = codes[5].color;
			codes[5].color = tmp;
			
			for (int i=0; i<3; i++) {
				tmp = line[i].color;
				for (int j=0; j<=6; j+=3) line[j+i].color = line[j+i+3].color;
				line[9+i].color = tmp;
			}
			
		}else {
			char tmp = codes[0].color;
			codes[0].color = codes[2].color;
			codes[2].color = codes[8].color;
			codes[8].color = codes[6].color;
			codes[6].color = tmp;

			tmp = codes[1].color;
			codes[1].color = codes[5].color;
			codes[5].color = codes[7].color;
			codes[7].color = codes[3].color;
			codes[3].color = tmp;
			
			for (int i=0; i<3; i++) {
				tmp = line[9+i].color;
				for (int j=9; j>=3; j-=3) line[j+i].color = line[j+i-3].color;
				line[i].color = tmp;
			}
		}
	}
	
	Code[] getLine(char index) {
		Code[] output = new Code[3];
		switch(index) {
			case '1':
				output[0] = codes[0];
				output[1] = codes[1];
				output[2] = codes[2];
				break;
			case '2':
				output[0] = codes[2];
				output[1] = codes[5];
				output[2] = codes[8];
				break;
			case '3':
				output[0] = codes[8];
				output[1] = codes[7];
				output[2] = codes[6];
				break;
			case '4':
				output[0] = codes[6];
				output[1] = codes[3];
				output[2] = codes[0];
				break;
		}
		return output;
	}
	
	void setLine(HashMap<Character, Face> cube) {
		Code[] out;
		char[] li = {};
		switch(this.org) {
		case 'w' :
			li = new char[] {'F', '1', 'R', '1', 'B', '3', 'L', '1'};
			break;
		case 'y' :
			li = new char[] {'B', '1', 'R', '3', 'F', '3', 'L', '3'};
			break;
		case 'r' :
			li = new char[] {'D', '1', 'R', '4', 'U', '3', 'L', '2'};
			break;
		case 'o' :
			li = new char[] {'U', '1', 'R', '2', 'D', '3', 'L', '4'};
			break;
		case 'g' :
			li = new char[] {'D', '4', 'F', '4', 'U', '4', 'B', '4'};
			break;
		case 'b' :
			li = new char[] {'D', '2', 'B', '2', 'U', '2', 'F', '2'};
			break;
		}
		
		for (int i=0; i<=3; i++) {
			out = cube.get(li[i*2]).getLine(li[i*2+1]);
			for (int j=0; j<3; j++) line[i*3+j] = out[j];
		}
	}
	
	String out() {
		String out = "";
		for (int i=0; i<9; i++) {
			out += this.codes[i].color;
			if (i%3==2) out += "\n";
		}
		return out;
	}
}

class Code {
	char color;
	Code(char color) {
		this.color = color;
	}
}

public class Main {
	
	static HashMap<Character, Face> cube = new HashMap<>();
	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();;
	
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));
		cube.put('U', new Face('w'));
		cube.put('D', new Face('y'));
		cube.put('F', new Face('r'));
		cube.put('B', new Face('o'));
		cube.put('L', new Face('g'));
		cube.put('R', new Face('b'));
		cube.forEach((k, v) -> {
			v.setLine(cube);
		});
		
		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) init();
		System.out.print(sb);
	}

	private static void init() throws Exception{
		cube.forEach((k, v) -> v.reset());
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		while (N-->0) {
			String str = st.nextToken();
			cube.get(str.charAt(0)).spin(str.charAt(1) == '+' ? true : false);
		}
		sb.append(cube.get('U').out());
		
	}
}