import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        int level = bfs(begin,target,words);
        return level;
    }
    
    
    public int bfs(String begin, String target, String[] words){
        Queue<String> q = new ArrayDeque<>();
        boolean[] v = new boolean[words.length];
        //level 별 분린하기
        int level = 0;
        q.add(begin);
        
        while(!q.isEmpty()){
            //이번 레벨에 큐가 몇 개 있는지 확인
            int size = q.size();
            for(int s = 0; s < size; s++){
                //현재 노드 꺼내기
                String curVertex = q.poll();
                //이번 레벨에 정답이 있는지
                if(curVertex.equals(target)){
                    return level;
                }
                //다음 노드 예약하기
                for(int i =0; i < words.length; i++){
                    //방문하지 않았고, 차이가 1이라면
                    if(!v[i] && getDiffCount(curVertex,words[i]) == 1){
                        q.add(words[i]);
                        v[i] = true;
                    }
                }
            }
            //이번 레벨 체크 완료 다음 레벨로
            level ++;     
        }
     return 0;   
    }
    
    public int getDiffCount(String word, String target){
        int diffCount = 0;
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) != target.charAt(i)){
                diffCount ++;
            }
        }
        
        return diffCount;
        
    }
}