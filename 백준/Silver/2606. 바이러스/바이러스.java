import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    static int N,E,count;
    static boolean[] v;
    static ArrayList<Integer>[] graph;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        graph = new ArrayList[N+1];
        v = new boolean[N+1];

        for (int i = 1; i < N+1; i++) {
            graph[i] = new ArrayList<>();
        }

        st = new StringTokenizer(br.readLine());
        E = Integer.parseInt(st.nextToken());



        for (int i = 1; i < E+1; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            graph[start].add(end);
            graph[end].add(start);
        }
        DFS(1);
        System.out.println(count);

    }

    public static void DFS(int N){
        Stack<Integer> stack = new Stack<>();
        stack.push(N);
        v[N] = true;

        while (!stack.isEmpty()){
            int current = stack.pop();
            for (int node : graph[current]) {
                if(!v[node]) {
                    stack.push(node);//연결된 노드
                    v[node] = true;
                    count ++;
                }
            }
        }




    }

}
