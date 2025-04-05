import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int[] origin;
    static int[] check;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        origin = new int[N];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            origin[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        check = new int[M];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            check[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(origin);


        binarySearch(bw);
        bw.flush();
        bw.close();
        br.close();


    }

    public static void binarySearch( BufferedWriter bw) throws IOException {
        for (int i = 0; i < check.length; i++) {
            int result = Arrays.binarySearch(origin, check[i]);
            if(result >= 0){
                bw.write("1\n");
            }else bw.write("0\n");
        }
    }


}
