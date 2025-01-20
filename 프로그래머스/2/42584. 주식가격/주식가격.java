
import java.util.LinkedList;
import java.util.Queue;
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int index = 0;
        int now = 0;
        int count = 0;

        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < prices.length; i++) {
            q.add(prices[i]);
        }
        while (!q.isEmpty()) {
            now = q.poll();
            count = 0;

            if (index == prices.length -1){
                answer[index] = 0;
                break;
            }

            for (int i = index + 1; i < prices.length; i++) {
                if (now <= prices[i]) {
                    count += 1;

                } else {
                    count += 1;
                    answer[index] = count;
                    break;
                }

            }
            answer[index] = count;
            index += 1;
        }


        return answer;
    }
}