

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int C = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            queue.add(i+1);
        }

        while (queue.size() > 1) {
            queue.poll();
            C = queue.poll();
            queue.add(C);
        }

        System.out.println(queue.peek());
    }

}
