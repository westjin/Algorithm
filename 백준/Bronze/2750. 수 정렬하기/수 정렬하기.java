

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] A = new int[N];
        int temp = 0;

        for (int i = 0; i < N; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < N-1 ; i++) { //루프의 범위
            int count = 0;
            for (int j = 0; j < N-1-i; j++) { // 정렬범위
                if(A[j] > A[j+1]){
                    temp = A[j+1];
                    A[j+1] = A[j];
                    A[j] = temp;
                    count ++;
                }
            }
            if (count == 0) break;
        }

        for (int i = 0; i < A.length; i++) {
            System.out.println(A[i]);
        }
    }

}
