import java.io.*;
import java.util.*;

class Solution {
    
    static class stageInfo implements Comparable<stageInfo>{
        
        int stage;
        double rate;
        
        stageInfo(int stage, double rate){
            this.stage = stage;
            this.rate = rate;
        }
        
        @Override
        public int compareTo(stageInfo other){
            
            if(this.rate == other.rate){
                return Integer.compare(this.stage,other.stage);
            }
            
            return Double.compare(other.rate,this.rate);
        }
        
    }
    
    
    
    public int[] solution(int N, int[] stages) {
        int[] answer = {};
        
        //스테이지에 도달했으나 아직 클리어하지 못한 플레이어의 수 / 스테이지에 도달한 플레이어 수
        
        ArrayList<stageInfo>  list = new ArrayList<>();
        
        for(int stage = 1; stage <= N; stage++){
            
            int reached = 0;
            int stopped = 0;
            double rate;
            for(int i = 0; i < stages.length; i++){
                if(stages[i] == stage){
                    stopped++;
                }
                if(stages[i] >= stage){
                    reached++;
                }
            }
            if (reached == 0) {
                    rate = 0.0;
                } else {
                    rate = (double) stopped / reached;
                }
            list.add(new stageInfo(stage,rate));            
        }
        Collections.sort(list);
        
        
        
        
        
        
        return list.stream().mapToInt(s -> s.stage).toArray();
    }
}