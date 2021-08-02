package EtcProblem;

import java.io.*;
import java.util.*;
public class 기지국문제 {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        int[] dx = {-1,0,0,1};
        int[] dy = {0,-1,1,0};
        int count =0;
        System.setIn(new FileInputStream("Use JAVA\\EtcProblem\\input.txt"));    
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());    
        for(int t=1; t<=T; t++){
        int size = Integer.parseInt(br.readLine());
        char[][] map = new char[size][];


        for(int i=0; i<size; i++){          // 배열 입력
            String st = br.readLine();      // 한줄씩 입력받아서 배열에 넣기
                map[i] = st.toCharArray();          //st.substring(j,j+1); 
        }       // 계산
        //System.out.println(Arrays.deepToString(map));
        for(int r=0; r<size; r++){
            for(int c=0; c<size; c++){
                switch(map[r][c]){
                    case 'A' :      // a일 때 1칸씩
                    for(int d=0; d<4; d++){
                        int nr = r;
                        int nc = c;
                        for(int a= 0; a<1; a++){
                            nr+=dx[d];
                            nc+=dy[d];
                            if(nr>=0&&nr<size&&nc>=0&&nc<size){
                                if(map[nr][nc]=='H'){
                                    map[nr][nc]='X';}
                            }
                            else break;
                        }
                    }
                    break;
                    case 'B' :      // b일 때 2칸 씩
                    for(int d=0; d<4; d++){
                        int nr = r;
                        int nc = c;
                        for(int a= 0; a<2; a++){
                            nr+=dx[d];
                            nc+=dy[d];
                            if(nr>=0&&nr<size&&nc>=0&&nc<size){
                                if(map[nr][nc]=='H'){
                                    map[nr][nc]='X';}
                            }
                            else break;
                        }
                    }
                    break;
                    case 'C' :      // c일 때 3칸 씩
                    for(int d=0; d<4; d++){
                        int nr = r;
                        int nc = c;
                        for(int a= 0; a<3; a++){
                            nr+=dx[d];
                            nc+=dy[d];
                            if(nr>=0&&nr<size&&nc>=0&&nc<size){
                                if(map[nr][nc]=='H'){
                                    map[nr][nc]='X';}
                            }
                            else break;
                        }
                    }
                    break;
                    default : break;
                }
            }
        }
        for(int y=0; y<size; y++){
            for(int z=0; z<size; z++){
                if(map[y][z]=='H'){count++;}
            }
        }
        System.out.printf("#%d %d\n",t,count);
        count =0;
        }
    }
}
