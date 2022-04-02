package Programmers.Lv2;

public class 행렬테두리회전하기 {
    static int R, C, MIN;
    static int[][] map;
    static int[] answer;
    static int[] dx = {0,1,0,-1}, dy = {1,0,-1,0};
    public static void main(String[] args) {
        int a =6;
        int b= 6;
        int[][] arr = new int[][]{{2,2,5,4},{3,3,6,6},{5,1,6,3}};
        solution(a, b, arr);
    }
    public static int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = {};
        R = rows;
        C = columns;
        map = new int[R][C];
        int idx = 1;
        for(int i=0; i<R; i++){
            for(int j=0; j<C; j++){
                map[i][j] = idx++;
            }
        }
        answer = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            int x1 = queries[i][0]-1;
            int y1 = queries[i][1]-1;
            int x2 = queries[i][2]-1;
            int y2 = queries[i][3]-1;
            MIN = Integer.MAX_VALUE;
            rotate(map[x1+1][y1],x1,y1,0,x1,y1,x2,y2);
            answer[i] = MIN;
        }
        return answer;
    }
    public static void rotate(int number, int nowR, int nowC, int dir, int x1, int y1, int x2, int y2){
        if(MIN!=Integer.MAX_VALUE&&nowR==x1&&nowC==y1){ // 끝난 경우
            return;
        }
        int nr = nowR + dx[dir];
        int nc = nowC + dy[dir];
        if(nr<x1||nr>x2||nc<y1||nc>y2){ // 범위를 벗어나는 경우
            rotate(number, nowR, nowC, dir+1, x1, y1, x2, y2);
        }else{
            MIN = Math.min(MIN, map[nowR][nowC]);
            int tmpNumber = map[nowR][nowC];
            map[nowR][nowC] = number;
            rotate(tmpNumber, nr, nc, dir, x1, y1, x2, y2);
        }
    }
}
