import java.util.*;

class Solution {
    public int[] solution(int[] num_list) {
        int num = num_list.length;
        int[] answer = new int[num];
        
//         Integer[] result = Arrays.stream(num_list).boxed().toArray(Integer[]::new);
//         Arrays.sort(result,Collections.reverseOrder());// 내림차순
//         return Arrays.stream(result).mapToInt(Integer::intValue).toArray();
        
        for(int i = 0; i < num_list.length; i++){
            answer[i] = num_list[num - 1];
            num--;
        }
        
        
        return answer;
    }
}