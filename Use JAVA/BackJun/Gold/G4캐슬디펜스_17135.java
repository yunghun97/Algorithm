package BackJun.Gold;
import java.io.*;
import java.util.*;


public class G4캐슬디펜스_17135 {
    static int answer, temp, range, N, M, distance, destroy;
    static int[][] map, mapTemp, mapClone;
    static int[] bow;
        public static void main(String[] args) throws IOException {
            System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\BackJun\\Gold\\G4캐슬디펜스_17135.txt"));
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st;
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            range = Integer.parseInt(st.nextToken());
            map = new int[N][M];
            mapClone = new int[N][M];
            bow = new int[3];
            mapTemp = new int[range][M];
            distance =0;
            destroy =0;
            for(int i=N-1; i>=0; i--){
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<M; j++){
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            combination(0,0);
            System.out.println(answer);
        }
        
        private static void combination(int cnt, int start) {
            if(cnt==3){
                cal();       //bow배열의 값은 궁수의 column 좌표가 된다.
                answer = Math.max(destroy, answer);
                destroy =0;
                return;
            }
            for(int i=start; i<M; i++){
                bow[cnt] = i;
                combination(cnt+1, i+1);
            }
        }
        
        
        
        private static void cal() { // 궁수의 좌표
            for(int i=0; i<N; i++){
                for(int j=0; j<M; j++){
                    mapClone[i][j] = map[i][j];
                }
            }
            boolean[][] overLapCheck = new boolean[N][M];
            

            for(int start0=0; start0<N; start0++){
                int[][] rc = new int[3][2];

            for(int b=0; b<3; b++){
                boolean enemyCheck = false;
                int checkMin = Integer.MAX_VALUE;   
                int r=0; int c=0;
            for(int start1 =start0; start1<start0+range; start1++){
                if(enemyCheck) break;
                enemyCheck = false;
                if(start1<N){

                for(int start2=M-1; start2>=0; start2--){
                    if(mapClone[start1][start2]==1){
                        enemyCheck = true;
                        int temp = Math.min(checkMin,Math.abs(start2-bow[b]));
                        if(temp<=checkMin){
                            r = start1; c=start2;
                            checkMin = temp;
                        }
                    }
                }
            }
                else break;
            }
                if(!overLapCheck[r][c]){
                    ++destroy; 
                    overLapCheck[r][c]=true;
                    mapClone[r][c]=0;
                    rc[b][0] = r; rc[b][1]=c;
                }

            }
            for(int rc1=0; rc1<3; rc1++){mapClone[rc[rc1][0]][rc[rc1][1]] =0;}
        }

        }
}
    



        /*private static void kill() {
            boolean[][] overLapCheck = new boolean[mapTemp.length][mapTemp[0].length];
           
                for(int i=0; i<mapTemp.length;i++){
                    for(int y=0; y<mapTemp[i].length; y++){
                        System.out.print(mapTemp[i][y]+" ");
                    }
                    System.out.println();
        }

        }*/


/*int cal = Integer.MAX_VALUE;
                 for(int b1=0; b1<3; b1++){     // 궁수 인원 만큼
                int locateC =0; int locateR=0;
                for(int r1=0; r1<range; r1++){
                for(int b2=0; b2<mapTemp[0].length; b2++){
                    for(int b3=0; b3<mapTemp.length; b3++){
                        if(mapTemp[b3][b2]==1){
                        if(cal<=Math.abs(b2-bow[b1])){
                        cal = Math.min(Math.abs(b2-bow[b1]), cal);
                        locateC = b3; locateR = b2;
                    }}

                    }
                }
                if(!overLapCheck[locateR][locateC]){ 
                    mapClone[locateR][locateC]=0;
                    destroy++; overLapCheck[locateR][locateC]=true;}
                else{}
            }
        }*/