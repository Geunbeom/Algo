import java.util.*;

class Person {
    int x;
    int y;
    
    Person(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

class Solution {
    
    static ArrayList<Person> people;
    
    public int[] solution(String[][] places) {
        int[] answer = new int[5];
        for (int tc=0; tc<5; tc++) {
            people = new ArrayList<>();
            makeList(places[tc]);
            boolean check = getTrue(places[tc]);
            
            answer[tc] = check ? 1 : 0;
        }
        return answer;
    }
    
    static void makeList(String[] curr) {
        for (int r=0; r<5; r++) {
            for (int c=0; c<5; c++) {
                if (curr[r].charAt(c) == 'P')
                    people.add(new Person(r, c));
            }
        }
    }
    
    static boolean getTrue(String[] curr) {
        for (Person p1 : people) {
            for (Person p2 : people) {
                if (p1 == p2) continue;
                int dis = Math.abs(p1.x-p2.x) + Math.abs(p1.y-p2.y);
                if (dis > 2) continue;
                if (dis == 1) return false;
                
                if (p1.x == p2.x) {
                    if (curr[p1.x].charAt((p1.y+p2.y)/2) == 'O')
                        return false;
                    
                }else if (p1.y == p2.y) {
                    if (curr[(p1.x+p2.x)/2].charAt(p1.y) == 'O')
                        return false;
                    
                }else {
                    if (curr[p1.x].charAt(p2.y) == 'O' ||
                        curr[p2.x].charAt(p1.y) == 'O'
                       ) return false;
                }
                
            }
            
            
        }
        
        return true;
    }
    
}