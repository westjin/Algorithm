import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    static long[] distance; // 시작 정점으로부터 도착 노드까지의 거리
    static int[][] graph; // 간선 정보를 저장하는 2차원 배열 [시작,끝,가중치]
    static int n;//정점의 수
    static int m;//간선의 수
    static final int INF = 2000000000;



    /**
     * 벨만-포드 알고리즘을 사용하여 최단 경로를 찾는 함수
     * @param start 시작 정점
     * @return 음수 사이클이 있으면 true, 없으면 false
     */
    public static boolean bellmanFord(int start){
        Arrays.fill(distance,INF); // 모든 정점의 최단거리를 무한대로 초기화
        distance[start] = 0;

        // 모든 간선에 대해 (정점 수 - 1)번 반복하여 최단 거리 값을 갱신
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < m; j++) {
                // 간선의 시작 정점이 방문된 정점인 경우에만 갱신
                if (distance[graph[j][0]] != INF){
                    // 기존의 최단 거리 값과 새로운 경로를 통한 거리 값을 비교하여 더 작은 값으로 갱신
                    distance[graph[j][1]] = Math.min(distance[graph[j][1]], // 기존에 알고 있던 해당 위치까지의 거리
                        distance[graph[j][0]] + graph[j][2] ); // 시작 노드를 거쳐 가중치를 더한 거리
                }
                
                //graph[j][0] = 출발 노드
                //graph[j][1] = 도착 노드
                //graph[j][2] = 출발 → 도착으로 가는 거리(가중치)
                //ex) distance[1]: 시작점에서 1번 노드까지 거리
                //+5: 1번에서 3번으로 가는 거리
                //= 시작점 → 1번 → 3번 전체 거리
            }
        }
        
        // 음수 사이클 체크
        boolean isCycle = false;
        for (int i = 0; i < m; i++) {
            if (distance[graph[i][0]] != INF && distance[graph[i][1]] > distance[graph[i][0]] + graph[i][2]){
                isCycle = true;
                break;
            }
        }
        return isCycle;
    }
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        n = Integer.parseInt(stringTokenizer.nextToken());
        m = Integer.parseInt(stringTokenizer.nextToken());
        
        graph = new int[m][3]; // 간선 정보 저장할 배열 초기화
        distance = new long[n+1];
        
        for (int i = 0; i < m; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            graph[i][0] = Integer.parseInt(stringTokenizer.nextToken());
            graph[i][1] = Integer.parseInt(stringTokenizer.nextToken());
            graph[i][2] = Integer.parseInt(stringTokenizer.nextToken());
        }
        StringBuilder stringBuilder = new StringBuilder();
        
        if (bellmanFord(1)){
            stringBuilder.append(-1);
        }else { //음수 사이클 없는 경우
            // N-1개 줄에 걸쳐 각 줄에 1번 도시에서 출발해 2번 도시, 3번 도시, ..., N번 도시로 가는 가장 빠른 시간을 순서대로 출력
            for (int i = 2; i <= n; i++) {
                long result = distance[i] == INF ? -1 : distance[i];
                stringBuilder.append(result).append("\n");
            }
        }

        System.out.println(stringBuilder);
    }

}
