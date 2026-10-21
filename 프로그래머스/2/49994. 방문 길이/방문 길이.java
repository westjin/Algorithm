import java.util.*;

class Solution {
    public int solution(String dirs) {
        int count = 0;
        
        
        
        
        
        boolean[][][] visited = new boolean[11][11][4];
        
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};
        
        int[] reverse = {1,0,3,2};
        int cx = 5;
        int cy = 5;
        int nx;
        int ny;
        
        for(int i = 0; i < dirs.length(); i++){
            char dir = dirs.charAt(i);
            int move;
            
            if(dir == 'U'){
                move = 0;
                nx = cx + dx[0];
                ny = cy + dy[0];
            } else if(dir == 'D'){
                move = 1;
                nx = cx + dx[1];
                ny = cy + dy[1];
            } else if(dir == 'L'){
                move = 2;
                nx = cx + dx[2];
                ny = cy + dy[2];
            }else{
                move = 3;
                nx = cx + dx[3];
                ny = cy + dy[3];
            }
            
            if(nx >= 0 && nx < 11 && ny >=0 && ny < 11){
               
                
                if(!visited[cx][cy][move]){
                
                    count++;
                    visited[cx][cy][move] = true;
                    visited[nx][ny][reverse[move]] = true;
                }
                
                cx = nx;
                cy = ny;
                
            }
                
        }
        
        
        return count;
    }
}