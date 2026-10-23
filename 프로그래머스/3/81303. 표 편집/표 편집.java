import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        
        //표의 행 개수 : n 
        // 선택된 행의 위치 : k
        // 삭제
        //복구
        Stack<Integer> deleted = new Stack<>();
        
        int[] up = new int[n+2];
        int[] down = new int[n+2];
        
        for(int i = 0; i < n + 2; i++){
            up[i] = i - 1;
            down[i] = i + 1;
        }
        
        k++;  
        
        for (String c : cmd){
            
            if(c.startsWith("C")) {
                
                deleted.push(k);
                up[down[k]] = up[k];
                down[up[k]] = down[k];
                
                k = n < down[k] ? up[k] : down[k];
            }
            
            else if (c.startsWith("Z")) {
                
                int restore = deleted.pop();
                down[up[restore]] = restore;
                up[down[restore]] = restore;
            }
            
            else{
                String[] s = c.split(" ");
                int x = Integer.parseInt(s[1]);
                for(int i = 0; i < x; i++){
                    k = s[0].equals("U") ? up[k] : down[k];
                }
            }
        }
        
        
        // 삭제된 행의 위치에 X
        char[] answer = new char[n];
        Arrays.fill(answer, 'O');
        
        for(int i : deleted){
            answer[i-1] = 'X';
        }
        
        
        return new String(answer);
        
        
        
        
        
        
    }
}