import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder stringBuilder = new StringBuilder();

        String start = bufferedReader.readLine();
        String target = bufferedReader.readLine();

        for (int i = 0; i < start.length(); i++) {
            stringBuilder.append(start.charAt(i));
            if(stringBuilder.length() >= target.length()){
                // 1. 끝부분이 target과 같은지 확인 (charAt 비교)
                boolean isSame = true;
                for (int j = 0; j < target.length(); j++) {
                    if (stringBuilder.charAt(stringBuilder.length() - target.length() + j) != target.charAt(j) ) {
                        isSame = false;
                        break;
                    }
                }
                // 2. 같다면 delete로 폭발 처리
                if (isSame){
                    stringBuilder.delete(stringBuilder.length() - target.length(),
                        stringBuilder.length());
                }
            }



        }


        if (stringBuilder.length() == 0){
            System.out.println("FRULA");
        }else {
            System.out.println(stringBuilder.toString());
        }




    }

}
