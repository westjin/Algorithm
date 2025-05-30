import java.util.*;
class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Set<String> reportSet = new HashSet<>(Arrays.asList(report));
        int[] answer = new int[id_list.length];
        
        //id마다 신고 당환 횟수 저장하기
        Map<String,Integer> reports = new HashMap<>();
        for(String id : id_list){
            reports.put(id,0);
        }
        
        //신고 내역 업데이트
        for(String r : reportSet){
            reports.compute(r.split(" ")[1],(key,value) -> value + 1);
        }
        
        
        //해시셋을 순회하면서 신고대상의 신고횟수 확인하기
        for(String r: reportSet){
            String[] s = r.split(" ");
            if(reports.get(s[1]) >= k){
                answer[indexOf(id_list,s[0])]++;
            }
        }
        
        
        return answer;
    }
    
    int indexOf(String[] arr, String target ){
        for(int i = 0; i < arr.length; i++){

            if(arr[i].equals(target)) return i;
        }
        return -1;
    
    }
    
    
}