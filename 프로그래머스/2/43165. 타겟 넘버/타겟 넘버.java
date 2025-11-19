class Solution {
    public int solution(int[] numbers, int target) {
        return dfs(0,0,numbers,target);
    }
    
    
    public int dfs(int idx,int cur, int[] numbers, int target){

        if(idx == numbers.length){
            return (cur == target) ? 1 : 0;    
        }
        
        int sum = 0;
        sum += dfs(idx + 1, cur + numbers[idx], numbers, target);
        sum += dfs(idx + 1, cur - numbers[idx], numbers, target);
        
        return sum;
    
    }
    
    
}