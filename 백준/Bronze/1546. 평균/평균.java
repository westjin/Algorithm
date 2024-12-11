import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long sum = 0;
        long max = 0;

        for (int i = 0; i < N; i++) {
            int temp = sc.nextInt();
            if (temp > max) {
                max = temp;
            }
            sum += temp;
        }
        //.0을 붙이면 더블형 계산으로 자동으로 바뀐다
        System.out.println(sum * 100.0 / max / N);

    }

}