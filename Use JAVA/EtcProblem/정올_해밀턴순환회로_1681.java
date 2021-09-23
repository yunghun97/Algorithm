package EtcProblem;

import java.io.*;
import java.util.*;
public class 정올_해밀턴순환회로_1681 {
    static int N,answer;
    static int[][] map;
    static int[] arr;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        answer = Integer.MAX_VALUE;
        arr = new int[N];
        isVisited = new boolean[N];
        permutation(1,0);
        bw.write(""+answer);
        bw.flush();
        br.close();
        bw.close();
    }
    private static void permutation(int cnt, int sum) {
        if(sum>=answer) return;  // 이미 초과시 더 탐색 X
        if(cnt==N){
            if(map[arr[cnt-1]][0]==0) return;   // 돌아가는 길이 없을 경우
            answer = Math.min(answer, sum+map[arr[cnt-1]][0]);
            return;
        }
        for(int i=1; i<N; i++){
            if(isVisited[i]) continue;  // 이미 방문
            if(map[arr[cnt-1]][i]==0) continue; // 길이 없을 때
            isVisited[i] = true;
            arr[cnt] = i;
            permutation(cnt+1, sum+map[arr[cnt-1]][arr[cnt]]);
            isVisited[i] = false;
        }

    }
}
//http://jungol.co.kr/bbs/board.php?bo_table=pbank&wr_id=954&sca=3030