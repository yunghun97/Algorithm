package BackJun.Gold;

import java.io.*;
import java.util.*;
public class G2구슬탈출2DFS_13460 {
    static int R,C,answer;
    static int[] dx = {-1,0,1,0}, dy = {0,1,0,-1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        char[][] map = new char[R][C];
        Red red = new Red(0,0);
        Blue blue = new Blue(0,0);
        for(int i=0; i<R; i++){
            String input = br.readLine();
            for(int j=0; j<C; j++){
                char tmp = input.charAt(j);
                if(tmp=='R'){
                    red.r = i;
                    red.c = j;
                }
                if(tmp=='B'){
                    blue.r = i;
                    blue.c = j;
                }
                map[i][j] = tmp;
            }
        }
        answer = Integer.MAX_VALUE;
        DFS(map,1,-10, red, blue);
        if(answer==Integer.MAX_VALUE) bw.write(""+(-1));
        else bw.write(""+answer);
        bw.flush();
    }

    private static void DFS(char[][] map, int time, int dir, Red red, Blue blue) {
        if(time==11) return;
        if(time>answer) return; // 정답보다 더 크면 백트래킹
        for(int d=0; d<4; d++){ 
            // System.out.println(blue.r+ " "+ blue.c);
            boolean redWall = redWallCheck(map, red, d);    // 옆에 벽 체크 벽이면 true 리턴
            boolean blueWall = blueWallCheck(map, blue, d);
            if(redWall&&blueWall) continue; // 둘다 벽이면 진행 x

            char[][] copyMap = copyArr(map);    // DFS 용 데이터 복사
            Red tempRed = new Red(red.r, red.c);
            Blue tempBlue = new Blue(blue.r, blue.c);

            int firstBall = 0;  // 0이면 이동순서 ㄴ상관 1이면 blue먼저 2면 red먼저
            firstBall = firstCheck(copyMap,tempRed,d);
            // System.out.println("firstBall : "+ firstBall +" 방향 : "+d +" time : "+ time);
            
            // 변수들 선언
            boolean finishRed = false;
            boolean finishBlue = false;
            int Rr = tempRed.r;
            int Rc = tempRed.c;
            int Br = tempBlue.r;
            int Bc = tempBlue.c;
            boolean check1 = false;
            boolean check2 = false;
            if(firstBall==1){ // blue 먼저 그 다음 red 한칸 씩 이동    
                while(true){
                    if(check1&&check2) break;
                    if(!check1){
                        Br += dx[d];
                        Bc += dy[d];
                        if(copyMap[Br][Bc]=='#'){   // blue는 레드보다 앞 이라서 벽만 탐색
                            tempBlue.r = Br-dx[d];  // 새 좌표 저장ㄴ
                            tempBlue.c = Bc-dy[d];
                            copyMap[tempBlue.r][tempBlue.c] = 'B';
                            check1 = true;
                        }else if(copyMap[Br][Bc]=='O'){ // 어짜피 바로 끝나니까 break;
                            finishBlue = true;
                            break;
                        }else{
                        copyMap[Br-dx[d]][Bc-dy[d]] = '.';  // 1칸씩 이동 후 그 전좌표 .으로 만들기
                        copyMap[Br][Bc] = 'B';
                        }
                    }
                    if(!check2){
                        Rr += dx[d];
                        Rc += dy[d];
                        if(copyMap[Rr][Rc]=='#'||copyMap[Rr][Rc]=='B'){   // 앞에 벽,B일 때 정지
                            tempRed.r = Rr-dx[d];
                            tempRed.c = Rc-dy[d];
                            copyMap[tempRed.r][tempRed.c] = 'R';
                            check2 = true;
                        }else if(copyMap[Rr][Rc]=='O'){ // O면 골인 후 그 전좌표 .으로 만들기 
                            finishRed = true;
                            copyMap[Rr-dx[d]][Rc-dy[d]]='.';
                            check2 = true;
                        }else{
                            copyMap[Rr-dx[d]][Rc-dy[d]] = '.';
                            copyMap[Rr][Rc] = 'R';
                        }
                    }
                }
            }else{  // red먼저 이동 후 B 이동
                while(true){
                    if(check1&&check2) break;
                    if(!check2){
                        Rr += dx[d];
                        Rc += dy[d];
                        if(copyMap[Rr][Rc]=='#'||copyMap[Rr][Rc]=='B'){ // 앞에 B가 있을 경우 포함 이동
                            tempRed.r = Rr-dx[d];
                            tempRed.c = Rc-dy[d];
                            copyMap[tempRed.r][tempRed.c] = 'R';
                            check2 = true;
                        }else if(copyMap[Rr][Rc]=='O'){ // 골인 후 이전 좌표 .으로 만들기
                            finishRed = true;
                            copyMap[Rr-dx[d]][Rc-dy[d]]='.';
                            check2 = true;
                        }else{
                            copyMap[Rr-dx[d]][Rc-dy[d]] = '.';
                            copyMap[Rr][Rc] = 'R';
                        }
                    }
                    if(!check1){
                        Br += dx[d];
                        Bc += dy[d];
                        if(copyMap[Br][Bc]=='#'||copyMap[Br][Bc]=='R'){ // B앞에 R일 경우 고려
                            tempBlue.r = Br-dx[d];
                            tempBlue.c = Bc-dy[d];
                            copyMap[tempBlue.r][tempBlue.c] = 'B';
                            check1 = true;
                        }else if(copyMap[Br][Bc]=='O'){ // B 들어가면 어짜피 끝나니까 바로 break;
                            finishBlue = true;
                            break;
                        }else{
                            copyMap[Br-dx[d]][Bc-dy[d]] = '.';
                            copyMap[Br][Bc] = 'B';
                        }
                    }
                }
            }
            if(finishBlue) continue; // 파란색이 들어 갔으니까 더 진행 X
            if(finishRed){  // 빨간색이 들어갔으니까 더 탐색 X 밑 answer값 세팅
                answer = Math.min(time, answer);
                return;
            }
            if(tempRed.r==red.r&&tempRed.c==red.c&&tempBlue.r==blue.r&&tempBlue.c==blue.c) continue;
            DFS(copyMap, time+1, d, tempRed, tempBlue);
        } // d for문
    }
    private static int firstCheck(char[][] copyMap, Red tempRed, int dir) {  // 누가 먼저 갈지 우선순위 체크
        int nr = tempRed.r+dx[dir];
        int nc = tempRed.c+dy[dir];    
        if(copyMap[nr][nc]=='B') return 1;
        else return 2;
    }


    private static char[][] copyArr(char[][] map) {
        char[][] temp = new char[R][C];
        for(int i=0; i<R; i++){
            System.arraycopy(map[i], 0, temp[i], 0, C);
        }
        return temp;
    }

    private static boolean blueWallCheck(char[][] map, Blue tempBlue, int d) {  // 파랑 바로 앞이 벽인지 체크
        int nr = tempBlue.r + dx[d];
        int nc = tempBlue.c + dy[d];
        if(map[nr][nc]=='#') return true;
        return false;
    }

    private static boolean redWallCheck(char[][] map, Red tempRed, int d) {     // 빨강 바로 앞이 벽인지 체크
        int nr = tempRed.r + dx[d];
        int nc = tempRed.c + dy[d];
        if(map[nr][nc]=='#') return true;
        return false;
    }

    static class Red{
        int r;
        int c;
        public Red(int r, int c){
            this.r = r;
            this.c = c;
        }

    }
    static class Blue{
        int r;
        int c;
        public Blue(int r, int c){
            this.r = r;
            this.c = c;
        }

    }
}
// https://www.acmicpc.net/problem/13460