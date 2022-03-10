package SamSungSwExpert.모의역랑테스트;

import java.util.*;
import java.io.*;
// 운영 비용 : = K * K + (K-1) * (K-1)
public class 홈방범서비스_2117 {
    static int N, M, answer;    // N 배열 크기, M은 집이 지불하는 비용
    static boolean[][] map;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            map = new boolean[N][N];
            answer = 0;
            int count = 0;
            for(int r = 0; r < N; r++){
                st = new StringTokenizer(br.readLine());
                for(int c = 0; c< N; c++){
                    if(Integer.parseInt(st.nextToken())==1){
                        map[r][c] = true;
                        count++;
                    }
                }
            }
            int maxCost = count * M;
            for(int r = 0; r < N; r++){
                for(int c = 0; c < N; c++){
                    for(int k =1; k<=21; k++){ // 21이 되면 가운데 지점에서 시작시 모든 점들을 탐색할 수 있다.
                        int cost = k * k + (k-1) * (k-1);
                        if(cost>maxCost) break;
                        int result = check(r, c, k);
                        if(result*M>=cost) answer = Math.max(answer, result);   // 수익이 운영비용 이상일 경우 answer 새로 할당
                    }
                }
            }
            bw.write("#"+t+" "+answer+"\n");
        } // 테케 끝
        bw.flush();
    }
    /**
     * 
     * @param r 행
     * @param c 열
     * @param size k 값
     * @return 집의 개수
     */
    private static int check(int r, int c, int size) {
        int len = size * 2 - 1;
        int startR = r - size +1;
        int startC = c - size +1;    
        int result = 0;

        int tmp1 = size;
        int tmp2 = -1;
        int idx = 0;
        boolean max = false;
        for(int i = startR; i < startR+len; i++){
            if(!max){
                tmp1--;
                tmp2 += 2;
                idx++;
            }else{
                tmp1++;
                tmp2 -= 2;
            }            
            for(int j = startC+tmp1; j<startC+tmp1+tmp2; j++){
                if(possibleCheck(i,j)){
                    result++;
                }
            }
            if(idx==size) max = true;
        }
        return result;
    }
    /**
     * 
     * @param i 행
     * @param j 열
     * @return  true : 해당좌표에 집이 있음 false : 범위 밖이거나 집이 없음
     */
    private static boolean possibleCheck(int i, int j) {
        if(i<0||i>=N||j<0||j>=N||!map[i][j]) return false;
        return true;
    }   
}
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V61LqAf8DFAWu&