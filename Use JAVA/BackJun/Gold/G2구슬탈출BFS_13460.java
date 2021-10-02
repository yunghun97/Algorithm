package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G2구슬탈출BFS_13460 {
    static int R,C,answer;
    static char[][] map, tempMap;
    static int[] dx = {-1,0,0,1}, dy ={0,-1,1,0};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        tempMap = new char[R][C];
        Red red = new Red(0,0);
        Blue blue = new Blue(0,0);
        for(int i=0; i<R; i++){
            map[i] = br.readLine().toCharArray();
            for(int j=0; j<C; j++){
                if(map[i][j]=='R'){ 
                    red.r = i;
                    red.c = j;
                    map[i][j] = '.';
                }else if(map[i][j]=='B'){
                    blue.r = i;
                    blue.c = j;
                    map[i][j] = '.';
                }
            }
        }
        for(int i=0; i<R; i++){
            System.arraycopy(map[i], 0, tempMap[i], 0, C);  // temp배열에 R,C 제거한 초기값 대입
        }
        answer = 100;
        BFS(red, blue);
        if(answer==100) bw.write(""+(-1));
        else bw.write(""+answer);
        bw.flush();
        bw.close();
        br.close();
    }    
    static void BFS(Red red, Blue blue) {
        int result = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{red.r,red.c,blue.r,blue.c});    // int 배열 넣기
        while(!q.isEmpty()){
            int size = q.size();
            result++;
            if(result>=11) return;  // 11 이상이면 바로 종료
            for(int i=0; i<size; i++){
                int[] temp = q.poll();
                    int startRr = 0; 
                    int startRc = 0;
                    int startBr = 0;
                    int startBc = 0;
                for(int d=0; d<4; d++){
                    // System.out.println(temp[0] + " " + temp[1] + " " + temp[2] + " " + temp[3]);
                    boolean blueWallCheck = false;
                    boolean redWallCheck = false;
                    startRr = temp[0];  // 각 케이스마다 초기좌표 다시 설정
                    startRc = temp[1];
                    startBr = temp[2];
                    startBc = temp[3];
                    if(map[startRr+dx[d]][startRc+dy[d]]=='#') redWallCheck = true; // 바로 벽인지 체크
                    if(map[startBr+dx[d]][startBc+dy[d]]=='#') blueWallCheck = true;
                    if(redWallCheck&&blueWallCheck){    // 둘 다 바로 벽이면 더 계산 X
                        continue;
                    }
                    for(int x=0; x<R; x++){ // map 배열 초기화
                        System.arraycopy(tempMap[x], 0, map[x], 0, C);
                    }
                    
                    map[startRr][startRc] = 'R';    // 현재 좌표에 R C 넣기
                    map[startBr][startBc] = 'B';
                    
                    boolean redStart = true;    // 우선순위 비교
                    if(map[startRr+dx[d]][startRc+dy[d]]=='B') redStart = false;    // 바로 앞에 B이면 블루부터 시작 아니면 걍 레드부터 시작
                    boolean finishRed = false;
                    boolean finishBlue = false;
                    boolean check1 = false;
                    boolean check2 = false;
                        if(redStart){   // 빨강 부터
                            while(true){
                                if(check1&&check2) break;
                                if(!check1){    // 앞의 좌표 탐색 후 결정
                                    startRr +=dx[d];
                                    startRc +=dy[d];
                                    if(map[startRr][startRc]=='#'||map[startRr][startRc]=='B'){ // 앞에 B면 종료
                                        startRr -=dx[d];    // 그만 이동
                                        startRc -=dy[d];
                                        check1 = true;
                                    }else if(map[startRr][startRc]=='O'){   // O면 이동 전 좌표 .으로 만들고 그만 이동
                                        finishRed = true;
                                        check1 = true;
                                        map[startRr-dx[d]][startRc-dy[d]] = '.';
                                    }else{  // 앞에 . 이면 이동 후 이동좌표에 R 그 전 좌표 . 으로 만들기
                                        map[startRr-dx[d]][startRc-dy[d]] = '.';
                                        map[startRr][startRc] = 'R';
                                    }
                                }
                                if(!check2){
                                    startBr += dx[d];
                                    startBc += dy[d];
                                    if(map[startBr][startBc]=='#'||map[startBr][startBc]=='R'){
                                        startBr -= dx[d];
                                        startBc -= dy[d];
                                        check2 = true;
                                    }else if(map[startBr][startBc]=='O'){   // 어짜피 blue가 들어가면 끝나니까 true체크만 하고 바로 break;
                                        finishBlue = true;
                                        break;
                                    }else{
                                        map[startBr-dx[d]][startBc-dy[d]] = '.';
                                        map[startBr][startBc] = 'B';
                                    }
                                }
                            }
                        }else{  // 파랑 부터
                            while(true){
                                if(check1&&check2) break;
                                if(!check2){
                                    startBr += dx[d];
                                    startBc += dy[d];
                                    if(map[startBr][startBc]=='#'||map[startBr][startBc]=='R'){
                                        startBr -=dx[d];
                                        startBc -=dy[d];
                                        check2 =true;
                                    }else if(map[startBr][startBc]=='O'){   // 어짜피 blue가 들어가면 끝나니까 true체크만 하고 바로 break;
                                        finishBlue = true;
                                        break;
                                    }else{
                                        map[startBr-dx[d]][startBc-dy[d]] = '.';
                                        map[startBr][startBc] = 'B';
                                    }
                                }
                                if(!check1){
                                    startRr +=dx[d];
                                    startRc +=dy[d];
                                    if(map[startRr][startRc]=='#'||map[startRr][startRc]=='B'){
                                        startRr -=dx[d];
                                        startRc -=dy[d];
                                        check1 = true;
                                    }else if(map[startRr][startRc]=='O'){   
                                        finishRed = true;
                                        check1 = true;
                                        map[startRr-dx[d]][startRc-dy[d]] = '.';
                                    }else{
                                        map[startRr-dx[d]][startRc-dy[d]] = '.';
                                        map[startRr][startRc] = 'R';
                                    }
                                }
                            }
                        }// 계산 끝
                        if(finishBlue) continue;
                        if(finishRed){  // red가 들어가면 answer 저장 후 바로 종료
                            answer = result;
                            return;
                        }
                        if(startRr==temp[0]&&startRc==temp[1]&&startBr==temp[2]&&startBc==temp[3]) continue;    // 좌표가 변한게 없으면 q에 넣지 않는다.
                        q.add(new int[]{startRr,startRc,startBr,startBc});  // 변한좌표 큐에 넣기
                }
            }
        }
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