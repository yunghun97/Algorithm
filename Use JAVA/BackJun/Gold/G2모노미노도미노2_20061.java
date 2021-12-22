package BackJun.Gold;

import java.io.*;
import java.util.*;

// 1 : 1*1  2 : 1*2(가로) 3 : 2:1(세로)
public class G2모노미노도미노2_20061 {
    static int answer, blockCount;
    static boolean[][] RightMap, DownMap;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;


        RightMap = new boolean[4][6];
        DownMap = new boolean[6][4];
        answer = 0;
        int order = Integer.parseInt(br.readLine());
        for(int i=0; i<order; i++){
            st = new StringTokenizer(br.readLine());            
            setBlock(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));   // 블록 위치 탐색 후 추가         
            scoreCheck();   // score 탐색하고 추가 및 이동
            MapCheck(); // 0,1 칸 탐색하고 밀기
        }
        blockCount =0;
        checkBlockCount();
        bw.write(""+answer+"\n"+blockCount);
        bw.flush();
    }

    private static void checkBlockCount() {
        for(int r=0; r<4; r++){
            for(int c=2; c<6; c++){
                if(RightMap[r][c]) blockCount++;
            }
        }
        for(int c=0; c<4; c++){
            for(int r=2; r<6; r++){
                if(DownMap[r][c]) blockCount++;
            }
        }
    }

    // 열 행 검사해서 점수 추가하기
    private static void scoreCheck() {
        for(int c=5; c>=2; c--){
            int count = 0;
            for(int r=0; r<4; r++){
                if(RightMap[r][c]) ++count;
                else break;
            }
            if(count==4){  // score 획득하는 경우 c = 5 일때 5 = 4 , 4 = 3으로 한칸 씩 당기기
                setMap(1, 1, c);    // 맵 종류, 카운트 개수, score 발생하는 열 전달
                c++;    // 한칸 씩 당겼으므로 c++해서 다시 그 줄 부터 탐색
                answer++;
            }
        }


        for(int r=5; r>=2; r--){
            int count =0;
            for(int c=0; c<4; c++){
                if(DownMap[r][c]) ++count;
                else break;
            }
            if(count==4){   // 위에 c에서 map과 c가 r로 바뀐 형태
                setMap(2, 1, r);        
                r++;
                answer++;
            }            
        }
    }

    // 넣을 위치 탐색 및 블럭 위치시키는 메소드
    private static void setBlock(int block, int startR, int startC) {
        if(block==1){
            check(startR, startC);            
        }else if(block==2){ // 가로 긴거 c+1
            check(block, startR, startC);
        }else{  // 세로로 긴거 r+1
            check(block, startR, startC);
        }
    }    
    
    private static void check(int r, int c){     // 1*1 블록   
        
        for(int i=0; i<=6; i++){
            if(i==6||RightMap[r][i]){
                RightMap[r][i-1] = true;
                break;
            }
        }

        for(int i=0; i<=6; i++){
            if(i==6||DownMap[i][c]){
                DownMap[i-1][c] = true;
                break;
            }
        }        
        return;
    }
    private static void check(int block, int r, int c){ // 1*2 2*1 블록 추가하기
        if(block==2){
            for(int i=2; i<=6; i++){ // 오른쪽으로 긴거
                if(i==6||RightMap[r][i]){
                    RightMap[r][i-1] = true;
                    RightMap[r][i-2] = true;
                    break;
                }
            }
            for(int i=2; i<=6; i++){
                if(i==6||DownMap[i][c]||DownMap[i][c+1]){
                    DownMap[i-1][c] = true;
                    DownMap[i-1][c+1] = true;
                    break;
                }
            }
        }else{ // 세로 블록
            for(int i=2; i<=6; i++){
                if(i==6||RightMap[r][i]||RightMap[r+1][i]){
                    RightMap[r][i-1] = true;
                    RightMap[r+1][i-1] = true;
                    break;
                }
            }
            for(int i=2; i<=6; i++){
                if(i==6||DownMap[i][c]){
                    DownMap[i-1][c] = true;
                    DownMap[i-2][c] = true;
                    break;
                }
            }
        }
        return;
    }
    
    // 0,1 쪽 체크해서 제거하는 부분
    private static void MapCheck() {
        int count =0;
        for(int i=0; i<2; i++){ // 탐색
            int tmp =0;
            for(int j=0; j<4; j++){
                if(RightMap[j][i]){
                    tmp++;
                    break;
                }
            }
            if(tmp!=0) count++; // 한칸이라도 존재
        }
        if(count>0){
            for(int i=5; i>5-count; i--){
                for(int j=0; j<4; j++){
                    RightMap[j][i] = false;
                }
            }
            setMap(1,count);
        }
        count = 0;
        for(int i=0; i<2; i++){ // 탐색
            int tmp = 0;
            for(int j=0; j<4; j++){                
                if(DownMap[i][j]){
                    tmp++;
                    break;
                }
            }
            if(tmp!=0) count++; // 한칸이라도 존재
        }
        if(count>0){
            for(int i=5; i>5-count; i--){
                for(int j=0; j<4; j++){
                    DownMap[i][j] = false;
                }
            }         
            setMap(2,count);   
        }
    }
    // 블록 오른쪽에서 왼쪽 탐색 및 아래에서 위로 탐색해서 블록 정위치 시키기   0,1에서 지워질 때 사용
    private static void setMap(int mapKind, int count) {    // 맵 종류, 몇 줄을 지우고 댕겨야 할지
        if(mapKind==1){
            for(int r=0; r<4; r++){                    
                for(int c=5; c>=2; c--){
                    RightMap[r][c] = RightMap[r][c-count];
                    RightMap[r][c-count] = false;
                }
            }
        
        }
        else{
            for(int c=0; c<4; c++){
                for(int r=5; r>=2; r--){
                    DownMap[r][c] = DownMap[r-count][c];
                    DownMap[r-count][c]=false;
                }
            }
        }
    }
    // score 체크하다가 사용
    private static void setMap(int mapKind, int count, int num) {
        if(mapKind==1){   // 오른쪽 맵일 경우
            for(int r=0; r<4; r++){
                for(int c=num; c>=2; c--){
                    RightMap[r][c] = RightMap[r][c-count];
                    RightMap[r][c-count] = false;
                }
            }
        }else{
            for(int c=0; c<4; c++){ // 아래에 있는 맵일 경우
                for(int r=num; r>=2; r--){
                    DownMap[r][c] = DownMap[r-count][c];
                    DownMap[r-count][c]=false;
                }
            }
        }
    }

}
//https://www.acmicpc.net/problem/20061