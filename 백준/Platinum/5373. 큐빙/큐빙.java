import java.util.*;
import java.io.*;

class Cube {
	HashMap<Character, Face> face = new HashMap<>();
	
	Cube() {
		this.face.put('U', new Face('w'));
		this.face.put('D', new Face('y'));
		this.face.put('F', new Face('r'));
		this.face.put('B', new Face('o'));
		this.face.put('L', new Face('g'));
		this.face.put('R', new Face('b'));
		this.face.forEach((k, v) -> {
			v.setLine(this);
		});
	}
	
	void reset() {
		this.face.forEach((k, v) -> {
			v.reset();
		});
	}
	
}

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
	
	void setLine(Cube cube) {
		Code[] out;
		String[] li;
		switch(this.org) {
			case 'w' :
				li = new String[] {"F1", "R1", "B3", "L1"};
				for (int i=0; i<=9; i+=3) {
					out = cube.face.get(li[i/3].charAt(0))
						.getLine(li[i/3].charAt(1));
					for (int j=0; j<3; j++) {
						line[i+j] = out[j];
					}
				}
				break;
			case 'y' :
				li = new String[] {"B1", "R3", "F3", "L3"};
				for (int i=0; i<=9; i+=3) {
					out = cube.face.get(li[i/3].charAt(0))
						.getLine(li[i/3].charAt(1));
					for (int j=0; j<3; j++) {
						line[i+j] = out[j];
					}
				}
				break;
			case 'r' :
				li = new String[] {"D1", "R4", "U3", "L2"};
				for (int i=0; i<=9; i+=3) {
					out = cube.face.get(li[i/3].charAt(0))
						.getLine(li[i/3].charAt(1));
					for (int j=0; j<3; j++) {
						line[i+j] = out[j];
					}
				}
				break;
			case 'o' :
				li = new String[] {"U1", "R2", "D3", "L4"};
				for (int i=0; i<=9; i+=3) {
					out = cube.face.get(li[i/3].charAt(0))
						.getLine(li[i/3].charAt(1));
					for (int j=0; j<3; j++) {
						line[i+j] = out[j];
					}
				}
				break;
			case 'g' :
				li = new String[] {"D4", "F4", "U4", "B4"};
				for (int i=0; i<=9; i+=3) {
					out = cube.face.get(li[i/3].charAt(0))
						.getLine(li[i/3].charAt(1));
					for (int j=0; j<3; j++) {
						line[i+j] = out[j];
					}
				}
				break;
			case 'b' :
				li = new String[] {"D2", "B2", "U2", "F2"};
				for (int i=0; i<=9; i+=3) {
					out = cube.face.get(li[i/3].charAt(0))
						.getLine(li[i/3].charAt(1));
					for (int j=0; j<3; j++) {
						line[i+j] = out[j];
					}
				}
				break;
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
	
	static Cube cube = new Cube();
	static BufferedReader br;
	static StringBuilder sb = new StringBuilder();;
	
	public static void main(String[] args) throws Exception{
		br = new BufferedReader(new InputStreamReader(System.in));

		int tc = Integer.parseInt(br.readLine());
		while (tc-- > 0) init();
		System.out.print(sb);
	}

	private static void init() throws Exception{
		cube.reset();
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		while (N-->0) {
			String str = st.nextToken();
			cube.face.get(str.charAt(0)).spin(str.charAt(1) == '+' ? true : false);
		}
		sb.append(cube.face.get('U').out());
		
	}
}