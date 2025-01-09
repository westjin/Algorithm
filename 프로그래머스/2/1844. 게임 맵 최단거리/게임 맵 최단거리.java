import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
    static boolean[][] visited;
    public int solution(int[][] maps) {

        int answer = 0;
        visited = new boolean[maps.length][maps[0].length];
        bfs(0,0,maps);
        
        
        answer = maps[maps.length-1][maps[0].length-1];
        if (answer == 1){
            return -1;
        }
        
        
        return answer;
    }
    
    public static void bfs(int i, int j,int[][] maps){
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[] {i,j});
        visited[i][j] = true;
        
        while(!q.isEmpty()){
            int[] now = q.poll();
            
            for(int k = 0; k < 4; k++){
                int x = now[0] + dx[k];
                int y = now[1] + dy[k];
                if(x < maps.length && y < maps[0].length && 
                   x >= 0 && y >=0){
                    if(maps[x][y] != 0 && !visited[x][y]){
                        visited[x][y] = true;
                        maps[x][y] = maps[now[0]][now[1]] + 1;
                        q.add(new int[]{x,y});
                    }
                }
            }   
        }
    }
}