import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int k = Integer.parseInt(stringTokenizer.nextToken());
        int n = Integer.parseInt(stringTokenizer.nextToken());
        int[] arr = new int[k];
        
        // 왜 long?
        long max = 0;
        
        for (int i = 0; i < k; i++) {
            arr[i] = Integer.parseInt(bufferedReader.readLine());
            //
            if (max < arr[i]){
                max = arr[i];
            }
        }
        
        
        //반드시 Max + 1 이어야 함
        max ++; 
        
        
        long min = 0;
        long mid = 0;
        
        while (min < max){

            mid = (min + max) / 2;
            long count = 0;
            // 
            for (int i = 0; i < arr.length; i++) {
                count += (arr[i] / mid);
            }
            if (count < n){
                max = mid;
            }else {
                min = mid + 1;
            }
            
        }

        System.out.println(min - 1);
        
        
        
        
        
        
    }

}
