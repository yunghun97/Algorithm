package BackJun.Gold;

import java.io.*;
import java.util.*;
public class G2색종이붙이기_17136 {
    static boolean[][] defaultMap, isVisited;
    static int[][] countMap;
    static int[] paper ;
    static int answer; 
    static boolean end;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        defaultMap = new boolean[10][10];
        isVisited = new boolean[10][10];
        countMap = new int[10][10];
        paper = new int[6];
        answer =  26;
        int paperCount = 0;
        Arrays.fill(paper, 5);
        for(int r = 0; r<10; r++){
            st = new StringTokenizer(br.readLine());
            for(int c=0; c<10; c++){
                int a = Integer.parseInt(st.nextToken());
                if(a==1){
                    defaultMap[r][c] = true;
                    paperCount++;
                }
            }
        }
        end = false;
        for(int r=0; r<10; r++){
            for(int c=0; c<10; c++){
                if(!defaultMap[r][c]) continue;
                outer : for(int x = 5; x>=1; x--){
                    int size = checkSize(r,c,x);
                    if(size!=0){
                        countMap[r][c] = size;
                        break outer;
                    }
                }
            }
        }
        check(0,0,0,paperCount) ;
        if(answer!=26)  bw.write(""+answer);
        else bw.write("-1");
        bw.flush();
    }
    /**
     * 
     * @param r 시작 행
     * @param c 시작 열
     * @param count 사용한 색종이 개수
     * @param remain 남은 색종이 총 개수
     */
    private static void check(int r, int c, int count, int remain) {
        if(count>=answer&&answer!=26) return;    // 이미 더 색종이를 많이 사용했거나 초기 상태가 아닌 경우 return
        if(remain==0){
            answer = Math.min(count,answer);
            end = true;
            return;
        }        
        if(defaultMap[r][c]&&!isVisited[r][c]){    // 해당 좌표에 색종이를 붙일 수 있는 경우
            for(int x=countMap[r][c]; x>=1; x--){   // 최대 값 부터 탐색한다.
                if(!possibleCheck(r,c,x)) continue; // 가능한지 체크
                if(paper[x]==0) continue;   // 해당 크기의 색종이를 쓸 수 없는 경우
                attach(r, c, x);    // 붙이기
                paper[x]--;
                if(c==9) check(r+1,0,count+1, remain-x*x);                        
                else check(r,c+1,count+1, remain-x*x);                        
                detach(r, c, x);
                paper[x]++;
            }
        }
        else{   // 해당 좌표에 색종이를 붙일 수 있는 경우
            if(c==9) check(r+1,0,count, remain);                        
            else check(r,c+1,count, remain);     
        }
        return;
    }    
    private static boolean possibleCheck(int R, int C, int x) {
        for(int r=R; r<R+x; r++){
            for(int c=C; c<C+x; c++){
                if(isVisited[r][c]||!defaultMap[r][c]) return false;
            }
        }
        return true;
    }
    /**
     * 색종이 붙이기
     * @param map 색종이를 붙일 Map
     * @param R 시작 행
     * @param C 시작 열
     * @param size 몇 칸 붙일 지 나타내는 size
     */
    private static void attach(int R, int C, int size) {   
        for(int r=R; r<R+size; r++){
            for(int c=C; c<C+size; c++){
                isVisited[r][c] = true;
            }
        }
    }
    /**
     * 색종이 때기
     * @param map 색종이를 붙일 Map
     * @param R 시작 행
     * @param C 시작 열
     * @param size 몇 칸 붙일 지 나타내는 size
     */
    private static void detach(int R, int C, int size) {   
        for(int r=R; r<R+size; r++){
            for(int c=C; c<C+size; c++){
                isVisited[r][c] = false;
            }
        }
    }
    /**
     * 붙일 수 있는 색종이 크기 구하기
     * @param r 시작 행
     * @param c 시작 열
     * @param size 몇 칸 붙일 지 나타내는 size
     */
    private static int checkSize(int r, int c, int size) {
        if(r+size-1>=10||c+size-1>=10) return 0;
        for(int i=r; i<r+size; i++){
            for(int j=c; j<c+size; j++){
                if(!defaultMap[i][j]) return 0;
            }
        }
    
        return size;
    }
}
// https://www.acmicpc.net/problem/17136