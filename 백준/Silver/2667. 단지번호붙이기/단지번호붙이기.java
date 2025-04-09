import java.awt.image.ImageProducer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static int[][] map;
    static boolean[][] v;
    static int count = 0, number = 0 ;// 총 단지 수
    static int x[] = {-1, 1, 0, 0}; // row
    static int y[] = {0, 0, -1, 1}; // col
    static int size;



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        size = Integer.parseInt(br.readLine());
        map = new int[size][size];
        v = new boolean[size][size];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            String line = br.readLine();
            for (int j = 0; j < size; j++) {
                map[i][j] = line.charAt(j) - '0'; // '1' → 1, '0' → 0 으로 변환
            }
        }


        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {

                if(v[i][j] == false && map[i][j] == 1) {
                    count = 0; // 단지 집 개수
                    number++; // 단지 번호 증가
                    DFS(i, j);
                    list.add(count); //해당 단지의 집 수 저장
                }
            }
        }

        Collections.sort(list);
        bw.append(number + "\n");
        for(int num : list) {
            bw.append(num + "\n");
        }
        bw.flush();
        bw.close();
    }


    public static void DFS(int i, int j){
        map[i][j] = number; // 방문한 집 표시
        v[i][j] = true;
        count ++;


        for(int k=0; k<x.length; k++) {
            int ix = i + x[k];
            int jy = j + y[k];

            if(ix >= 0 && ix < size && jy >= 0 && jy < size) {
                if(map[ix][jy] == 1 && !v[ix][jy]) {
                    DFS(ix, jy); // 연결 되어있는 단지 탐색
                }
            }
        }
    }



}




