import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String signal = bufferedReader.readLine();

        //정규표현식
        String pattern = "(100+1+|01)+";

        if (signal.matches(pattern)){
            System.out.println("SUBMARINE");
        }
        else {
            System.out.println("NOISE");
        }



    }

}
