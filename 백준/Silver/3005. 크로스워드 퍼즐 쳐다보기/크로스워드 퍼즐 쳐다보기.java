    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.List;
    import java.util.StringTokenizer;

    public class Main {

        public static void main(String[] args) throws IOException {

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int R = Integer.parseInt(stringTokenizer.nextToken());
            int C = Integer.parseInt(stringTokenizer.nextToken());
            List<String> words = new ArrayList<>();

            String[] puzzle = new String[R];

            for (int i = 0; i < R; i++) {
                puzzle[i] = bufferedReader.readLine();
            }

            // 가로
            for (int i = 0; i < R; i++) {
                String[] split = puzzle[i].split("#");
                for (String splits : split) {
                    if (splits.length() >= 2) {
                        words.add(splits);
                    }
                }
            }

            //세로 만들기
            for (int i = 0; i < C; i++) {
                StringBuilder col = new StringBuilder();
                for (int j = 0; j < R; j++) {
                    col.append(puzzle[j].charAt(i));
                }
                //
                for (String split : col.toString().split("#")) {
                    if (split.length() >= 2) {
                        words.add(split);
                    }
                }
            }

            // 사전 순 오름차순 정렬
            words.sort(String::compareTo);
            System.out.println(words.get(0));


        }
    }