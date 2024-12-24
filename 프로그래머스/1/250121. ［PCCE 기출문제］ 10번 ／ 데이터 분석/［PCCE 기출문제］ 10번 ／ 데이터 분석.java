import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int k = 0;
        ArrayList<int[]> list = new ArrayList<>();
        PriorityQueue<int[]> pq;
        
        switch (ext) {
            case "code" :
                k = 0;
                break;
            case "date" :
                k = 1;
                break;
            case "maximum" :
                k = 2;
                break;
            case "remain" :
                k = 3;
                break;
        }
        for (int i=0; i<data.length; i++) {
            if (data[i][k] < val_ext) {
                list.add(data[i]);
            }
        }
        
        switch (sort_by) {
            case "code" :
                k = 0;
                break;
            case "date" :
                k = 1;
                break;
            case "maximum" :
                k = 2;
                break;
            case "remain" :
                k = 3;
                break;
        }
        final int t = k;
        pq = new PriorityQueue<>((a, b) -> {
            return (a[t] - b[t]);
        });
        
        for (int i=0; i<list.size(); i++) {
            pq.offer(list.get(i));
        }
        
        int[][] answer = new int[pq.size()][4];
        int idx = 0;
        while(!pq.isEmpty()) {
            answer[idx++] = pq.poll();
        }
        
        return answer;
    }
}