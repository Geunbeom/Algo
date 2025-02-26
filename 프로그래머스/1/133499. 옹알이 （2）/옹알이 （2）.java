class Solution {
    public int solution(String[] babbling) {
        String[] arr = {"aya", "ye", "woo", "ma"};
        int answer = 0;
        for (String str : babbling) {
            int s=0;
            int e=1;
            int count=0;
            int t = -1;
            while(e <= str.length()) {
                String str2 = str.substring(s, e);
                for (int i=0; i<4; i++) {
                    if (i == t) continue;
                    if (str2.equals(arr[i])) {
                        count += (e-s);
                        s = e;
                        t = i;
                        break;
                    }
                }
                e++;
            }
            if (count == str.length())answer += 1;
        }
        
        
        return answer;
    }
}