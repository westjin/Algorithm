import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

    static int[][] board = new int[9][9];
    static List<int[]> blanks;
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        blanks = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(stringTokenizer.nextToken());
                if (board[i][j] == 0){
                    blanks.add(new int[]{i, j});
                }
            }
        }
        dfs(0);
    }
    public static void dfs(int depth){
        if(depth == blanks.size()){
            printBoard();
            System.exit(0);
        }

        int[] pos = blanks.get(depth);
        int row = pos[0];
        int col = pos[1];

        for (int i = 1; i <= 9; i++) {
            if (isValid(row,col,i)){
                board[row][col] = i;
                dfs(depth + 1);
                board[row][col] = 0;
            }
        }
    }

    public static boolean isValid(int row, int col, int num) {

        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        for (int i = 0; i < 9; i++) {
            if (board[row][i] == num || board[i][col] == num) {
                return false;
            }
        }

        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num){
                    return false;
                }
            }
        }

        return true;
    }

    public static void printBoard(){

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {

                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }


    }



}
