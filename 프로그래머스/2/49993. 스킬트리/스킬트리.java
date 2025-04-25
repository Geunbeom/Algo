class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;
        int[] arr = new int[26];
        
        for (int i=0; i<skill.length(); i++) {
            arr[skill.charAt(i)-'A'] = i+1;
        }
        
        for (int i=0; i<skill_trees.length; i++) {
            String curr = skill_trees[i];
            int min = 0;
            boolean check = true;
            for (int j=0; j<curr.length(); j++) {
                int idx = curr.charAt(j)-'A';
                if (arr[idx] == 0) continue;
                if (arr[idx] == min+1) min = arr[idx];
                else {
                    check = false;
                    break;
                }
            }
            if (check) answer += 1;
        }
        
        return answer;
    }
}