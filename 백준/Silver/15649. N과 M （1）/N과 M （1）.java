
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean[] v;
    static int[] result;
    static int N,M;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        v = new boolean[N+1];
        result = new int[M];

        DFS(0);

    }
    public static void DFS(int depth){
        if(depth == M){
            for (int i = 0; i < M; i++) {
                System.out.print(result[i] + " ");
            }
            return;
        }

        for (int i = 1; i <= N; i++) {
            if(!v[i]){
                v[i] = true;
                result[depth] = i;
                DFS(depth+1);
                v[i] = false;
            }
        }
    }

}
