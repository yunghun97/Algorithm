package Basic.SSAFYHW;
import java.util.Scanner;
public class SsafyWaterstrider {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test_case = sc.nextInt();
        for(int t=1; t<=test_case; t++) {
        
        int size = sc.nextInt();
        int saltNumber = sc.nextInt();
        boolean[][] temp = new boolean[size][size];
        int answer =0;
        int[] locationRTemp = new int[saltNumber];
        int[] locationCTemp = new int[saltNumber];
        int[] directionTemp = new int[saltNumber];
        int[] locationR = new int[saltNumber];
        int[] locationC = new int[saltNumber];
        int[] direction = new int[saltNumber];
        int input =0;
        int saltCount = 0;
        int[] dr = {0,-1,1,0,0};
        int[] dc = {0,0,0,-1,1};
        int[] jump ={3,2,1};
        for(int i=0; i<saltNumber; i++) {
            locationRTemp[i] = sc.nextInt();
            locationCTemp[i] = sc.nextInt();
            directionTemp[i] = sc.nextInt();
            if(temp[locationRTemp[i]][locationCTemp[i]]== false) {  // 시작부터 겹치는 소금쟁이 분리하기 
                temp[locationRTemp[i]][locationCTemp[i]]= true;
                saltCount++;   // 살아있는 소금쟁이 갯수만 따로 카운트
                locationR[input] = locationRTemp[i];
                locationC[input] = locationCTemp[i];
                direction[input] = directionTemp[i];             
                input++;  //0번지 부터 확인 용
            }
            }
            for(int i=0; i<saltCount; i++) {
                    int nr = locationR[i];             // 처음 좌표 값 할당하기
                    int nc = locationC[i];
                    int count =0;             
                    for(int x=0; x<3; x++){
                    
                    nr +=(dr[direction[i]]*jump[x]);   //jum로 곱해주고 dr로 방향을 정한다. 입력값이 1부터 이므로 0 가짜 방향 넣어줌
                    nc +=(dc[direction[i]]*jump[x]);
                    if(nr>=0&&nr<size&&nc<size&&nc>=0&&temp[nr][nc]==false){
                        temp[locationR[i]][locationC[i]]=false;         // 한번이라도 성공하면 죽든 살든 벗어나기 때문에 false로 바꾼다.
                        count++;                      
                    }
                    else{
                        continue;
                    }
                    if(count==3){
                        temp[nr][nc]=true;          // 3번 못 도달시 죽은거이므로 그전에 true로 변경할 필요가 없다.
                        answer++;
                    }
                }
                
            }          
            System.out.printf("#%d %d\n",t,answer);   // 정답 출력
        }   
            sc.close();        
        }
}
