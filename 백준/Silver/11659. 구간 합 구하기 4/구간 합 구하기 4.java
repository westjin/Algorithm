

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        // 받는 데이터가 많은 경우 scanner 대신 BufferedReader를 이용하자

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        //예제에서 100,000만개가 주어질 때 옆으로 길게 주어질 것,
        //이런 경우에는 Int형으로 받기 어렵기 때문에 StringTokenizer를 이용하자
        //readLine 한 번 실행-> 한 줄을 가져온다.
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int suNo = Integer.parseInt(stringTokenizer.nextToken());
        int quizNo = Integer.parseInt(stringTokenizer.nextToken());

        //인덱스 0 생략을 위해서
        long[] S = new long[suNo + 1];
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 1; i <= suNo; i++) {
            S[i] = S[i-1] + Integer.parseInt(stringTokenizer.nextToken());
        }

        for (int q = 0; q < quizNo; q++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int i = Integer.parseInt(stringTokenizer.nextToken());
            int j = Integer.parseInt(stringTokenizer.nextToken());
            System.out.println(S[j] - S[i-1]);
        }






    }

}
