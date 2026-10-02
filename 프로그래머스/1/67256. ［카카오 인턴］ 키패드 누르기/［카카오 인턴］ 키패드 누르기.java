import java.io.*;
import java.util.*;

class Solution {
    public String solution(int[] numbers, String hand) {
        String answer = "";
        StringBuilder sb = new StringBuilder();
        
        //1 2 3
        //4 5 6
        //7 8 9
        //* 0 #
        
        int[][] pos = {
            //인덱스가 숫자구나
            {3,1}, //0
            {0,0}, //1
            {0,1}, //2
            {0,2}, //3
            {1,0}, //4
            {1,1}, //5
            {1,2}, //6
            {2,0}, //7
            {2,1}, //8
            {2,2}, //9
        };
        int[] left = {3, 0};   // *
        int[] right = {3, 2};  // #
        
        for(int i = 0; i < numbers.length; i++){
            int num = numbers[i];
            if (num == 1 || num == 4 || num == 7) {
                // 왼손
                sb.append("L");
                //1에 해당하는 배열 위치로 왼손을 옮겨야 하자나
                left = pos[num];
            } else if (num == 3 || num == 6 || num == 9) {
                // 오른손
                sb.append("R");
                right = pos[num];
            } else {
                // 2, 5, 8, 0 → 거리 비교
                 int tx = pos[num][0];
                 int ty = pos[num][1];
                
                int leftDist = Math.abs(left[0] - tx) + Math.abs(left[1] - ty);
                int rightDist = Math.abs(right[0] - tx) + Math.abs(right[1] - ty);
                
                if(leftDist > rightDist){
                    sb.append("R");
                    right = pos[num];
                }else if (leftDist < rightDist){
                    sb.append("L");
                    left = pos[num];
                }else{
                    if(hand.equals("left")){
                        sb.append("L");
                        left = pos[num];
                    }else{
                        sb.append("R");
                        right = pos[num];
                    }
                }
                               
            }
            
        }
        
        
        
        
    
        
        return sb.toString();
    }
}