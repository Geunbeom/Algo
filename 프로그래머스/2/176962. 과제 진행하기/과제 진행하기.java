import java.util.*;
import java.io.*;

class plan {
    String name;
    int time;
    int remain;
    
    plan(String name, int time, int remain) {
        this.name = name;
        this.time = time;
        this.remain = remain;
    }
    
}


class Solution {
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        PriorityQueue<plan> start = new PriorityQueue<>((a, b) -> {
            return a.time - b.time;
        });
        PriorityQueue<plan> doing = new PriorityQueue<>((a, b) -> {
            return b.time - a.time;
        });
        
        for (int i=0; i<plans.length; i++) {
            start.offer(new plan(
                plans[i][0],
                Integer.parseInt(plans[i][1].substring(0, 2))*60
                    + Integer.parseInt(plans[i][1].substring(3, 5)),
                Integer.parseInt(plans[i][2])
            ));
        }
        int index = 0;
        while(!start.isEmpty() || !doing.isEmpty()) {
            if (start.isEmpty()) answer[index++] = doing.poll().name;
            else {
                plan curr = start.poll();
                if (start.isEmpty())
                    answer[index++] = curr.name;
                else {
                    int currTime = curr.time;
                    int nextTime = start.peek().time;
                    if (currTime+curr.remain <= nextTime) {
                        answer[index++] = curr.name;
                        currTime += curr.remain;
                    } else {
                        curr.remain -= (nextTime - currTime);
                        doing.offer(curr);
                        currTime = nextTime;
                    }
                    while (!doing.isEmpty() && currTime != nextTime) {
                        if (currTime+doing.peek().remain <= nextTime) {
                            currTime += doing.peek().remain;
                            answer[index++] = doing.poll().name;
                        }else {
                            doing.peek().remain -= (nextTime-currTime);
                            currTime = nextTime;
                        }
                    }
                }
            }
        }
        return answer;
    }
}