package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G1어항정리_23291 {
    static int N, K;
    static int[][] arr;
    static int[] dx = {-1,0,0,1}, dy = {0,-1,1,0};
    static boolean[][] isVisited;
    static Queue<Integer> q;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        arr = new int[N][N];
        isVisited = new boolean[N][N];
        q = new LinkedList<>();

        for(int i=0; i<N; i++){
            arr[N-1][i] = Integer.parseInt(st.nextToken());
        }
        int answer = 1;
        while(true){
            plus();
            bloc();   
            fishSet();            
            // print();         
            reset();
            // print();         
            half();
            // print();         
            fishSet();
            // print();         
            reset();
            // print();         
            if(check()) break;
            ++answer;
        }
        bw.write(""+answer);
        bw.flush();
    }
    
    private static void half() {    // 반으로 2번 나누는 코드
        int half = N/2;
        for(int i=0; i<half; i++){
            arr[N-1-1][N-1-i] =arr[N-1][i];
            arr[N-1][i] = 0;
        }    
        // print();    
        int size = half/2;
        for(int r=N-1; r>=N-2; r--){
            for(int c=half; c<half+size; c++){                
                arr[N-5 + (int) Math.abs(r-N)][N-1 - (int) Math.abs(half-c)] = arr[r][c];
                arr[r][c] = 0;
            }
        }
        // print();
    }
    private static void reset() {   // 다시 1행으로 깔아주기
        
        for (int c = 0; c < N; c++) {
            for (int r = N - 1; r >= 0; r--) {
                if(arr[r][c]!=0){
                    q.add(arr[r][c]);
                    arr[r][c] = 0;
                }
            }
        }
        int idx = 0;
        while(!q.isEmpty()){
            arr[N-1][idx++] = q.poll();
        }
    }

    private static void fishSet() { // 물고기 세팅
        int[][] tmpArr = new int[N][N];
        for(int i=0; i<N; i++) Arrays.fill(isVisited[i], false);
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(arr[i][j]!=0){
                    isVisited[i][j] = true;
                    for(int d=0; d<4; d++){
                        int nr = i+dx[d];
                        int nc = j+dy[d];
                        if(nr<0||nr>=N||nc<0||nc>=N||arr[nr][nc]==0||isVisited[nr][nc]) continue;
                        int tmp = (int) Math.abs(arr[i][j]-arr[nr][nc])/5;
                        if(tmp==0) continue;
                        if(arr[i][j]>arr[nr][nc]){
                            tmpArr[i][j] -=tmp;
                            tmpArr[nr][nc]+=tmp;
                        }else if(arr[nr][nc]>arr[i][j]){
                            tmpArr[i][j] +=tmp;
                            tmpArr[nr][nc]-=tmp;
                        }
                    }
                }
            }
        }
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(tmpArr[i][j]==0) continue;
                arr[i][j]+=tmpArr[i][j];
            }
        }

    }
    private static void print(){    // 배열 출력 : 디버깅 용
        System.out.println("******배열 출력*****");
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }
    }
    private static void bloc() {    // 옆으로 블록처리
        
        // 11 21 22 32 33 43
        int pivot, R, C;
        pivot = 0;
        R = C = 1;
        int level = 0;
        while(true){
            if(pivot-1+R+C>=N) break;
            for(int r=N-1; r>N-1-R; r--){
                for(int c=pivot; c<pivot+C; c++){
                    int nc = (int) Math.abs(N-1-r);
                    arr[N-1-pivot-C+c][pivot+C+nc] = arr[r][c];             
                    arr[r][c] = 0;
                }
            }
            // print();
            pivot+=C;
            if(level%2==0) R++;
            else C++;
            level++;
        }

    }
    private static void plus() {    // 최소값 +1 해주기
        int min = Integer.MAX_VALUE;
        for(int i=0; i<N; i++){
            if(arr[N-1][i]<min){
                min = arr[N-1][i];
            }
        }
        for(int i=0; i<N; i++){
            if(arr[N-1][i]==min){
                arr[N-1][i]++;
            }
        }
        
    }
    private static boolean check() {    // 끝인지 아닌지 체크
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++){
            if(arr[N-1][i]>max) max = arr[N-1][i];
            if(arr[N-1][i]<min) min = arr[N-1][i];
        }
        // print();
        if(max-min<=K) return true;
        return false;
    }    
}
// https://www.acmicpc.net/problem/23291