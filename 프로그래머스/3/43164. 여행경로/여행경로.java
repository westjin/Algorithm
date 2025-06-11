import java.util.*;

class Solution {
    static boolean[] visited;
    static List<String> route;
    static String[] answer;

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        route = new ArrayList<>();

        // 티켓 정렬 (사전순 우선 탐색)
        Arrays.sort(tickets, (a, b) -> {
            if (!a[0].equals(b[0])) return a[0].compareTo(b[0]);
            return a[1].compareTo(b[1]);
        });

        // DFS 시작
        route.add("ICN");
        dfs("ICN", tickets, 0);

        return answer;
    }

    static boolean dfs(String from, String[][] tickets, int depth) {
        if (depth == tickets.length) {
            answer = route.toArray(new String[0]);
            return true;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(from)) {
                visited[i] = true;
                route.add(tickets[i][1]);
                if (dfs(tickets[i][1], tickets, depth + 1)) return true;
                visited[i] = false;
                route.remove(route.size() - 1);
            }
        }

        return false;
    }
}
