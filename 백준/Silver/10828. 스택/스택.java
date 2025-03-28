import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            String instruction = st.nextToken();
            switch (instruction) {
                case "push" :
                    int num = Integer.parseInt(st.nextToken());
                    stack.push(num);
                    break;


                case "top" :
                    if (stack.isEmpty()){
                        System.out.println(-1);
                    }
                    else System.out.println(stack.peek());
                    break;


                case "size" :
                    System.out.println(stack.size());
                    break;


                case "empty" :
                    if (stack.isEmpty()) {
                        System.out.println(1);
                    } else {
                        System.out.println(0);
                    }
                    break;


                case "pop" :
                    if (stack.isEmpty()){
                        System.out.println(-1);
                    }
                    else System.out.println(stack.pop());
                    break;

            }

        }

    }

}
