package SamSungSwExpert.D4;

import java.util.StringTokenizer;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.OutputStreamWriter;
public class 정사각형방 {
    static int[][] map;
    static int[] dx = {-1,0,0,1}, dy = {0,-1,1,0};
    static boolean[][] isSelected;
    static int now, roomNumber, answer,size, count;
    public static void main(String[] args) throws IOException{
                System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\SWExpert\\D4\\정사각형방.txt"));
                BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
                StringTokenizer st;

                int T= Integer.parseInt(br.readLine());
                for(int t=1; t<=T; t++){
                size = Integer.parseInt(br.readLine());                
                map = new int[size][size];
                isSelected = new boolean[size][size];
                for(int i=0; i<size; i++){
                    st =new StringTokenizer(br.readLine());
                    for(int j=0; j<size; j++){
                        map[i][j] = Integer.parseInt(st.nextToken());
                    }
                }
                int answerCount = Integer.MIN_VALUE;
                count =1;
                for(int r=0; r<size; r++){
                    for(int c=0; c<size; c++){      // 모든 칸 계산하기
                        move(r, c);
                        if(count>answerCount){      // 카운트가 더 크면 현재 방의 번호를 저장하고 count를 저장한다.
                            roomNumber = map[r][c];
                            answerCount = count;
                        }
                        else if(count==answerCount){    // 같으면 방 번호 크기만 비교한다.
                            if(roomNumber>map[r][c]){
                                roomNumber = map[r][c];
                            }
                        }
                        count =1;
                    }
                }
                bw.write("#"+t+" "+roomNumber+" "+answerCount+"\r\n");  // 쓰기
                bw.flush();
            }// 테케 끝
            bw.close();
    }//메인 끝
    private static void move(int R, int C){
            for(int d=0; d<4; d++){     // 사방탐색
                    int nr = R+dx[d];
                    int nc = C+dy[d];                    
                    if(nr>=0&&nr<size&&nc>=0&&nc<size){ // 배열 범위안에
                    if(map[nr][nc]-map[R][C]==1){   // 다음방은 무조건 +1만큼 커야되므로 이동한 순간 뒤에 방을 다시 건너갈 수 없는 상태가 된다. (괜히 검사할려고 했다...)
                        count++;
                        move(nr, nc);       // 만족하면 다시 재귀 호출
                    }
                    }
                    else{
                        continue;
                    }
           }
    }
}
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5LtJYKDzsDFAXc&categoryId=AV5LtJYKDzsDFAXc&categoryType=CODE&problemTitle=%EC%A0%95%EC%82%AC%EA%B0%81%ED%98%95&orderBy=FIRST_REG_DATETIME&selectCodeLang=ALL&select-1=&pageSize=10&pageIndex=1