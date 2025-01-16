import java.util.Stack;

class Solution {
    
    boolean solution(String s) {

        boolean result;
        result = match(s);

        return result ;
    }
    public static boolean match(String str){
        Stack<Character> openStack = new Stack<>();
        final char open = '(', close = ')';

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == open){
                openStack.push(str.charAt(i));
            }else {
                if (openStack.isEmpty()){
                    return false;
                }
                openStack.pop();
            }
        }

        return openStack.isEmpty();
    }
}