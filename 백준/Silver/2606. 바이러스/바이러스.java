
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Main {
    static int N,E;
    static boolean[] visited;
    static ArrayList<Integer>[] graph;
    static int count;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        E = Integer.parseInt(st.nextToken());
        count = 0;

        graph = new ArrayList[N+1];
        for (int i = 1; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }
        visited = new boolean[N+1];

        for (int i = 1; i < E+1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }
        DFS(1);
        System.out.println(count - 1);
    }

    public static void DFS(int N){
        visited[N] = true;
        count++;
        for (int node : graph[N]){
            if (!visited[node]){
                DFS(node);
            }
        }
    }


}
