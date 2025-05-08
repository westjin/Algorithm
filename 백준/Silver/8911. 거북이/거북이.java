import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
// 북 동 남 서 이동
// 북 동 남 서 → 시계 방향
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine());
        while (n-- > 0){
            String command = bufferedReader.readLine();

            //현재위치
            int x = 0;
            int y = 0;

            //동서남북
            int dir = 0;
            int minX = 0, maxX = 0, minY = 0, maxY = 0;

            for (char cmd : command.toCharArray()){

                switch (cmd){
                    case 'F' :
                        x += dx[dir];
                        y += dy[dir];
                        break;
                    case 'B' :
                        x -= dx[dir];
                        y -= dy[dir];
                        break;
                    case 'R' :
                        dir = (dir + 1) % 4;
                        break;
                    case 'L' :
                        dir = (dir + 3) % 4;
                        break;
                }
                //새로운 좌표 적용
                minX = Math.min(minX, x);
                maxX = Math.max(maxX, x);
                minY = Math.min(minY, y);
                maxY = Math.max(maxY, y);
            }
            int area = (maxX - minX) * (maxY - minY);
            System.out.println(area);
        }
    }
}
