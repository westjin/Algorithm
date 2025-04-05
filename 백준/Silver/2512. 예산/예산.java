import static java.lang.Math.min;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int[] arr;
    static int maxRequest;
    static int max;


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());


        int N = Integer.parseInt(st.nextToken());
        arr = new int[N];
        maxRequest = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (arr[i] > maxRequest){
                maxRequest = arr[i];
            }
        }

        st= new StringTokenizer(br.readLine());
        max = Integer.parseInt(st.nextToken());
        System.out.println(binarySearch(maxRequest));



    }


    public static int binarySearch(int maxRequest) {
        int left = 0;
        int right = maxRequest;
        int mid;
        int result = 0;

        while(left <= right){
            mid = (left + right) / 2;
            if(isPossible(mid)){ //예산이 최대 금액을 넘지 않았음
                result = mid;
                left = mid + 1;
            }else right = mid - 1;
        }
        return result;
    }

    public static boolean isPossible(int mid){
        int sum = 0;
        for (int request : arr) {
            sum += min(request,mid);
        }
        if (sum > max){
            return false;
        }else return true;
    }
}
