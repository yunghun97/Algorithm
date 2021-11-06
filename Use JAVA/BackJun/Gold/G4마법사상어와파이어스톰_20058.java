package BackJun.Gold;

import java.io.*;
import java.util.*;

public class G4마법사상어와파이어스톰_20058 {
    static int N, order, sum, ice;
    static int[][] defaultMap;
    static int[] dx = {-1,0,0,1}, dy ={0,-1,1,0};
    static Queue<Node> q;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = (int) Math.pow(2, Integer.parseInt(st.nextToken()));
        order = Integer.parseInt(st.nextToken());
        defaultMap = new int[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                defaultMap[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        st = new StringTokenizer(br.readLine());
        q = new LinkedList<>();
        while(st.hasMoreTokens()){
            int input = Integer.parseInt(st.nextToken());
            move(input);
            /*System.out.println("-----");
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    System.out.print(defaultMap[i][j]+" ");
                }
                System.out.println();
            }*/
            melt();
        }   
        sum = 0;
        ice = 0;
        answer();
        bw.write(""+sum+"\n"+ice);
        bw.flush();
    }
    private static void answer() {  // 정답 구하기
        for(int i=0; i<N; i++){ // 얼음숫자 합
            for(int j=0; j<N; j++){
                sum+=defaultMap[i][j];
            }
        }
        boolean[][] isVisited = new boolean[N][N];
        for(int i=0; i<N; i++){ // 덩어리 구하기
            for(int j=0; j<N; j++){
                if(defaultMap[i][j]!=0&&!isVisited[i][j]){
                    q.add(new Node(i,j));
                    int visit = 0;
                    isVisited[i][j] = true;
                    while(!q.isEmpty()){
                        Node node = q.poll();
                        visit++;
                        
                        for(int d=0; d<4; d++){
                            int nr = node.r +dx[d];
                            int nc = node.c +dy[d];
                            if(nr<0||nr>=N||nc<0||nc>=N||isVisited[nr][nc]||defaultMap[nr][nc]==0) continue;
                            q.add(new Node(nr,nc));
                            isVisited[nr][nc] = true;
                        }
                    }
                    ice = Math.max(visit,ice);
                }
            }
        }
        
    }
    private static void melt() {    // 녹이기
        for(int i=0; i<N; i++){
            for(int j=0; j<N; j++){
                if(defaultMap[i][j]==0) continue;
                else{
                    int checkCount =0;
                    for(int d=0; d<4; d++){
                        int nr = i+dx[d];
                        int nc = j+dy[d];
                        if(nr<0||nr>=N||nc<0||nc>=N||defaultMap[nr][nc]==0) continue;
                        else checkCount++;
                    }
                    if(checkCount<3){
                        q.add(new Node(i,j));
                    }
                }
            }
        }
        while(!q.isEmpty()){
            Node node = q.poll();
            defaultMap[node.r][node.c]--;
        }
    }
    private static void move(int num) {      // 회전메소드
        int size = (int) Math.pow(2, num);   // 연산 끝나면 행, 열에 더 할 숫자
        int[][] newMap = new int[N][N];
        for (int i = 0; i <N; i+=size) {
			for (int j = 0; j < N; j+=size) {
				int sx=j;
				int sy=i;
				for (int x = j; x < j+size; x++) {
					sx=j;
					for (int y = i+size-1; y >=i; y--) {
						newMap[sy][sx++]=defaultMap[y][x];
					}
					sy++;
				}
			}
		}
        defaultMap = newMap;
    }   
    static class Node{
        int r;
        int c;
        public Node(int r, int c){
            this.r = r;
            this.c = c;
        }
    }
}
//https://www.acmicpc.net/status?user_id=yunghun97&problem_id=20058&from_mine=1