package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G2색종이붙이기_17136_노가다 {
    static boolean[][] defaultMap;
    static int[] paper ;
    static int answer; 
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        defaultMap = new boolean[10][10];
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
        
        check(defaultMap,paper,0,0,paperCount) ;
        if(answer!=26)  bw.write(""+answer);
        else bw.write("-1");
        bw.flush();
    }
    /**
     * 
     * @param map 색종이를 붙이는 map
     * @param arr 사용한 색종이 종류 저장
     * @param R   최근에 작업한 행 -> 최근에 작업한 행 이후로 탐색
     * @param count 사용한 색종이 개수
     * @param remain 남은 색종이 총 개수
     */
    private static void check(boolean[][] map, int[] arr, int R, int count, int remain) {
        if(count>answer&&answer!=26) return;    // 이미 더 색종이를 많이 사용했거나 초기 상태가 아닌 경우 return
        if(remain==0){
            answer = Math.min(count,answer);
            return;
        }
        for(int r=R; r<10; r++){
            for(int c=0; c<10; c++){
                if(map[r][c]){
                    for(int x = 1; x<=5; x++){
                        if(r+x-1>=10||c+x-1>=10) return;
                        for(int i = r; i<r+x; i++){
                            for(int j = c; j<c+x; j++){
                                if(!map[i][j]) return; // 범위 밖이면 return
                            }
                        }
                        if(arr[x]==0) continue;  // 이미 해당 색종이를 다 사용한 경우 continue
                        
                        boolean[][] tmpMap = new boolean[10][10];   // map 복사
                        int[] tmpPaper = new int[6]; // 붙인 색종이 상태 복사
                        mapCopy(tmpMap,map);
                        paperCopy(tmpPaper, arr);
                        tmpPaper[x]--;  // 붙인 색종이 종류
                        attach(tmpMap, r, c, x); // 색종이 붙이기
                        check(tmpMap, tmpPaper, r, count+1, remain-x*x); // 복사 및 상태가 변경된 map,tmpPaper, 사용 개수 + 1 해서 dfs
                    }
                }
            }
        }
        return;
    }    
    /**
     * 
     * @param map 색종이를 붙일 Map
     * @param R 시작 행
     * @param C 시작 열
     * @param size 몇 칸 붙일 지 나타내는 size
     */
    private static void attach(boolean[][] map, int R, int C, int size) {   
        for(int r=R; r<R+size; r++){
            for(int c=C; c<C+size; c++){
                map[r][c] = false;
            }
        }
    }
    private static void mapCopy(boolean[][] tmpMap, boolean[][] map) {
        for(int i=0; i<10; i++) System.arraycopy(map[i], 0, tmpMap[i], 0,10);
    }
    private static void paperCopy(int[] tmpPaper, int[] arr) {
        System.arraycopy(arr, 0, tmpPaper, 0, 6);
    }
}