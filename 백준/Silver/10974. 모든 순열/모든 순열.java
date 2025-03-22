
import java.util.Scanner;

public class Main {


    static boolean[] v;
    static int[] result;
    static int N;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();

        v = new boolean[N+1];
        result = new int[N];
        DFS(0);

    }

    public static void DFS(int depth){
        if(depth == N){
            //출력
            for (int i = 0; i < N; i++) {
                System.out.print(result[i] + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= N ; i++) {
            if (!v[i]){
                v[i] = true;
                result[depth] = i;
                DFS(depth + 1);
                v[i] = false;
            }
        }

    }

}
