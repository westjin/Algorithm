import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        int bit = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        StringBuilder stringBuilder = new StringBuilder();

        int N = Integer.parseInt(stringTokenizer.nextToken());

        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(br.readLine());
            String cmd = stringTokenizer.nextToken();

            if(cmd.equals("add")){
                int x = Integer.parseInt(stringTokenizer.nextToken());
                bit |= 1 << (x - 1);
            }else if(cmd.equals("remove")){
                int x = Integer.parseInt(stringTokenizer.nextToken());
                bit &= ~(1 << (x-1));
            } else if (cmd.equals("check")) {
                int x = Integer.parseInt(stringTokenizer.nextToken());
                stringBuilder.append((bit & (1 << (x - 1))) != 0 ? "1\n" : "0\n");
            } else if (cmd.equals("toggle")) {
                int x = Integer.parseInt(stringTokenizer.nextToken());
                bit ^= (1 << (x - 1));
            } else if (cmd.equals("all")) {
                bit = (1 << 20) - 1;
            } else if (cmd.equals("empty")) {
                bit = 0;
            }


        }

        System.out.print(stringBuilder);

    }


}
