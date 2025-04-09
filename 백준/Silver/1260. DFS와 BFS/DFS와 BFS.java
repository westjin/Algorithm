import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {


    static int N, E, V;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            graph[end].add(start);
        }
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }

        DFS(V);
        System.out.println();
        BFS(V);


    }

    public static void DFS(int num) {
        Stack<Integer> stack = new Stack<>();
        stack.push(num);
//        visited[num] = true;

        while (!stack.isEmpty()) {
            int current = stack.pop();

            // 여기서 방문 체크 및 출력
            if (!visited[current]) {
                visited[current] = true;
                System.out.print(current + " ");

                List<Integer> neighbors = graph[current];
                for (int i = neighbors.size() - 1; i >= 0; i--) {
                    int node = neighbors.get(i);
                    if (!visited[node]) {
                        stack.push(node);
                    }
                }
            }
        }
    }

    public static void BFS(int num) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visitedBFS = new boolean[N + 1];  // BFS용 visited 별도 선언

        queue.offer(num);
        visitedBFS[num] = true;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            System.out.print(current + " ");

            for (int neighbor : graph[current]) {
                if (!visitedBFS[neighbor]) {
                    queue.offer(neighbor);
                    visitedBFS[neighbor] = true;
                }
            }
        }
    }
}