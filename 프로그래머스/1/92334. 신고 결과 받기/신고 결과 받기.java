import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        HashMap<String,HashSet<String>> map = new HashMap<>(); //누가 누굴 신고
        HashMap<String,Integer> map2 = new HashMap<>(); // 신고 누적 횟수
        
        
        StringTokenizer st;
        for(int i = 0; i < report.length; i++){
            st = new StringTokenizer(report[i]);
            String name1 = st.nextToken();
            String name2 = st.nextToken();
            
            if(!map.containsKey(name1)){
                map.put(name1,new HashSet<>()); //누가 누굴 신고
            }
            
            if(map.get(name1).add(name2)){
                map2.put(name2, map2.getOrDefault(name2,0) + 1); // 해당 사람에 대한 신고 누적횟수
            }
            
            
        }
        
        for(int i = 0; i < id_list.length; i++){
            
            
            
            //한 번도 신고당하지 않은 사람은 map2에 없을 수 있다는 점을 고려
            if(map2.getOrDefault(id_list[i],0) >= k){ // 신고누적 횟수가 k이상 이면,
                //신고한 모든 유저에게 전달 즉 카운트 올려야함 누가 누굴 신고는 map 현재는 벨류 값 존재
                for(int j = 0; j < id_list.length; j++){
                    
                    if(map.containsKey(id_list[j])){
                        if(map.get(id_list[j]).contains(id_list[i])){
                            answer[j]++;
                        }
                    }
                }
                
                
                
            }            
            
        }
        
        
        
        return answer;
    }
}