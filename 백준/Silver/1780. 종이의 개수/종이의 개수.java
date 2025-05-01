import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static int[][] papaer;
    public static int GRAY = 0;
    public static int WHITE = 0;
    public static int BLACK = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());
        papaer = new int[N][N];
        StringTokenizer stringTokenizer;
        for (int i = 0; i < N ; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine(), " ");
            for (int j = 0; j < N; j++) {
                papaer[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        partition(0, 0, N);
 
		System.out.println(GRAY);	// -1
		System.out.println(WHITE);	// 0
		System.out.println(BLACK);	// 1
 

    }

    private static void partition(int row, int col, int size) {
        if (colorCheck(row, col, size)) {
            if (papaer[row][col] == -1) {
                GRAY++;
            } else if (papaer[row][col] == 0) {
                WHITE++;
            } else {
                BLACK++;
            }
            return;
        }

        int newSize = size / 3;

        partition(row, col, newSize);
        partition(row, col + newSize, newSize);
        partition(row, col + 2 * newSize, newSize);                    // 오른쪽 위

        partition(row + newSize, col, newSize);                        // 왼쪽 중간
        partition(row + newSize, col + newSize, newSize);            // 중앙 중간
        partition(row + newSize, col + 2 * newSize, newSize);        // 오른쪽 중간

        partition(row + 2 * newSize, col, newSize);                    // 왼쪽 아래
        partition(row + 2 * newSize, col + newSize, newSize);        // 중앙 아래
        partition(row + 2 * newSize, col + 2 * newSize, newSize);    // 오른쪽 아래


    }

    // 해당 영역이 같은 색인지 검사하는 메서드
    private static boolean colorCheck(int row, int col, int size){
        int color = papaer[row][col];

        // 각 블럭의 시작점 (row,col)부터 블럭의 끝(row + size, col + size)까지 검사
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if(color != papaer[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
}
