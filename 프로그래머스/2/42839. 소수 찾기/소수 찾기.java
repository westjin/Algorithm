import java.util.*;

class Solution {
    static Set<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        int answer = 0;
        char[] digits = numbers.toCharArray();
        boolean[] visited = new boolean[numbers.length()];
        backtrack("",digits,visited);
        for(int num : set){
            if(isPrime(num)){
                answer ++;
            }
        }
        
        return answer;
    }
    public void backtrack(String curr, char[] digits,boolean[] visited){
        
        // 1. 지금까지 만든 문자열이 비어있지 않다면 → 숫자로 바꿔보기
        if(!curr.equals("")){
            int num = Integer.parseInt(curr);
            // 여기서 소수 판별해서 set에 넣든지,
            // 아니면 일단 set에 넣고 나중에 한꺼번에 isPrime 돌리든지 (둘 다 가능)
            set.add(num);
        }
        
        //2. 
        for(int i = 0; i < digits.length; i ++){
            if(!visited[i]){
                visited[i] = true;
                backtrack(curr + digits[i], digits, visited);
                visited[i] = false;
            }
        }
        
        
        
    }
    
    public boolean isPrime(int n){
        if(n < 2){
            return false;
        }
        for(int i = 2; i*i <= n; i++){
            if(n % i == 0){
                return false;
            }
        }
        return true;
    }
    
    
    
}