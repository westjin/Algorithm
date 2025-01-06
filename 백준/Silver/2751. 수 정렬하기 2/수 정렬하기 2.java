import java.io.*;

public class Main {
    public static int[] A,tmp;

    public static void main(String[] args) throws IOException{

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        int N = Integer.parseInt(br.readLine());
        A = new int[N+1];
        tmp = new int[N+1];

        for (int i = 1; i < N+1; i++) {
            A[i] = Integer.parseInt(br.readLine());
        }

        merge_sort(1,N);
        for (int i = 1; i < N+1; i++) {
            bw.write(A[i] + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void merge_sort(int s, int e){
        //계속해서 분할하자.
        if (e - s < 1)
            return;

        //재귀 함수 형태로 구현
        int m = s + (e-s) / 2; // 중간점 안전하게 구하기
        merge_sort(s,m);
        merge_sort(m+1,e);

        for (int i = s; i <= e; i++) {
            tmp[i] = A[i];
        }
        int k = s; // 정렬할 배열의 인덱스

        int index1 = s; // 왼쪽 배열

        int index2 = m+1; //오른쪽 배열

        while (index1 <= m && index2 <= e){ //두 그룹을 병합하는 로직
            // 양쪽 그룹의 인덱스가 가리키는 값을 비교해 더 작은 수를 선택해 배열에 저장하고, 선택된 데이터의 인덱스 값을 오른쪽으로 한칸 이동하기
            if (tmp[index1] > tmp[index2]){
                A[k] = tmp[index2];
                index2++;
                k++;
            }else {
                A[k] = tmp[index1];
                index1++;
                k++;
            }
        }
        while (index1 <= m){
            A[k] = tmp[index1];
            index1++;
            k++;
        }
        while (index2 <= e){
            A[k] = tmp[index2];
            index2++;
            k++;
        }

    }


}
