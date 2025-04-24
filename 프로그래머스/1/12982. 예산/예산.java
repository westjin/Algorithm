import java.util.*;
class Solution {
    public int solution(int[] d, int budget) {
        int budgetCopy = budget;
        Arrays.sort(d);
        int answer = 0;
        
        for(int price : d){
            budgetCopy -= price;
            if(budgetCopy < 0){
                break;
            }
            answer ++;
        }
        
        return answer;
    }
}