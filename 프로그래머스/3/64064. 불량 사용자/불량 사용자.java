import java.util.*;


class Solution {
    
    private String[] user_id;
    private String[] banned_id;
    private Set<List<String>> resultSet = new HashSet<>();
        
    public int solution(String[] user_id, String[] banned_id) {
        this.user_id = user_id;
        this.banned_id = banned_id;
        
        //백트래킹 시작
        boolean[] visited = new boolean[user_id.length];
        backtrack(0,new ArrayList<>(),visited);
        return resultSet.size();
        
    }
    
    private void backtrack(int bannedIdx, List<String> selected, boolean[] visited){
        if( bannedIdx == banned_id.length){
            // 여기까지 왔다는 건?
            // → banned_id 개수만큼 user_id를 다 선택했다!
            // → 각 banned_id마다 하나씩 매칭된 상태!

            List<String> combination = new ArrayList<>(selected);
            Collections.sort(combination);  // combination을 정렬
            resultSet.add(combination);     // 정렬된 combination 추가
            
            return;
        }
        
        for(int i = 0; i < user_id.length; i++){
            if(!visited[i] && matches(user_id[i],banned_id[bannedIdx])){
                selected.add(user_id[i]);
                visited[i] = true;
                
                backtrack(bannedIdx + 1,selected,visited);
             
                selected.remove(selected.size() - 1);
                visited[i] = false;
            }
        }
        
        
        
    }
    
    private boolean matches(String userId, String bannedId){
        // 길이 검사
        if(userId.length() != bannedId.length()){
            return false;
        }
        // 패턴 매칭 검사
        for(int i = 0; i < userId.length(); i++){
            if(bannedId.charAt(i) == '*'){
                continue;
            }
            
            if(userId.charAt(i) != bannedId.charAt(i)){
                return false;
            }
        }
        return true;        
    }
    
    
}