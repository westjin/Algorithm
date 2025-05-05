import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int WHITE = 0;
    static int BLUE = 0;
    static int[][] paper;


    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int N = Integer.parseInt(stringTokenizer.nextToken());
        int row, col = 0;
        int size= N;

        paper = new int[N][N];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(stringTokenizer.nextToken());
            }
        }
        check(0, 0, N);
        System.out.println(WHITE);
        System.out.println(BLUE);



    }
    public static void check(int row, int col, int size){

        if (checkColor(row, col, size)){
            if (paper[row][col] == 1){
                BLUE++;
            }else {WHITE++;}

            return;
        }

        int newSize = size / 2;
        check(row,col,newSize);
        check(row + newSize,col,newSize);
        check(row,col + newSize,newSize);
        check(row + newSize,col + newSize,newSize);

    }

    public static boolean checkColor(int row, int col, int size){
        int color = paper[row][col];
        //전체 종이를 돌자
        for (int i = row; i < row + size;i ++) {
            for (int j = col; j < col + size; j++) {
                if (color != paper[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

}
