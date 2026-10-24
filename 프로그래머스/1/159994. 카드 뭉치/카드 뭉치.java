import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        String answer = "";
        
        Deque<String> q1 = new ArrayDeque<>();
        Deque<String> q2 = new ArrayDeque<>();
        
        
        for(String card : cards1){
            q1.add(card);
        }
        for(String card : cards2){
            q2.add(card);
        }
        
        int num3 = goal.length;
        boolean status = true;
        
        for(int i = 0; i < num3; i++){            
            if(q1.size() > 0 && q1.peek().equals(goal[i])){
                q1.poll();
                continue;
            }
            
            if(q2.size() > 0 &&q2.peek().equals(goal[i])){
                q2.poll();
                continue;
            }
            
            status = false;
        }
        
        if(status){
            answer = "Yes";
        }else answer = "No";
        
        
        
        return answer;
    }
}