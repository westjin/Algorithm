import java.util.*;

class Solution {
    // 등장 인물 (항상 고정)
    static char[] friends = {'A', 'C', 'F', 'J', 'M', 'N', 'R', 'T'};
    static boolean[] visited = new boolean[8];   // 방문 체크
    static char[] lineUp = new char[8];          // 현재 순열
    static int answer = 0;

    public int solution(int n, String[] data) {
        answer = 0;  // 결과 초기화
        dfs(0, data); // 순열 생성 시작
        return answer;
    }

    // 순열 생성
    static void dfs(int depth, String[] data) {
        if (depth == 8) {
            if (isValid(data)) {
                answer++;
            }
            return;
        }

        for (int i = 0; i < 8; i++) {
            if (!visited[i]) {
                visited[i] = true;
                lineUp[depth] = friends[i];
                dfs(depth + 1, data);
                visited[i] = false;
            }
        }
    }

    // 조건 만족 여부 확인
    static boolean isValid(String[] data) {
        Map<Character, Integer> pos = new HashMap<>();
        for (int i = 0; i < 8; i++) {
            pos.put(lineUp[i], i);
        }

        for (String cond : data) {
            char a = cond.charAt(0);
            char b = cond.charAt(2);
            char op = cond.charAt(3);
            int dist = cond.charAt(4) - '0';

            int actual = Math.abs(pos.get(a) - pos.get(b)) - 1;

            if (op == '=') {
                if (actual != dist) return false;
            } else if (op == '<') {
                if (actual >= dist) return false;
            } else if (op == '>') {
                if (actual <= dist) return false;
            }
        }
        return true;
    }
}
