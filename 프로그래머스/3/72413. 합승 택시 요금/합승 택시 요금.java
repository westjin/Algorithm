import java.util.*;
class Solution {
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        //#✅ 인풋을 본인이 쓰기 편한 구조로 바꾸기(다익스트라) => 무방향 그래프 만들기
        int[][] costs = new int[n+1][n+1];
        for(int[] fare: fares){
            // fare: 길이가 3인 배열로 [출발지, 도착지, 비용] 정보를 담고 있습니다.
            costs[fare[0]][fare[1]] = fare[2];
            costs[fare[1]][fare[0]] = fare[2];
        }

        //#✅ s, a, b 3개의 노드에서 모든 노드까지 도달하는 최소 비용을 저장한다.
        int[][] distArray = new int[3][n+1];
        for( int[] d : distArray) {
            Arrays.fill(d,Integer.MAX_VALUE);
        }
	    
        //  #✅ case1: s, a, b 3개의 노드에서 각각 다익스트라 알고리즘을 수행한다.
        Queue<int[]> pq = new PriorityQueue<>((e1,e2) -> e1[1] - e2[1]);
        final int[] start = { s, a, b };
        for( int j = 0; j < 3; j++){
            //현재 출발점에 대한 거리 배열을 꺼낸다
            int[] d = distArray[j];
            pq.add(new int[]{start[j] , 0});
            d[start[j]] = 0;
            while(!pq.isEmpty()){
                int[] cur = pq.remove(); // 큐에서 가장 비용이 적은 노드를 꺼냄
                for(int i =1; i <= n; i++){
                    //현재 노드와 i번째 노드가 연결되지 않았음
                    if( costs[cur[0]][i] == 0) continue;
                    
                    if( d[i] > cur[1]  + costs[cur[0]][i]){
                        d[i] = cur[1] + costs[cur[0]][i];
                        pq.add(new int[]{ i, cur[1] + costs[cur[0]][i]});
                    }
                }
            }
        }
        //#✅ 모든 노드를 순회하며 cost(s->x) + cost(x->a) + cost(x->b)의 최소비용을 반환한다.
        int minCost = Integer.MAX_VALUE;
        for(int i = 1; i <= n; i++){
            int sum = 0;
            for (int[] d: distArray){
                sum += d[i];
            }
            minCost = Math.min(minCost,sum);
        }
        
        return minCost;
    }
}