import java.util.Scanner;

public class Main {

    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        hanoi(N,1,3,2);
        System.out.println((int)Math.pow(2, N) - 1);
        System.out.println(sb);

    }
    private static void hanoi(int n, int from, int to, int aux){
        //N 원판 수
        // from 현재 기둥
        // to 목표
        // aux 보조
        if(n==1){
            sb.append(from + " "+to+"\n");
            return;
        }

        hanoi(n-1,from, aux, to);
        sb.append(from + " "+to+"\n");
        hanoi(n-1,aux,to,from);
    }


    }

