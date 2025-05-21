class Solution {
    public static String solution(int[] numbers, String hand){
        StringBuilder answer = new StringBuilder();
        // 1. 손 위치 초기화하기
        Position left = new Position(3,0);
        Position right = new Position(3,2);
        Position numPos;

        for (int num : numbers) {
            // 2. 숫자를 누를 손가락 정하기
            numPos = new Position((num - 1) / 3,(num - 1) % 3);
            if(num == 0){
                numPos = new Position(3,1);
            }
            String finger = numPos.getFinger(hand,left,right);
            // 3.정해진 손가락을 answer에 담고 손가락 위치 이동
            answer.append(finger);
            //손가락 위치 이동
            if(finger.equals("L")){
                left = numPos;
            }else {
                right = numPos;
            }
        }
        return answer.toString();
    }

    static class Position{
        int row;
        int col;

        Position(int row, int col){
            this.row = row;
            this.col = col;
        }

        public String getFinger(String hand, Position left, Position right){
            String finger = hand.equals("right")? "R":"L";

            if (this.col == 0){
                finger = "L";
            } else if (this.col == 2) {
                finger = "R";
            }
            else {
                int leftDist = left.getDistance(this);
                int rightDist = right.getDistance(this);

                if(leftDist < rightDist)
                    finger = "L";
                else if(leftDist > rightDist)
                    finger = "R";
            }

            return finger;
        }

        public int getDistance(Position p){
            int distance = Math.abs(this.row - p.row) + Math.abs(this.col - p.col);
            return distance;
        }

    }
    
}