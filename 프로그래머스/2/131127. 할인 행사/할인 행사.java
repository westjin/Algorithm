import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        
        HashMap<String,Integer> map = new HashMap<>();
        int count = 0;
        
        
        for(int i = 0; i < number.length; i++){
            map.put(want[i],number[i]);
        }
        
        
        
        
        for(int i = 0; i + 9 < discount.length; i++){
            HashMap<String,Integer> temp = new HashMap<>(map);
            boolean status = true;
            
            for(int j = i; j < i + 10; j++){
                
                String name = discount[j];
                if(temp.containsKey(name) && temp.get(name) != 0){
                    temp.put(name,temp.getOrDefault(name,0) -1);
                }else{
                    status = false;
                    break;
                }
            }
            
            if(status){
                count++;
            }
        }
            
        return count;
    }
}