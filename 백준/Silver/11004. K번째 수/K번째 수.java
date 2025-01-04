

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K= Integer.parseInt(st.nextToken());
        int[] A = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }
        quickSort(A,0,N-1,K-1);
        System.out.println(A[K-1]);
    }

    public static void quickSort(int[] A, int S, int E, int K){
        if (S < E){
            int pivot = partition(A, S, E);
            if (pivot == K){
                return;
            } else if (K < pivot) { // K가 피벗보다 작으면 왼쪽 그룹만 정렬하기
                quickSort(A,S,pivot-1,K);
            }
            else //K가 피벗보드 크면 오른쪽만 정렬 수행하기
                quickSort(A,pivot+1 ,E,K);
        }
    }




    public static int partition(int[] A, int S, int E){ //피벗을 기준으로 두 부분으로 나누는 작업
        int M = (S + E) / 2;
        swap(A,S,M); //중앙값을 첫번째로 이동하기.
        int pivot = A[S];
        int i = S + 1;
        int j = E;

        while (i <= j) {
            while (j >= S + 1 && pivot < A[j]) { //피벗보다 작은 수가 나올때 까지 --;
                j--;
            }

            while (i <= E && pivot > A[i]) { //피벗보다 큰 수가 나올때까지 ++;
                i++;
            }
            if (i <= j) {
                swap(A, i++, j--);
            }
        }

        A[S] = A[j];
        A[j] = pivot;
        return j; //피벗이 최종적으로 위치한 인덱스를 반환
    }


    public static void swap(int[] A ,int i, int j){
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }



}
