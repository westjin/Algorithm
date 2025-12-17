import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    static int colCount;
    static List<Set<Integer>> candidateKeys;

    public int solution(String[][] relation) {
        colCount = relation[0].length;
        List<Integer> picked = new ArrayList<>();
        candidateKeys = new ArrayList<>();
        dfs(0,picked,relation);

        return candidateKeys.size();
    }
    public void dfs(int idx, List<Integer> picked,String[][] relation){
        if (idx == colCount) {
            // 1. 공집합인 경우 무시
            if (picked.isEmpty()) return;
            // 2. 유일성 검사
            if (!isUnique(picked,relation)) return;
            // 3. 최소성 검사
            if (!isMinimal(picked,candidateKeys)) return;
            // 4. 위 조건 통과시 후보키 목록에 추가
            candidateKeys.add(new HashSet<>(picked));
            return;
        }
        //안 고르는 경우

        dfs(idx+1,picked,relation);

        //고르는 경우
        picked.add(idx);
        dfs(idx+1,picked,relation);
        picked.remove(picked.size() - 1);
    }

    public boolean isUnique(List<Integer> picked,String[][] relation){
        Set<String> set = new HashSet<>();

        for (int r = 0; r < relation.length; r++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int col : picked){
                stringBuilder.append(relation[r][col]).append("|");
            }
            set.add(stringBuilder.toString());

        }
        return set.size() == relation.length;
    }


    public boolean isMinimal(List<Integer> picked,List<Set<Integer>> candidateKeys){
        Set<Integer> pickedset = new HashSet<>(picked);

        //“이미 존재하는 후보키 key가
        //지금 검사 중인 picked 안에 전부 들어 있나?”
        //최소성은
        //“기존 후보키 ⊆ 현재 picked ?” 를 검사하는 것
        for (Set<Integer> key : candidateKeys){
            if (pickedset.containsAll(key)){
                return false;
            }
        }
        return true;

    }

}