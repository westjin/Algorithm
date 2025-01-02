import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> q = new LinkedList<>();
        List<Integer> answerList = new ArrayList<>();
        
        //각각의 배포 날짜 계산
        for(int i = 0; i < speeds.length; i++){
            double remain = (100 - progresses[i]) / (double) speeds[i];
            int days = (int)Math.ceil(remain);
            
            if(!q.isEmpty() && q.peek() < days){
                answerList.add(q.size()); // 자동으로 다음 인덱스로 넘어간다
                q.clear();
            }
            
            q.offer(days);
        }
        answerList.add(q.size());
        
        int[] answer = new int [answerList.size()];


        
        for(int i = 0; i < answer.length; i++){
            answer[i] = answerList.get(i);
        }

        return answer;
    }
    
}