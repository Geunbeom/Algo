class Solution {
    
    static int N, M;
    
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        N = rows;
        M = columns;
        int[] arr = new int[N*M];
        for (int i=0;i<arr.length;i++)arr[i]=i+1;
        
        for (int i=0; i<queries.length; i++) {
            answer[i] = getStart(queries[i], arr);
        }
        
        return answer;
    }
    
    static int getStart(int[] curr, int[] arr) {
        int min = 10001;
        
        curr[0] -= 1;
        curr[1] -= 1;
        curr[2] -= 1;
        curr[3] -= 1;
        
        int prev = arr[M*curr[0]+curr[1]];
        int next = 0;
        
        for (int k=M*curr[0]+curr[1]; k<=M*curr[0]+curr[3]; k++) {
            min = Math.min(min, arr[k]);
            next = arr[k];
            arr[k] = prev;
            prev = next;
        }
        
        for (int k=M*curr[0]+curr[3]+M; k<=M*curr[2]+curr[3]; k+=M) {
            min = Math.min(min, arr[k]);
            next = arr[k];
            arr[k] = prev;
            prev = next;
        }
        
        for (int k=M*curr[2]+curr[3]-1; k>=M*curr[2]+curr[1]; k--) {
            min = Math.min(min, arr[k]);
            next = arr[k];
            arr[k] = prev;
            prev = next;
        }
        
        for (int k=M*curr[2]+curr[1]-M; k>=M*curr[0]+curr[1]; k-=M) {
            min = Math.min(min, arr[k]);
            next = arr[k];
            arr[k] = prev;
            prev = next;
        }

        return min;
    }
    
}