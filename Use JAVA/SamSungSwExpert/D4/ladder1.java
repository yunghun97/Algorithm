package SamSungSwExpert.D4;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class ladder1{
    static int[][] ladder = new int[100][100];
    static int[] dy = {-1,1};
    public static void main(String[] args) throws IOException{
    		
        	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer st ;
        	for(int T=0; T<10; T++){
            int answer =0;
            int test = Integer.parseInt(br.readLine());
            for(int o=0; o<100; o++){
                st = new StringTokenizer(br.readLine());
                for(int p=0; p<100; p++){
            			ladder[o][p] = Integer.parseInt(st.nextToken());
            	}
            }
    for(int i=0; i<100; i++){
  			if(ladder[99][i]==2){
                  answer = i; break;
              }
              else continue;
    }
    System.out.printf("#%d %d\n",test,findDes(answer));
        } // 10번 반복의 끝
    }
    static int findDes(int dest){
    int nr = 99; int nc = dest;
           while(nr>0){
               nr--;
               outer2 : for(int d=0; d<2; d++){ 
                   nc +=dy[d];
                   if(nc>=0&&nc<100&&ladder[nr][nc]==1){        // 배열 index 범위와 사다리 값 확인
                        outer1 : while(true){
                            nc += dy[d];
                            if(nc<0||nc>=100||ladder[nr][nc]!=1){
                                nc-=dy[d];
                                break outer2;}      //   사다리 한칸 올라간 상태로 돌려줌
                        }                        
                   }
                   else nc-=dy[d];  // 원 위치
               }
    }
    // while 밖에꺼    
    return nc;
    }
}
//https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AV14ABYKADACFAYh