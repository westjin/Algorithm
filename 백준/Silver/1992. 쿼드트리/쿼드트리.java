import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int[][] quad;
    static int BLACK = 1;
    static int WHITE = 0;
    static StringBuilder stringBuilder;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        stringBuilder = new StringBuilder();

        int N = Integer.parseInt(bufferedReader.readLine());
        quad = new int[N][N];
        int row = 0;
        int col = 0;
        int size = N;

        for (int i = 0; i < N; i++) {
            String line = bufferedReader.readLine();
            for (int j = 0; j < N; j++) {
                //한글자씩 숫자 변환
                quad[i][j] = line.charAt(j) - '0';
            }
        }

        check(row,col,size);
        System.out.println(stringBuilder.toString());
        bufferedReader.close();
    }
    private static void check(int row, int col, int size){
        if (checkColor(row,col,size)){
            stringBuilder.append(quad[row][col]);
            return;
        }

        stringBuilder.append("(");
        int newSize = size / 2;
        check(row, col, newSize);
        check(row, col + newSize, newSize);
        check(row + newSize, col, newSize);
        check(row + newSize , col + newSize, newSize);
        stringBuilder.append(")");


    }

    private static boolean checkColor(int row, int col, int size){
        int color = quad[row][col];
        for (int i = row; i < row + size; i++) {
            for (int j = col; j < col + size; j++) {
                if (color != quad[i][j]){
                    return false;
                }
            }
        }
        return true;
    }

}
