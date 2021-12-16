package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G4연구소2_17141 {
    static int[] dx ={-1,0,0,1}, dy = {0,-1,1,0}, arr;
    static ArrayList<Virus> vList;
    static boolean[][] isVisited, defaultMap;
    static int N,M, ZeroCount, VirusCount, answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        isVisited = new boolean[N][N];
        defaultMap = new boolean[N][N];
        vList = new ArrayList<>();
        ZeroCount = 0;
        VirusCount = 0;
        arr = new int[M];
        answer = Integer.MAX_VALUE;

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                int a = Integer.parseInt(st.nextToken());
                if(a==1){   // 벽
                    defaultMap[i][j] = true;
                }else if(a==0){ //빈칸
                    ZeroCount++;                    
                }else{  // 바이러스
                    VirusCount++;
                    vList.add(new Virus(i,j));
                }
            }
        }
        ZeroCount+=VirusCount-M;     // 빈칸개수 = 빈칸개수 + 바이러스 총 개수 - 활성화되는 바이러스 개수
        if(ZeroCount==0){
            bw.write(String.valueOf(0));
        }else{       
            combination(0,0);
            if(answer==Integer.MAX_VALUE) bw.write(String.valueOf(-1));
            else bw.write(""+answer);            
        }
        bw.flush();
    }    

    private static void combination(int cnt, int start) {
        if(cnt==M){
            answer = Math.min(spread(),answer);
            return;
        }
        for(int i=start; i<VirusCount; i++){
            arr[cnt] = i;
            combination(cnt+1, i+1);
        }
    }

    private static int spread() {
        for(int i=0; i<N; i++) Arrays.fill(isVisited[i], false);
        Queue<Virus> q = new LinkedList<>();
        int time = 0;
        int speardCount =0;
        for(int i=0; i<M; i++){
            Virus virus = vList.get(arr[i]);
            q.add(new Virus(virus.r, virus.c));
            isVisited[virus.r][virus.c] = true;
        }
        while(!q.isEmpty()){
            time++;
            if(time>answer) break;  // 이미 시간보다 크면 더 탐색 X
            int size = q.size();
            for(int i=0; i<size; i++){
                Virus virus = q.poll();
                for(int d=0; d<4; d++){
                    int nr = virus.r + dx[d];
                    int nc = virus.c + dy[d];
                    if(nr<0||nr>=N||nc<0||nc>=N||isVisited[nr][nc]||defaultMap[nr][nc]) continue;
                    isVisited[nr][nc] = true;
                    speardCount++;  // 전파 개수 
                    q.add(new Virus(nr, nc));                
                }
            }
        }
        if(speardCount!=ZeroCount) return Integer.MAX_VALUE;    // 전파개수와 빈칸개수가 다르면 다 전파 못했으므로 MAX값 return
        time--; // 이미 다 전파하고도 무조건 1번 더 탐색하므로 -1 해준다.
        return time;
    }

    static class Virus{
        int r;
        int c;
        public Virus(int r, int c){
            this.r = r;
            this.c = c;
        }
    }

}
//https://www.acmicpc.net/problem/17141