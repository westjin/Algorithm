import java.util.*;
class Solution {
    int answer;
    public int solution(int n, int[][] wires) {
        answer = n;
        
        //그래프 만들기
        Map<Integer,List<Integer>> graph = new HashMap<>();
        
        //그래프 초기화
        for(int i = 1; i <= n; i++){
            graph.put(i,new ArrayList<>());
        }
        //그래프 연결
        for(int[] wire : wires){
            graph.get(wire[0]).add(wire[1]);
            graph.get(wire[1]).add(wire[0]);
        }
        boolean[] v = new boolean[n+1];
        
        //dfs 수행
        dfs(graph,v,1,n);
       
        return answer;
    }
    
    public int dfs(Map<Integer, List<Integer>> graph, boolean[] v,int cur, int n){
        //현재 노드 방문
        int count = 1;
        v[cur] = true;
        
        //다음 노드 방문
        for(int next : graph.get(cur)){
            if(!v[next]){
                count += dfs(graph,v,next,n);
            }
        }
        
        //최적값 업데이트
        answer = Math.min(answer,Math.abs(n - count * 2));
        
        
        return count;
        
        
    }
    
}