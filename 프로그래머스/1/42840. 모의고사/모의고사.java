import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] answers) {
        ArrayList<Integer> answer = new ArrayList<>();
        
        int[] pattern1 = {1,2,3,4,5};
        int[] pattern2 = {2,1,2,3,2,4,2,5};
        int[] pattern3 = {3,3,1,1,2,2,4,4,5,5};
        
        int[] count = new int[3];
        
        for(int i = 0; i < answers.length; i++){
            
            int index1 = i % pattern1.length;
            int index2 = i % pattern2.length;
            int index3 = i % pattern3.length;
            
            if(pattern1[index1] == answers[i]){
                count[0]++;
            }
            if(pattern2[index2] == answers[i]){
                count[1]++;
            }
            if(pattern3[index3] == answers[i]){
                count[2]++;
            }
        }
        
        int max = Arrays.stream(count).max().getAsInt();
        
        for(int i = 0; i < count.length; i++){
            if(count[i] == max){
                answer.add(i+1);            
            }
            
        }
        
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}