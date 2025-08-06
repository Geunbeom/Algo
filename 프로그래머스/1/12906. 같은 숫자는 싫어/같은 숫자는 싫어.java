import java.util.*;

public class Solution {
    public Integer[] solution(int []arr) {
        ArrayList<Integer> list = new ArrayList<>();
        int k = -1;
        for (int i=0; i<arr.length; i++) {
            if (k != arr[i]) list.add(arr[i]);
            k = arr[i];
        }
        
        return list.toArray(new Integer[list.size()]);
    }
}