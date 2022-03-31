package Programmers.Lv3;

public class 파괴되지않은건물 {
    static int R, C;
    static int[][] map;
    public int solution(int[][] board, int[][] skill) {
        R = board.length;
        C = board[0].length;
        map = new int[R][C];
        for(int i =0; i <skill.length; i++){
            setSkill(skill[i][0],skill[i][1],skill[i][2],skill[i][3],skill[i][4],skill[i][5]);
        }
        for(int r=0; r<R; r++){ // 오른쪽 누적합
            rightSum(r,0,0);   
        }
        for(int c=0; c<C; c++){ // 아래로 누적 합
            downSum(0,c,0);
        }
        int answer = lastSum(board);
        
        return answer;
    }
    public void setSkill(int type, int r1, int c1, int r2, int c2, int degree){
        if(type==1) degree *= -1;
        map[r1][c1] += degree;
        
        setLastArea(r1,c2+1,degree);
        setLastArea(r2+1,c1,degree);
        setLastArea(r2+1,c2+1,-degree); // 오른쪽으로 +할 떄 r2+1, c1에서 누적합 된 값이 r2+1, c2+1에 저장되어 있으므로 그 반대 값을 넣어 저장되지 않게 한다.
    }
    public void setLastArea(int r, int c, int degree){
        if(outCheck(r,c)) return;
        map[r][c] += degree*-1;
    }
    public boolean outCheck(int r, int c){
        if(r>=R||c>=C) return true;
        else return false;
    }
    public void rightSum(int r, int c, int degree){
        if(outCheck(r,c)) return;
        map[r][c] += degree;
        rightSum(r,c+1, map[r][c]);
    }
    public void downSum(int r, int c, int degree){
        if(outCheck(r,c)) return;
        map[r][c] += degree;
        downSum(r+1,c, map[r][c]);
    }
    public int lastSum(int[][] board){
        int result = 0;
        for(int r=0; r<R; r++){
            for(int c=0; c<C; c++){
                map[r][c] += board[r][c];
                if(map[r][c]>=1) result++; // 건물이 살아있으면 +1
            }
        }
        return result;
    }
}
// https://programmers.co.kr/learn/courses/30/lessons/92344