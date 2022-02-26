package Programmers.Lv2;

public class 삼각달팽이 {
    static int result[][]; // 결과를 저장할 좌표
    static int N;   // 범위
    static int idx; // result에 1부터 넣기 위한 전역 변수
    static int[] dx = {1,0,-1}, dy = {0,1,-1};  // 방향 좌표
    public int[] solution(int n) {
        int[] answer = {};
        int size = 0;
        N = n;
        for(int i=1; i<=n; i++){
            size += i;
        }
        idx = 2; // 1부터 좌표를 할당하므로
        
        result = new int[n][n];
        answer = new int[size]; // return 할 정답 배열
        
        result[0][0] = 1; // 처음 좌표 1로 만들기
        
        check(0,0,0);
        
        getAnswer(answer);
        return answer;
    }
    /**
     * 
     * @param r 행 좌표
     * @param c 열 좌표
     * @param dir 현재 진행 할 방향
     */
    private void check(int r, int c, int dir){
        boolean endCheck = false;
        while(true){
            if(outCheck(r,c,dir)) break;
            if(result[r+dx[dir]][c+dy[dir]]!=0){ // 해당 방향은 끝
                break;
            }else{ // 해당 방향으로 이동해야 하는 경우
                r += dx[dir];   // 해당 방향으로 이동하기
                c += dy[dir];
                result[r][c] = idx++; // 값 넣어주기
                endCheck = true;            
            }            
        }
        if(endCheck){ // 해당 방향으로 이동을 1번이라도 한 경우
            check(r,c,(dir+1)%3);
        }else return;
    }
    /**
     * 범위 밖으로 넘어가는지 체크
     * @param r 행
     * @param c 열
     * @param dir 방향
     * @return
     */
    private boolean outCheck(int r, int c, int dir){ 
        int tmpR = r+dx[dir];
        int tmpC = c+dy[dir];
        if(tmpR<0||tmpR>=N||tmpC<0||tmpC>=N) return true;
        return false;
    }
    /**
     * result를 answer 배열에 옮겨 담기
     * @param answer 정답 배열
     */
    private void getAnswer(int[] answer){
        int index = 0;
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(result[i][j]==0) continue;
                answer[index++] = result[i][j];
            }
        }
    }
}
// https://programmers.co.kr/learn/courses/30/lessons/68645