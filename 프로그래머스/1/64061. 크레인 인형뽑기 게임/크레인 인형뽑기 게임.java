import java.util.*;

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        
        int N = board.length;
        int index = 0;
        Deque<Integer> stack = new ArrayDeque<>();
     
        
        while(index < moves.length){
            int col = moves[index] - 1;        
            for (int i = 0; i < N; i++){
                
                if(board[i][col] != 0){
                    if(!stack.isEmpty() && stack.peek() == board[i][col]){
                        board[i][col] = 0;
                        stack.pop();
                        answer += 2;
                        break;
                    } 
                    stack.push(board[i][col]);
                    board[i][col] = 0;
                    break;
                
                } 
            }
            index++;
            
        }
        
        
        
        
        return answer;
    }
}