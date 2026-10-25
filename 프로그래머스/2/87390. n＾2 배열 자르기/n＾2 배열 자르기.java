import java.util.*;
class Solution {
    public int[] solution(int n, long left, long right) {
        List<Integer> answer = new ArrayList<>();
        
        
        for(long i = left; i <= right; i++){
            
            long row = i / n;
            long col = i % n;
            
            if(row >= col){
                answer.add((int)row + 1);
            }else{
                answer.add((int)col + 1);
            }
        }
        
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}