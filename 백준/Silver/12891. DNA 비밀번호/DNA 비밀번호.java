

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {

    static int myArr[];
    static int checkArr[];
    static int checkSecret;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        // 데이터 저장
        int S = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        int Result = 0;
        checkArr = new int[4]; // A C G T
        myArr = new int[4];
        char A[] = new char[S];
        checkSecret = 0;// 4개의 문자열 중에 몇개의 문자열에 대해서 조건을 만족하는지 체크하는 변수

        A = bf.readLine().toCharArray();
        st = new StringTokenizer(bf.readLine());
        for (int i = 0; i < 4; i++) {
            checkArr[i] = Integer.parseInt(st.nextToken());
            if (checkArr[i] == 0) {
                checkSecret++;
            }
        }

        for (int j = 0; j < P; j++) { //부분 문자열 처음 받을 때 세팅
            Add(A[j]);
        }

        if (checkSecret == 4) {
            Result++;
        }

        //슬라이딩 윈도우
        for (int i = P; i < S; i++) { // i = P이기 때문에 다음 칸을 포함하고 있음.
            int j = i - P; // i - P는 슬라이딩 윈도우의 제일 첫번째 칸을 의미한다. i는 슬라이딩 윈도우의 제일 마지막 칸이다.
            Add(A[i]);
            Remove(A[j]);
            if (checkSecret == 4) {
                Result++;
            }
        }

        System.out.println(Result);

    }

    private static void Remove(char c) {
        switch (c) {
            case 'A':
                if (myArr[0] == checkArr[0]) {
                    checkSecret--;
                }
                myArr[0]--;
                break;
            case 'C':
                if (myArr[1] == checkArr[1]) {
                    checkSecret--;
                }
                myArr[1]--;
                break;
            case 'G':
                if (myArr[2] == checkArr[2]) {
                    checkSecret--;
                }
                myArr[2]--;
                break;
            case 'T':
                if (myArr[3] == checkArr[3]) {
                    checkSecret--;
                }
                myArr[3]--;
                break;
        }
    }

    private static void Add(char c) {
        switch (c) {
            case 'A':
                myArr[0]++;
                if (myArr[0] == checkArr[0]) {
                    checkSecret++;
                }
                break;
            case 'C':
                myArr[1]++;
                if (myArr[1] == checkArr[1]) {
                    checkSecret++;
                }
                break;
            case 'G':
                myArr[2]++;
                if (myArr[2] == checkArr[2]) {
                    checkSecret++;
                }
                break;
            case 'T':
                myArr[3]++;
                if (myArr[3] == checkArr[3]) {
                    checkSecret++;
                }
                break;
        }
    }

}
