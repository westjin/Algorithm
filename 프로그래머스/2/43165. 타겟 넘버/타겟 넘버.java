import java.util.LinkedList;
import java.util.Queue;

class Solution {
    static int count;
    public int solution(int[] numbers, int target) {
        BFS(numbers,target);
        return count;
    }
     private static void BFS (int[] numbers,int target){
            int[] now = new int[] {0,0};

            Queue<int[]> q = new LinkedList<>();

            q.offer(new int[]{now[0] + numbers[now[1]],now[1]});
            q.offer(new int[]{now[0] - numbers[now[1]],now[1]});
            while (!q.isEmpty()){
                now = q.poll();
                if (now[0] == target && now[1] == numbers.length -1){
                    count ++;
                }
                if (now[1] < numbers.length -1){
                    q.offer(new int[]{now[0] + numbers[now[1]+1],now[1]+1});
                    q.offer(new int[]{now[0] - numbers[now[1]+1],now[1]+1});
                }
            }

        }
}