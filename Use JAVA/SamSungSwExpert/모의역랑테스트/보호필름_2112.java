package SamSungSwExpert.모의역랑테스트;

import java.io.*;
import java.util.*;

public class 보호필름_2112 {
    static int D, W, K, answer, result;    
    static boolean[][] defaultMap, map; // true 면 A false 면 B
    static HashMap<Integer, Boolean> hmap;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        hmap = new HashMap<>();
        for(int t=1; t<=T; t++){
            hmap.clear();
            st = new StringTokenizer(br.readLine());

            D = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            defaultMap = new boolean[D][W];
            map = new boolean[D][W];
            mapCopy(defaultMap, map);
            for(int i = 0; i < D; i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < W; j++){
                    int a = Integer.parseInt(st.nextToken());
                    if(a==0){
                        defaultMap[i][j] = true;
                    }
                }
            }
            mapCopy(defaultMap, map);

            answer = 0;
            result = 0;
            
            
            if(check(defaultMap)){
          
            }else{  // 아니면
                answer = Integer.MAX_VALUE;
                spread(map, 0);    
            }
            
            bw.write("#"+t+" "+answer+"\n");

        }// 테케 끝
        bw.flush();
    }
    private static void spread(boolean[][] map, int start) {                
        if(check(map)){
            answer = Math.min(answer, hmap.size()); 
            return;
        }
        if(hmap.size()-1>=answer||hmap.size()==D) return;
            for (int i = start; i < D; i++) {
                if (hmap.size() - 1 >= answer)
                    return;
                if (hmap.containsKey(i)) {
                    continue;
                } else {
                    hmap.put(i, true);
                    change(map, hmap.get(i), i);
                    spread(map, i + 1);

                    hmap.put(i, false);
                    change(map, hmap.get(i), i);
                    spread(map, i + 1);

                    restoreMap(defaultMap, map, i);
                    hmap.remove(i);
                }
            }
        
        }
    private static void restoreMap(boolean[][] deMap, boolean[][] tmpMap, int i) {  // 해당 행의 모든 열을 다시 원 상태로 복구
        System.arraycopy(deMap[i], 0, tmpMap[i], 0, W);
    }
    private static void change(boolean[][] tmpMap, boolean kind, int r) { // 해당 행의 모든 열을 kind로 바꿔 준다.
        for(int c = 0; c < W; c++){
            tmpMap[r][c] = kind;
        }
    }
 
    private static void mapCopy(boolean[][] dMap, boolean[][] tmpMap) { // map 복사
        for(int i = 0; i < D; i++){
            System.arraycopy(dMap[i], 0, tmpMap[i], 0, W);
        }
    }
    private static boolean check(boolean[][] tmpMap) { // 해당 map이 조건에 만족하면 true 아니면 false return
        for(int c = 0 ; c < W; c++){
            result = 0;
            countSell(tmpMap, tmpMap[0][c], 0, 0, c);
            if(result<K) return false;
        }
        return true;
    }
    private static void countSell(boolean[][] tmpMap, boolean cell, int count, int r, int c) {  // 연속된 셀의 계수 카운트
        if(cell==tmpMap[r][c]){
            count += 1;
        }else{
            count = 1;
        }
        result = Math.max(count,result);        

        if(r+1>=D){
            return;
        }
        countSell(tmpMap ,tmpMap[r][c], count, r+1, c);
    }    
}
// https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV5V1SYKAaUDFAWu&