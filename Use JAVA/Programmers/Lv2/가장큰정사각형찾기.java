package Programmers.Lv2;

public class 가장큰정사각형찾기 {
    public int solution(int [][]board)
    {
        int answer = 0;
        int[][] dp = new int[board.length+1][board[0].length+1];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                dp[i+1][j+1] = board[i][j];
            }
        }
    
        // 해당값이 1인 경우 dp 왼쪽, 왼쪽대각선, 위에가 다 같은 값이면 +1 길이의 정사각형 생성 가능
        // 다르다면 가장 작은 값에서 +1 해주면 된다.
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                if(dp[i][j]==1){
                    int left = dp[i][j-1];
                    int up = dp[i-1][j];
                    int diagonal = dp[i-1][j-1];
                    dp[i][j] = Math.min(left,Math.min(up,diagonal))+1;
                    answer = Math.max(answer,dp[i][j]);
                }                
            }
        }                
        return answer*answer;
    }
}
// https://programmers.co.kr/learn/courses/30/lessons/12905