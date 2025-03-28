import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());


        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
            Collections.reverseOrder()
        );

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            if (number == 0){
                if(maxHeap.isEmpty()){
                    System.out.println(0);
                }else System.out.println(maxHeap.poll());
            }
            maxHeap.add(number);
        }



    }

}
