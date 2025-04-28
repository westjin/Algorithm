import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        
        List<List<Integer>> graph = new ArrayList<>();
        
        for(int i = 0; i <= n; i++){
            graph.add(i,new ArrayList<>());
        }
        
        for(int[] e : edge){
            int start = e[0];
            int end = e[1];
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        
        int[] distance = bfs(graph,1);
        int maxDistance = 0;
        int count = 0;
        
        for(int dist : distance){
            if(dist > maxDistance){
                maxDistance = dist;
                count = 1;
            }else if(dist == maxDistance){
                count ++;
            }
        }
        
        return count;
    }
    public int[] bfs(List<List<Integer>> graph, int startVertex){
        Queue<Integer> q = new LinkedList<>();
        final int N = graph.size();
        boolean[] v = new boolean[N];
        int[] distance = new int[N]; //노드 별 거리 기록
        
        
        q.add(startVertex);
        v[startVertex] = true;
        distance[startVertex] = 0;  // 시작 노드 거리 0
        
        while(!q.isEmpty()){
            //현재 노드 방문
            int curVertex = q.remove();
            //다음 노드 예약
            for(int nextVertex : graph.get(curVertex)){
                if(!v[nextVertex]){
                q.add(nextVertex);
                v[nextVertex] = true;
                distance[nextVertex] = distance[curVertex] + 1;
                }
            }
        }   
        return distance;
    }
    
    
    
}