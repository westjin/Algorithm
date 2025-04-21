import static java.lang.Math.max;


class Solution {
    public int solution(int[] money) {

        int answer;
        
        if (money.length == 3) {return Math.max(Math.max(money[0], money[1]), money[2]);}
        
        
        int[] dp1 = new int[money.length];
        int[] dp2 = new int[money.length];

        int case_1;
        int case_2;

        // 범위 제한 0부터 n-2까지
        dp1[0] = money[0];
        dp1[1] = max(money[0], money[1]);

        // 범위제한 1부터 n-1까지
        dp2[0] = money[1];
        dp2[1] = max(dp2[0], money[2]);


        for (int i = 2; i <= money.length - 2 ; i++) 
        {
            
        dp1[i] = max(dp1[i - 1], dp1[i - 2] + money[i]);
        }
        case_1 = dp1[money.length - 2];

        // 범위 제한 1부터 n-1까지
        for (int i = 2; i <= money.length - 2 ; i++) 
        {
        dp2[i] = max(dp2[i - 1], dp2[i - 2] + money[i+1]);
        }
        case_2 = dp2[money.length - 2];

        answer = max(case_1, case_2);


        return answer;
    }
}