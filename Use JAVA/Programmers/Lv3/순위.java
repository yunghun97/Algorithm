package Programmers.Lv3;

public class 순위 {
    public static void main(String[] args) {
        int n = 5;        
        int[][] tmp = {{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}};
        solution(n,tmp);
    }
    private static int solution(int n, int[][] results) {
        
        boolean[][] game =  new boolean[n][n];
        int answer = 0;
            
        for(int i=0; i<results.length; i++){ 
            game[results[i][0]-1][results[i][1]-1]=true; 
        }
    
        for(int i=0; i<n; i++){ // 플로이드 와샬
            for(int j=0; j<n; j++){
                for(int k=0; k<n; k++){
                    if(game[j][i]&&game[i][k]){
                        game[j][k]=true;
                    }
                }
            }
        }
        
        for(int i=0; i<n; i++){ // 해당 점이 매치를 진행 했을 때 마다 +1
            int result=0;
            for(int j=0; j<n; j++){
                if(game[i][j] || game[j][i]){
                    result++;
                }
            }
            if(result==n-1){ // 해당 선수가 게임을 n-1번 진행하여 순위를 알 수 있게 되는 경우
                answer++;
            }
        }
        return answer;
        }
}
// https://programmers.co.kr/learn/courses/30/lessons/49191