class Solution {
    public int[] solution(int[] sequence, int k) {
        
        int[] answer = {0, sequence.length};
        int[] arr = new int[sequence.length+1];
        
        arr[0] = 0;
        for (int i=1; i<arr.length; i++) {
            arr[i] = arr[i-1] + sequence[i-1];
        }
        
        out : for (int i=0, j=1; i<arr.length; i++) {
            while(i < j && j < arr.length) {
                int t = arr[j] - arr[i];
                if (t < k) {
                    j++;
                }else if(t == k) {
                    if (answer[1]-answer[0] > j-i-1) {
                        answer[0] = i;
                        answer[1] = j-1;
                    }
                    break;
                }else {
                    break;
                }
            }
        }
        
        return answer;
    }
}