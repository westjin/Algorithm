class Solution {
    static int count;
    public int solution(int[] numbers, int target) {
        int answer = 0;
        DFS(numbers,target, numbers[0], 0);
        DFS(numbers,target, numbers[0]*-1, 0);
        
        return count;
    }
     private static void DFS ( int[] numbers, int target, int now, int index){

            if (index == numbers.length - 1) {
                if (now == target) {
                    count++;
                }
                return;
            }

            DFS(numbers, target, now + numbers[index+1], index + 1); // +
            DFS(numbers, target, now - numbers[index+1], index + 1); // -
        }
}