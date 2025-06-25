import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

    static int N;
    static int count;
    static Egg[] eggs;
    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        N = Integer.parseInt(stringTokenizer.nextToken());

        eggs = new Egg[N];
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int durability = Integer.parseInt(stringTokenizer.nextToken());
            int weight = Integer.parseInt(stringTokenizer.nextToken());
            eggs[i] = new Egg(weight, durability);
        }

        dfs(0);
        System.out.println(count);
    }
    public static void dfs(int idx) {


        if (idx == N) {
            // 계란 중 durability <= 0인 것 세서 최대 갱신
            int broken = 0;
            for (int i = 0; i < N; i++) {
                if (eggs[i].durability <= 0){
                    broken ++;
                }
            }
            count = Math.max(broken, count);
            return;
        }

        //때리는 계란이 살아있는지 확인
        if (eggs[idx].durability <= 0) {
            // 집은 계란이 이미 깨진 계란 → 다음 계란으로 넘어감
            dfs(idx + 1);
            return;
        }


        boolean didHit = false;
        // 칠 수 있는 모든 계란에 대해 확인
        for (int i = 0; i < N; i++) {
            if (i == idx || eggs[i].durability <= 0)
                continue;

            didHit = true;

            // 계란 idx가 계란 i를 친다
            eggs[idx].durability -= eggs[i].weight;
            eggs[i].durability -= eggs[idx].weight;

            dfs(idx + 1);

            eggs[idx].durability += eggs[i].weight;
            eggs[i].durability += eggs[idx].weight;

        }

        if (!didHit) {
            //칠 수 있는 계란이 없다면 바로 넘어감
            dfs(idx + 1);
        }
    }


    public static class Egg{
        int weight;
        int durability;

        public Egg(int weight, int durability) {
            this.weight = weight;
            this.durability = durability;
        }
    }

}
