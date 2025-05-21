import java.util.*;

class Solution {
    public long solution(long n) {
        char[] arr = Long.toString(n).toCharArray();
        Arrays.sort(arr);
        String str = "";
        for (int i=arr.length-1; i>=0; i--) str += arr[i];
        return Long.parseLong(str);
    }
}