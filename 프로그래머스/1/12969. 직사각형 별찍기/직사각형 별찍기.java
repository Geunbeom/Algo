import java.util.*;

class Solution {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        for (int r=0; r<b; r++) {
            for (int c=0; c<a; c++) sb.append("*");
            if (r != b-1) sb.append("\n");
        }
        System.out.print(sb);
    }
}