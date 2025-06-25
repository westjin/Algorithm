import java.util.Scanner;

public class Main {
    static int count;
    static boolean[] usedCol;
    static boolean[] usedDialg1;
    static boolean[] usedDialg2;


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        usedCol = new boolean[N];
        usedDialg1 = new boolean[2*N];
        usedDialg2 = new boolean[2*N];
        int row = 0;
        count = 0;
        dfs(row,N);
        System.out.println(count);
    }
    public static void dfs(int row,int N){
        
        //행당 하나씩 퀸을 두면서 내려간다.
        
        if (row == N){
            count += 1;
            return;
        }
        for (int col = 0; col < N; col++) {
            if (usedCol[col] == true || usedDialg1[row - col + N] == true || usedDialg2[row + col] == true){
                continue;
            }
            usedCol[col] = true; // 한 열 
            usedDialg1[row - col + N] = true; // 우하향 대각선
            usedDialg2[row + col] = true; // 좌화향 대각선
            dfs(row+1,N);
            
            //백 트래킹 마킹 해제
            
            usedCol[col] = false;
            usedDialg1[row - col + N] = false;
            usedDialg2[row + col] = false;
        }

    }

}
