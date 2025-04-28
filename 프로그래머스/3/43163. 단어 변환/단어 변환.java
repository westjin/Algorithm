import java.util.*;
class Solution {
    public int solution(String begin, String target, String[] words) {
        int level =  bfs(begin,target,words);
        return level;
    }
    
    public int bfs(String begin, String target, String[] words){
        Queue<String> q = new LinkedList<>();
        boolean[] v = new boolean[words.length]; 
        int level = 0;
        q.add(begin);
        
        while(!q.isEmpty()){
            int size = q.size(); // 이번 레벨에 몇 개 노드 있는지
            for(int s = 0; s < size; s++) {
                String curVertex = q.remove();
                if(curVertex.equals(target)){
                    return level;
                }
                for(int i = 0; i < words.length; i++){
                    if(!v[i] && getDiffCount(curVertex, words[i]) == 1){
                        q.add(words[i]);
                        v[i] = true;
                    }
                }
            }
            level++; // 이 레벨 size개 다 꺼내고 나서 level 1 올린다
        }
        
        return 0;
    }
    
    public int getDiffCount(String word, String target){
        int diffCount = 0;
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) != target.charAt(i)){
                diffCount++;
            }
        }
        return diffCount;
    }
    
}