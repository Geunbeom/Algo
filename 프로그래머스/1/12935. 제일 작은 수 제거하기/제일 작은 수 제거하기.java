import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr) {
        if (arr.length == 1) return new int[] {-1};
        int[] answer = new int[arr.length-1];
        int min = Arrays.stream(arr).min().getAsInt();
        int idx = 0;
        for (int i:arr)if(i!=min)answer[idx++]=i;
        return answer;
    }
}