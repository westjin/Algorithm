import java.util.*;

class Solution {
    public int solution(String s) {
        String sb = s + s;
        int answer = 0;
        
        //문자열 길이만큼 반복
        for(int i = 0; i < s.length(); i++){
            if(isValid(sb.substring(i,s.length() + i))) answer ++;
        }
        
        return answer;
    }
    
    private boolean isValid(String s){
        Deque<Character> stack = new ArrayDeque<>();
        
        for(char current : s.toCharArray()){
            if(current == '(' || current == '{' || current == '['){
                stack.push(current);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                
                char target = stack.pop();
                if( (target == '(' && current != ')') ||
                    (target == '{' && current != '}') ||
                    (target == '[' && current != ']')){
                        return false;
                }
                
            }
        }
        
        return stack.isEmpty();
        
        
    }
    
    
}