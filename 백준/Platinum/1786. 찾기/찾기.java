import java.util.*;
import java.io.*;

public class Main {

    static String org, code;
    static StringBuilder sb;
    static int count;
    static int[] p;
    static BufferedReader br;
    static StringTokenizer st1, st2;
    public static void main(String[] args) throws Exception{
        input();
        kmp();
        play();
        System.out.println(count);
        System.out.println(sb);
    }

    private static void play() {
        sb = new StringBuilder();
        count = 0;
        int j = 0;
        boolean check;
        for (int i=0; i<org.length(); i++) {
            check = false;
            while (true) {
                if (org.charAt(i) == code.charAt(j)) {
                    check = true;
                    break;
                }
                if (j == 0) break;
                j = p[j-1];
            }

            if (check) {
                if (j == code.length()-1) {
                    sb.append(i-j+1 + " ");
                    count++;
                    j = p[j];
                } else {
                    j++;
                }
            }
        }

    }

    private static void kmp() throws Exception {
        int l = code.length();
        p = new int[l];
        int j = 0;
        boolean check;
        for (int i=1; i<l; i++) {
            check = false;
            while (true) {
                if (code.charAt(i) == code.charAt(j)) {
                    check = true;
                    break;
                }
                if (j == 0) break;
                j = p[j-1];
            }

            if (check) {
                j++;
                p[i] = j;
            }
        }
    }

    private static void input() throws Exception{
        br = new BufferedReader(new InputStreamReader(System.in));
        org = br.readLine();
        code = br.readLine();
        // st1 = new StringTokenizer(br.readLine());
        // st2 = new StringTokenizer(br.readLine());

        // org = new StringBuffer();
        // code = new StringBuffer();
        // boolean check1 = true;
        // boolean check2 = true;
        // while(check1 || check2) {
        //     if (check1) {
        //         try {
        //             org.append(st1.nextToken());
        //         }catch (Exception e) {
        //             check1 = false;
        //         }
        //     }

        //     if (check2) {
        //         try {
        //             code.append(st2.nextToken());
        //         } catch (Exception e) {
        //             check2 = false;
        //         }
        //     }
        // }
    }
}
