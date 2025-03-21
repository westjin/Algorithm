
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int suNo = Integer.parseInt(st.nextToken());
        int[] numbers = new int[suNo];
        int count = 0; // 소수 찾기

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < suNo; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        //값 세팅

        //소수 찾기 로직
        for (int i = 0; i < numbers.length; i++) { //배열 접근
            for (int j = 2; j <= numbers[i]; j++) { //소수 검증
              if (j == numbers[i]){
                  count++;
                  break;
              }
              if(numbers[i] % j == 0){
                  break;
              }
            }
        }

        System.out.println(count);
    }
}
