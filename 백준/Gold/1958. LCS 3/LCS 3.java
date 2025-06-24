import static java.lang.Math.max;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String a = bufferedReader.readLine();
        String b = bufferedReader.readLine();
        String c = bufferedReader.readLine();

        int[][][] LCS = new int[a.length()+1][b.length()+1][c.length()+1];

        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                for (int k = 1; k <= c.length(); k++) {
                    if(a.charAt(i-1) == b.charAt(j-1) && b.charAt(j-1) == c.charAt(k-1)){
                        LCS[i][j][k] =  LCS[i-1][j-1][k-1] + 1;
                    }else {
                        LCS[i][j][k] = max(
                            max(LCS[i-1][j][k], LCS[i][j-1][k])
                            ,LCS[i][j][k-1]);
                    }
                }
            }
        }

        System.out.println(LCS[a.length()][b.length()][c.length()]);




    }

}
