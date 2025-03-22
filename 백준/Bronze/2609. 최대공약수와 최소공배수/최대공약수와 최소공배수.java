

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int gcd = GCD(A,B);
        int lcm = LCM(A, B, gcd);

        System.out.println(gcd);
        System.out.println(lcm);
    }
    
    public static int GCD(int A, int B){
       while (B != 0){
           int temp = A % B;
           A = B;
           B = temp;
       }
       return A;
    }
    
    public static int LCM(int A,int B,int gcd){
        return (A * B)/gcd;
    }

}
