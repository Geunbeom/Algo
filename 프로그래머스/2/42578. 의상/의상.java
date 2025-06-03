import java.util.*;

class Solution {
    static int answer = 1;
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String[] arr : clothes) {
            map.put(arr[1], map.getOrDefault(arr[1], 1)+1);
        }
        map.forEach((k, v) -> {
            answer *= v;
        });
        return answer-1;
    }
}