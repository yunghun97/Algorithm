package BackJun.Gold;

import java.io.*;
import java.util.*;

// x 배수 원판 k 돌리기
// 돌려서 인접같은거 지우기 and 없으면 평균 비교 후 +1, -1;
// d 0 은 시계 방향 1인 반시계 방향, k 는 몇칸
public class G3원판돌리기_17822 {
    static int N, M ,T; // N은 원판 개수, M은 원판안에 숫자 개수, T 회전명령 횟수
    static int[][] circle, copyCircle;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        circle = new int[N+1][M];
        copyCircle = new int[N+1][M];
        for(int i=1; i<=N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++){
                circle[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<T; i++){
            st = new StringTokenizer(br.readLine());
            move(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            check();
        }
        int answer = sum();
        bw.write(""+answer);
        bw.flush();
    }
    private static int sum() {  // 정답 합계 구하기
        int result = 0;
        for(int i=1; i<=N; i++){
            for(int j=0 ; j<M; j++){                
                result+=circle[i][j];
            }
        }
        return result;
    }
    private static void check() {   // 겹치는 수 체크
        copyMap();  // 맵 복사
        boolean removeCheck = false;    // 확인용
        for(int i=1; i<=N; i++){    // 원판안에서 확인
            for(int j=0; j<M; j++){
                if(circle[i][j]==0) continue;
                int left = j-1;
                if(left==-1) left = M-1;
                int right = j+1;
                if(right==M) right = 0;
                
                if(circle[i][j]==circle[i][left]){
                        copyCircle[i][j] = 0;
                        copyCircle[i][left] = 0;
                        removeCheck = true;
                }
                if(circle[i][j]==circle[i][right]){
                        copyCircle[i][j] = 0;
                        copyCircle[i][right] = 0;
                        removeCheck = true;
                }
            }
         }

        for(int j=0; j<M; j++){ // 원판밖에서 확인
            for(int i=1; i<N; i++){
                if(circle[i][j]==0) continue;
                if(circle[i][j]==circle[i+1][j]){
                    copyCircle[i][j] = 0;
                    copyCircle[i+1][j] = 0;
                    removeCheck = true;
                }

            }
        }
        for(int i=1; i<=N; i++) System.arraycopy(copyCircle[i], 0, circle[i], 0, M);    // 결과 복사
        if(!removeCheck) avg();
    }
    private static void avg() { // 평균 계산 및 체크
        double sum = 0;
        double count =0;
        for(int i=1; i<=N; i++){
            for(int j=0; j<M; j++){
                sum += circle[i][j];
                if(circle[i][j]!=0) count++;
            }
        }
        double avgerage = sum/count;
        for(int i=1; i<=N; i++){
            for(int j=0; j<M; j++){
                if(circle[i][j]==0) continue;
                else if(circle[i][j]>avgerage) circle[i][j]--;
                else if(circle[i][j]<avgerage) circle[i][j]++;
            }
        }
    }
    private static void copyMap() { // 임시 배열 복사
        for(int i=1; i<=N; i++){
            System.arraycopy(circle[i], 0, copyCircle[i], 0, M);
        }
        
    }
    private static void move(int num, int dir, int space) {
        for(int x=num; x<=N; x+=num){
            copy(x);
            if(dir==0){ // 시계방향
                for(int y=0; y<M; y++){
                    int temp = y+space;
                    if(temp>=M) temp-=M;
                    circle[x][temp] = circle[0][y];
                }
            }  
            else{   // 반 시계방향
                for(int y=0; y<M; y++){
                    int temp = y-space;
                    if(temp<0) temp+=M;
                    circle[x][temp] = circle[0][y];
                }
            }
            
        }
    }
    private static void copy(int x) {   // 0번쨰에 원판 저장
        for(int i=0; i<M; i++){
            circle[0][i] = circle[x][i];
        }
    }
}
// https://www.acmicpc.net/problem/17822