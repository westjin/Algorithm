

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static boolean v[];
    static int arr[];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        v = new boolean[N+1];
        arr = new int[M];
        DFS(0,M,N);




    }
    public static void DFS(int depth, int M, int N){
        if(depth == M){
            //출력
            for (int i = 0; i < M; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= N; i++) {
            if(!v[i]){
                v[i] = true;
                arr[depth] = i;
                DFS(depth+1, M, N);
                v[i] = false;
            }
        }

    }

}
