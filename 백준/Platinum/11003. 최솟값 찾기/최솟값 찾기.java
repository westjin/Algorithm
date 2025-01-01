

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); //데이터 개수
        int L = Integer.parseInt(st.nextToken()); //최솟값을 구하는 범위
        st = new StringTokenizer(br.readLine());
        Deque<Node> mydeque =new LinkedList<>();
        for (int i = 0; i < N; i++) {
            int now = Integer.parseInt(st.nextToken());
            //새로운 값이 들어올 때마다 정렬 대신 현재 수보다 큰 값을 덱에서 제거하자
            //왜? 시간복잡도를 줄이려고!

            while (!mydeque.isEmpty() && mydeque.getLast().value > now){
                mydeque.removeLast();
            }
            mydeque.addLast(new Node(now,i));
            if(mydeque.getFirst().index <= i - L) { //i는 새로 들어온 인덱스 L은 슬라이딩 윈도우.
                //새로 들어온 인덱스를 기준으로 슬라이딩 윈도우의 범위에서 벗어난다면 기존에 있던 인덱스는 버리기
            mydeque.removeFirst();
            }
            bw.write(mydeque.getFirst().value+ " ");
        }
        bw.flush();
        bw.close();
    }
    static class Node{
        public int value;
        public int index;

        Node(int value, int index){
            this.value = value;
            this.index = index;
        }
    }
}
