import java.util.*;

class Solution {
    public double solution(int[] numbers) {
        double answer = 0;
        double length = numbers.length;
        
        for(int num : numbers){
            
            answer += num;
        }
        
        answer /= length;
        
        return answer;
    }
}