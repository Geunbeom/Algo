import java.util.*;
import java.io.*;

class Main {
    static BufferedReader br;
    static int[][] arr;
    static String str1;
    static String str2;
    static String answer;

    static public void main(String[] args) throws Exception {
        input();
        play();
        getAnswer();
        System.out.println(answer.length());
        System.out.println(answer);
    }

    static public void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        str1 = br.readLine();
        str2 = " " + br.readLine();
    }

    static void play() {
        answer = "";
        int l1 = str1.length();
        int l2 = str2.length();
        arr = new int[l1][l1+1];
        for (int i=0; i<l1; i++) {
            Arrays.fill(arr[i], Integer.MAX_VALUE);
        }

        for (int i=0; i<l1; i++) {
            int k = 0;
            char c = str1.charAt(i);

            int index = 0;
            int rm = 1;
            int rM = i==0?l2:(arr[i-1][index] < 0 ? -arr[i-1][index] : arr[i-1][index]);
            for (int j=rm; j<l2;) {
                if (index > i) break;
                if (i > 0 && j == rM) {
                    arr[i][index] = arr[i-1][index] > 0 ? -arr[i-1][index] : arr[i-1][index];
                    index += 1;
                    rm = rM+1;
                    j = rm;
                    rM = i==0?l2:(arr[i-1][index] < 0 ? -arr[i-1][index] : arr[i-1][index]);
                    continue;
                }
                if (c == str2.charAt(j)) {
                    arr[i][index] = j;
                    index += 1;
                    rm = rM != Integer.MAX_VALUE ? rM+1:rM;
                    j = rm;
                    rM = i==0?l2:(arr[i-1][index] < 0 ? -arr[i-1][index] : arr[i-1][index]);
                    continue;
                }
                j++;
            }
        }
    }

    static void getAnswer() {
        int l = str1.length();
        int k = l-1;
        for (int r=l-1; r>=0; r--) {
            for (int c=k; c>=r; c--) {
                if (arr[c][r] == Integer.MAX_VALUE || arr[c][r] < 0) continue;
                k = c-1;
                answer = String.valueOf(str2.charAt(arr[c][r])) + answer;
                break;
            } 
        }
    }
}