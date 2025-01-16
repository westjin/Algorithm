import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int total_weights = 0;
        int total_time = 0;
        int cross_time = 1;
        int truck_index = 0;

        Queue<Integer[]> q = new LinkedList<>();
        q.add(new Integer[]{truck_weights[truck_index], 0});
        total_weights += truck_weights[truck_index];
        total_time += cross_time;

        while (!q.isEmpty()) {

            for (Integer[] element : q) {
                element[1] += cross_time;

            }
            
            if (q.peek()[1] == bridge_length){
                total_weights -= q.peek()[0];
                q.poll();
            }


            if (truck_index + 1 < truck_weights.length &&
                weight >= total_weights + truck_weights[truck_index + 1]) { 

                System.out.println("if current total time : " + total_time);
                truck_index++;

                q.add(new Integer[]{truck_weights[truck_index], 0}); 
                System.out.println("if truck index " +  truck_index);
                total_weights += truck_weights[truck_index];

            }

            total_time += cross_time;
        }

        return total_time;
    }
}