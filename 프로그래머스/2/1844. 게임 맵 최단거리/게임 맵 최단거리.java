import java.util.*;
class Solution {
    public int solution(int[][] maps) {
        //상하좌우
        int[] dr = {1,-1,0,0};
        int[] dc = {0,0,-1,1};
        
        int n = maps.length;
        int m = maps[0].length; 
        
        boolean[][] v = new boolean[n][m];
        Queue<int[]> q = new ArrayDeque<>();
        
        //큐에 시작점 넣기
        q.offer(new int[] {0,0,1});
        v[0][0] = true;
        
        while(!q.isEmpty()){
            int cur[] = q.poll();
            int r = cur[0], c = cur[1], dist = cur[2];
            
            //도착지 도착이라면 dist return
            if(r == n-1 && c == m-1) return dist;
            
            //다음 노드 예약 ( 현재 위치로부터 이동)
            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && maps[nr][nc] == 1){
                    //방문 여부 확인하기
                    if(!v[nr][nc]){
                    q.offer(new int[] {nr,nc,dist+1});
                    v[nr][nc] = true;
                    }
                }
            }
            
        }
        
        return -1;
    }
}