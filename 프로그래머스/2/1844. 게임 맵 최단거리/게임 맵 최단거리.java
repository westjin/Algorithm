import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        //BFS로 최단 거리 구하기
        
        //상하좌우 움직임 
        int[] dr = {1,-1,0,0}; 
        int[] dc = {0,0,-1,1};
        
        int n = maps.length;
        int m = maps[0].length;
        
        Queue<int[]> q = new ArrayDeque<>();
        boolean[][] v = new boolean[n][m];
        q.offer(new int[]{0,0,1});
        
        while(!q.isEmpty()){
            //현재 노드 꺼내기
            int[] cur = q.poll();
            int r = cur[0], c = cur[1], dist = cur[2];
            
            //목적지 도달 시 거리 반환
            if(r == n -1 && c == m - 1) return dist;
            //다음 노드 찾기
            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                //다음 노드 유효성 검사
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && maps[nr][nc] == 1){
                    if(!v[nr][nc]){
                        q.offer(new int[]{nr,nc,dist + 1});
                        v[nr][nc] = true;
                    }
                }
                
            }
            
            
            
            
        }
        

        return -1;
    }
}