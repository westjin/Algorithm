import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i = 0; i < arr.length; i++){
            if(i == 0){
                stack.addLast(arr[i]);     
                continue;
            }else{
                if(stack.peekLast() == arr[i]){
                    continue;
                }
                else{
                    stack.addLast(arr[i]);
                }
            }
            
        }
        
        
        
        

        return stack.stream().mapToInt(Integer::intValue).toArray();
    }
}