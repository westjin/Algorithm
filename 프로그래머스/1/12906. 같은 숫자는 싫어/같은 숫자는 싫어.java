import java.util.*;


public class Solution {
    public int[] solution(int []arr) {
        int[] answer = {};
        
        
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        
        Stack<Integer> stack = new Stack<>();
        
        stack.push(arr[0]);
        for(int i = 1; i < arr.length; i++){
            
            int num = stack.peek();
            if(num == arr[i]){
                continue;
            }
            stack.push(arr[i]);
        }
        answer = new int[stack.size()];

        for(int i = stack.size() -1; i >= 0; i--){
            answer[i] = stack.pop();
        }

        return answer;
    }
}