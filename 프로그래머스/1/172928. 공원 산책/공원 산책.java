import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] answer = {};
        
        int H = park.length;
        int W = park[0].length();
        
        char[][] map = new char[H][W];
        
        int startX = 0;
        int startY = 0;
        
        //가로 길이가 W 컬럼, 세로 길이가 H 로우 공원의 좌측 상단의 좌표는 (0, 0), 우측 하단의 좌표는 (H - 1, W - 1) 입니다.
        //공원을 나타내는 문자열 배열 park, 로봇 강아지가 수행할 명령이 담긴 문자열 배열 routes가 매개변수로 주어질 때
        // ["SOO","OOO","OOO"]
        
        for(int i = 0; i < H; i++){
            String row = park[i];
            for(int j = 0; j < W; j ++){
                map[i][j] = row.charAt(j);
                if(map[i][j] == 'S'){
                    startX = i;
                    startY = j;
                }       
            }
        }
        
        
        for(int i = 0; i < routes.length; i++){
            StringTokenizer st = new StringTokenizer(routes[i]);
            String focus = st.nextToken();
            int length = Integer.parseInt(st.nextToken());
            int nextY = 0;
            int nextX = 0;
            int tempX = startX;
            int tempY = startY;
            boolean status = true;
            int[] dx = {-1,1,0,0}; // N,S,W,E
            int[] dy = {0,0,-1,1};
            int dir = 0;
            if (focus.equals("N")) dir = 0;
            else if (focus.equals("S")) dir = 1;
            else if (focus.equals("W")) dir = 2;
            else if (focus.equals("E")) dir = 3;
            
            for(int j = 0; j < length; j++){
                nextX = tempX + dx[dir];
                nextY = tempY + dy[dir];
                
                if(nextX < 0 || nextX >= H || nextY < 0 || nextY >= W){
                    status = false;
                    break;
                }
                tempX = nextX;
                tempY = nextY;
                
                if(map[tempX][tempY] == 'X'){
                    status = false;
                    break;
                }
                
            }
            
            if(status){
                    startX = tempX;
                    startY = tempY;
                }
                     
        }
            
        
           
        answer = new int[]{startX,startY}; 
        return answer;
    }
}