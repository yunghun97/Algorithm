package Programmers.Lv3;

public class 등굣길 {
    public int solution(int c, int r, int[][] puddles) {
        // 행과 열이 반대로 입력되어 있다.
        int mod = 1000000007;
        
        int[][] board = new int[r][c];
        for(int i = 0; i < puddles.length; i++) {
            board[puddles[i][1]-1][puddles[i][0]-1] = -1;  // 물 웅덩이 좌표 -1로 만들어 주기
        }
        
        board[0][0] = 1; // 집의 위치 1로 세팅
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(board[i][j] == -1) continue;
                if(i!=0){ // 제일 위의 행은 +할 위의 행이 없으므로
                    if(board[i-1][j]>0) board[i][j] += board[i - 1][j] % mod;   
                }
                if(j!=0){ // 제일 왼쪽 열은 +할 위의 행이 없으므로
                    if(board[i][j-1]>0) board[i][j] += board[i][j - 1] % mod; 
                }
                
            }
        }
        return board[r-1][c-1] % mod;
    }
}
// https://programmers.co.kr/learn/courses/30/lessons/42898