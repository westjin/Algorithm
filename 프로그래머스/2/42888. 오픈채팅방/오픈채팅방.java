import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        String[] answer = {};
        
        HashMap<String,String> map = new HashMap<>();
        StringTokenizer st;
        List<String> list = new ArrayList<>();

        
        for(int i = 0; i < record.length; i++){
            st = new StringTokenizer(record[i]);
            String status = st.nextToken();
            String uid = st.nextToken();
            
            if (status.equals("Leave")){
                continue;
            }
            String nickname = st.nextToken();
            
            if(status.equals("Change")){
                map.put(uid,nickname);
                continue;
            }
           
            map.put(uid,nickname);
        }
        
        
        for(int i = 0; i < record.length; i ++){
         
            st = new StringTokenizer(record[i]);
            
            String cmd = st.nextToken();
            String uid;
            String name;
            
            if(cmd.equals("Leave")){
                uid = st.nextToken();
            }else{
                uid = st.nextToken();
                name = st.nextToken();
            }
                
            
            if(cmd.equals("Enter")){
                list.add(map.get(uid) + "님이 들어왔습니다.");
            }else if(cmd.equals("Leave")){
                list.add(map.get(uid) + "님이 나갔습니다.");
            }
        
        }
        
        
        
        
        return list.toArray(new String[0]);
    }
}