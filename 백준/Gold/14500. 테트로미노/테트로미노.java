import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] board;
    static boolean[][] visited;
    static int n, m, max = 0;

    // 상하좌우
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        board = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 모든 위치에서 시도
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, board[i][j], 1);
                visited[i][j] = false;
                checkExtraShape(i, j); // 예외 모양 처리
            }
        }

        System.out.println(max);
    }

    // DFS로 4칸 탐색
    public static void dfs(int x, int y, int sum, int depth) {
        if (depth == 4) {
            max = Math.max(max, sum);
            return;
        }

        for (int d = 0; d < 4; d++) {
            int nx = x + dx[d];
            int ny = y + dy[d];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, sum + board[nx][ny], depth + 1);
                visited[nx][ny] = false;
            }
        }
    }

    // 예외 처리: ㅗ, ㅜ, ㅓ, ㅏ 모양
    public static void checkExtraShape(int x, int y) {
        // 중심 + 3방향
        int[][] ex = {
            {0, -1, 0, 1, -1, 0},  // ㅗ
            {-1, 0, 1, 0, 0, -1},  // ㅓ
            {-1, 0, 1, 0, 0, 1},   // ㅏ
            {0, -1, 0, 1, 1, 0}    // ㅜ
        };

        for (int[] shape : ex) {
            int total = board[x][y];
            boolean valid = true;

            for (int i = 0; i < 3; i++) {
                int nx = x + shape[i * 2];
                int ny = y + shape[i * 2 + 1];

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    valid = false;
                    break;
                }

                total += board[nx][ny];
            }

            if (valid) max = Math.max(max, total);
        }
    }
}
