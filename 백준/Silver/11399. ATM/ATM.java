import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());


        int[] A = new int[N];
        int[] S = new int[N];

        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }



        for (int i = 1; i < N; i++) {
            int insertPoint = i;
            int insertValue = A[i];
            for (int j = i-1; j >= 0 ; j--) { // 값 비교
                if(A[j] < A[i]){
                    insertPoint = j+1;
                    break;
                }
                if (j == 0){
                    insertPoint = 0;
                }
            }
            for (int j = i; j > insertPoint ; j--) { //공간 창출 여기 다시 구현하기
                A[j] = A[j-1];
            }
            A[insertPoint] = insertValue;
        }

        S[0] = A[0];
        for (int i = 1; i < N; i++) {
            S[i] = S[i-1] + A[i]; // 합배열
        }
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum += S[i];
        }

        System.out.println(sum);

    }

}
