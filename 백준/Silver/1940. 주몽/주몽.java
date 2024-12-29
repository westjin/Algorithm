

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // scanner가 아닌 bufferdreader 쓰는 이유
        // 숫자를 많이 입력 받아야 할 때 스캐너보다 입출력이 빠르다
        Arrays.sort(A);
        int count = 0;
        int i = 0; // A[0]
        int j = N-1; //A[N-1]
        while (i<j){
            if (A[i] + A[j] < M){
                i ++;
            } else if (A[i] + A[j] > M) {
                j--;
            }else {
                count ++;
                i ++;
                j --;
            }
        }

        System.out.println(count);
    }

}
