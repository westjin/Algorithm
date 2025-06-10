import java.util.*;
class Solution {
    //조합된 숫자 중에 중복이 있으면 안되므로 Set 
    static Set<Integer> numberSet;
    // numbers는 길이 1 이상 7 이하인 문자열
    static boolean[] visited = new boolean[7]; 
 
    public static int solution(String numbers) {
        int answer = 0;
        numberSet = new HashSet<>();
        dfs(numbers, "", 0);
 
        for (Integer num : numberSet) {
            if (isPrime(num)) {
                answer++;
            }
        }
        return answer;
    }
    
    public static void dfs(String numbers, String s, int depth) {
		// numbers 의 끝까지 다 탐색했다면 종료
        if (depth > numbers.length()) {
            return;
        }
 
        for (int i = 0; i < numbers.length(); i++) {
            if(!visited[i]) {
                visited[i] = true;
                numberSet.add(Integer.parseInt(s + numbers.charAt(i)));
                dfs(numbers ,s + numbers.charAt(i), depth + 1);
                visited[i] = false;
            }
        }
    }
    
    public static boolean isPrime(Integer num) {
        if (num == 0 || num == 1)
            return false;
        //  에라토스테네스의 체의 limit 숫자를 계산한다.
        int lim = (int)Math.sqrt(num);

        //  에라토스테네스의 체에 따라 lim까지 배수 여부를 확인한다.
        for (int i = 2; i <= lim; i++)
            if (num % i == 0)
                return false;

        return true;
    }
}