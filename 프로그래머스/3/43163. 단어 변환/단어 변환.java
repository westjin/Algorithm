import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {

        int level = bfs(begin,target,words);
        return level;
    }
    
    public int bfs(String begin, String target, String[] words){
        Queue<String> q = new ArrayDeque<>();
        boolean[] v = new boolean[words.length];
        int level = 0;
        q.add(begin);
        
        while(!q.isEmpty()){
            int size = q.size(); //이번 레벨에 존재하는 노드의 개수
            for(int i = 0; i < size; i++){
                String curVertex = q.poll(); //현재 노드 꺼내기
                if(curVertex.equals(target)){
                    return level;
                }
            
            for(int j = 0; j < words.length; j++){
                if(!v[j] && getDiffCount(curVertex,words[j]) == 1){
                    v[j] = true;
                    q.add(words[j]);
                }
            }
        }
            level ++;
    }
    return 0;
}

    
    public int getDiffCount(String word, String target ){
        int diffCount = 0;
        for (int i = 0; i < word.length(); i++){
            if(word.charAt(i) != target.charAt(i)){
                diffCount ++;
            }
        }
        
        return diffCount;
    }
    
    
    
}