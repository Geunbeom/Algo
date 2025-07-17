import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception{
        input();
    }

    public static void input() throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        HashSet<Integer> set = new HashSet<>();
        StringBuilder answer = new StringBuilder();
        while(true) {
            try {
                int A = Integer.parseInt(st.nextToken());
                if (!set.contains(A)) answer.append(A).append(" ");
                set.add(A);
            } catch (Exception e) {
                System.out.println(answer);
                break;
            }
        }
    }

}