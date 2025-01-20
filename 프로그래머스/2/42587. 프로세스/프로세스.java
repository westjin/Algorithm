import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int solution(int[] priorities, int location) {
     int answer = 0;
        int max = priorities[0];
        int[] now;
        int[] sol = new int[priorities.length ];
        int order = 0;

        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            q.add(new int[] {priorities[i],i});
            if (priorities[i] > max) {
                max = priorities[i];
            }
        }

        while (!q.isEmpty()) {
            for (int[] check : q){
                if (max < check[0]){
                    max = check[0];
                }
            }
            now = q.poll();

            if (now[0] < max){
                q.add(now);
            }else if(now[0] == max){
                sol[now[1]] = ++order;
                max = 0;
            }
        }


        return answer = sol[location];
    }
}