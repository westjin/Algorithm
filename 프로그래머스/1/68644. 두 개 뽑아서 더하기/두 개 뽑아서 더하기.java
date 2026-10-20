import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] numbers) {

        ArrayList<Integer> answer = new ArrayList<>();
        
        
        for(int i = 0; i < numbers.length; i++){
            for(int j = i+1; j < numbers.length; j++){
                answer.add(numbers[i] + numbers[j]);                
            }
        }
        
        Collections.sort(answer);
        
        
        
        return answer.stream().mapToInt(Integer::intValue).distinct().toArray();
    }
}