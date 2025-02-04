import java.util.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
      int[] answer = new int[commands.length]; 
        
        for (int i = 0; i < commands.length; i++) {
            int start = commands[i][0] - 1; 
            int end = commands[i][1]; // Java의 copyOfRange는 end 포함 X
            int index = commands[i][2] - 1; 

            int[] subArray = Arrays.copyOfRange(array, start, end);
            Arrays.sort(subArray);


            answer[i] = subArray[index];
        }
        
        return answer;
    }
}