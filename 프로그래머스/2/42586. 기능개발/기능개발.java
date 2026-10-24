import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        
        Deque<Integer> q = new ArrayDeque<>();
        Deque<Integer> speed = new ArrayDeque<>();
        int day = 0;
        
        
        for(int i = 0; i < progresses.length; i++){
            q.add(progresses[i]);
            speed.add(speeds[i]);
        }
        
        //큐에 기능이 남아 있으면 맨 앞을 확인한다.  
        //100 이상이면 배포하고 계속 검사한다.
        //100 미만이면 break로 배포 검사를 끝낸다.
        
        while(!q.isEmpty()){
            int count = 0;
            day++;
            
            // 개발 진도 나가기
            for(int i = 0; i < q.size(); i++){
                int num = q.poll();
                int s = speed.poll();
                num += s;
                q.add(num);
                speed.add(s);
            }
            
            //배포 검사
            boolean status = false;
            while(true){
                
                
                if (q.isEmpty()) {
                        break;
                    }
                
                if (q.peek() >= 100) {
                    count++;
                    q.poll();
                    speed.poll();
                    status = true;
            }else{
                    break;
                }
                
                
                
            }
            if(status){
                answer.add(count);    
            }
            
            
            
            
        }
        
        
        
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}