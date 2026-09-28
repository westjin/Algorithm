import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        ArrayList<Integer> list = new ArrayList<>();
        
        HashMap<String,Integer> hashmap = new HashMap<>();
        String[] token = today.split("\\.");
        
        int year = Integer.parseInt(token[0]);
        int month = Integer.parseInt(token[1]);
        int day = Integer.parseInt(token[2]);
        int curday = year * 12 * 28 + (month*28) + day;
        
        StringTokenizer st;
        String type;
        int during;
        
        for(int i = 0; i < terms.length; i++){
            st = new StringTokenizer(terms[i]);
            type = st.nextToken();
            during = Integer.parseInt(st.nextToken());
            hashmap.put(type,during);
        }
        
        for(int i = 0; i < privacies.length; i++){
            st = new StringTokenizer(privacies[i]);
            String privacyDate = st.nextToken();
            String[] days = privacyDate.split("\\.");
            type = st.nextToken();
            during = hashmap.get(type);
            int active = during * 28;
            
            int oyear = Integer.parseInt(days[0]);
            int omonth = Integer.parseInt(days[1]);
            int oday = Integer.parseInt(days[2]);
            int oldday = oyear * 12 * 28 + (omonth * 28) + oday;
            
            if(oldday + active <= curday){
                   list.add(i+1);
            }
        }
        
        answer = new int[list.size()];
        for(int i = 0; i<list.size(); i++){
            answer[i] = list.get(i);
        
        }
            
            
        
        
        
        
        
        
        return answer;
    }
}