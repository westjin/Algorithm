import java.io.*;
import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        
        
        // 업,다운 배열을 만든다 현재 행에 대한 위, 아래 정보를 담자
        int[] up = new int[n+2];
        int[] down = new int[n+2];
        
        //삭제된 배열들을 담을 스택
        Deque<Integer> delete = new ArrayDeque<>();
        
        //현재 위치에 대한 값들 연결
        
        for(int i = 0; i < n+2; i++){
            up[i] = i - 1;
            down[i] = i + 1;
        }
        
        k++; // 위 아래로 행이 하나씩 늘어났음
        
        
        for(String c : cmd){
            // 1. 삭제하는 경우
            if(c.equals("C")){
                delete.push(k);
                up[down[k]] = up[k];
                down[up[k]] = down[k];
                
                 if(down[k] > n){
                     k = up[k];
                 }else{
                     k = down[k];
                 }
            }
            
            //되돌리는 경우
            else if(c.equals("Z")){
                int restore = delete.pop();
                
                up[down[restore]] = restore;
                down[up[restore]] = restore;
                
            }
            
            else{
                StringTokenizer st = new StringTokenizer(c);
                String move = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                
                for(int i = 0; i < num; i++){

                if (move.equals("U")){
                    k = up[k];
                }else{
                    k = down[k];
                }   
                    
                }
            }
            
        }

        
        char[] answer = new char[n];
            
            Arrays.fill(answer,'O');
            
            for(int number : delete){
                answer[number - 1] = 'X';
            }
        
        return new String(answer);
        
    }
        

}