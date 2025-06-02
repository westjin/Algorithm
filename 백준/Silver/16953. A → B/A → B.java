import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        int A = Integer.parseInt(stringTokenizer.nextToken());
        int B = Integer.parseInt(stringTokenizer.nextToken());
        int answer = 1;

        while (B != A){
            if(B < A){
                answer = -1;
                break;
            }

            if(B % 2 == 0){
                B /= 2;
                answer++;

            }else if(B % 10 == 1){
                B /= 10;
                answer++;

            }else {
                answer = -1;
                break;
            }

        }

        System.out.println(answer);
    }

}
