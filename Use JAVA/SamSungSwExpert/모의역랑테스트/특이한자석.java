package SamSungSwExpert.모의역랑테스트;

import java.io.*;
import java.util.*;

// N극은 0   S극은 1 -> 극이 같으면 회전X 다르면 반대 방향으로 회전
// 방향 : 1 = 시계방향 -1 반 시계 방향
public class 특이한자석 {
    static ArrayList<int[]> list;
    static int[] rotate;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
        rotate = new int[5];    // 회전할 톱니바퀴 저장
        list = new ArrayList<>();   // 톱니바퀴 저장
        int order = Integer.parseInt(br.readLine());
        for(int i=0; i<4; i++){
            st = new StringTokenizer(br.readLine());
            list.add(new int[]{0,0,0,0,0,0,0,0});   // 기본값 세팅
            for(int j=0; j<8; j++){
                list.get(i)[j]=Integer.parseInt(st.nextToken());
            }
        }
        int answer= 0;
        for(int i=0; i<order; i++){ // 명령 개수만큼 move메소드 실행
            st = new StringTokenizer(br.readLine());    // 자석번호, 회전 방향
            move(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            for(int x=1; x<=4; x++){
                if(rotate[x]!=0) rotateArr(x,rotate[x]);    // x톱니바퀴를 roate[x]에 저장된 방향만큼 돌린다.
            }
            Arrays.fill(rotate, 0); // 0이면 회전이미 한걸로 체크
        }
        /*System.out.println(list.get(0)[0]);
        System.out.println(list.get(1)[0]);
        System.out.println(list.get(2)[0]);
        System.out.println(list.get(3)[0]);*/

        if(list.get(0)[0]==1) answer++;
        if(list.get(1)[0]==1) answer+=2;
        if(list.get(2)[0]==1) answer+=4;
        if(list.get(3)[0]==1) answer+=8;
        bw.write("#"+t+" "+answer+"\n");
        bw.flush();
        }
        br.close();
        bw.close();
    }
    private static void move(int num, int dir) {    // 톱니바퀴 체크
        rotate[num] = dir;
        if(num==1){ // 1번부터 체크
            if(check(1,2)){
                rotate[2] = dir*-1;
                if(check(2, 3)){
                    rotate[3] = dir;
                    if(check(3, 4)){
                        rotate[4] = dir*-1;
                    }
                }
            }
        }else if(num==2){   // 2번 체크
            if(check(1, 2)) rotate[1] = dir*-1;
            if(check(2, 3)){
                rotate[3] = dir*-1;
                if(check(3, 4)){
                    rotate[4] = dir;
                }
            }

        }else if(num==3){   // 3번 체크
            if(check(3, 4)) rotate[4] = dir*-1;
            if(check(2, 3)){
                rotate[2] = dir*-1;
                if(check(1, 2)){
                    rotate[1] = dir;
                }
            }
        }else{  // 4번 체크
            if(check(3, 4)){
                rotate[3] = dir*-1;
                if(check(2, 3)){
                    rotate[2] = dir;
                    if(check(1, 2)){
                        rotate[1] = dir*-1;
                    }
                }
            }
        }
    }

    private static boolean check(int left, int right){  // N극 S극 체크 
        if(list.get(left-1)[2]==list.get(right-1)[6]){  // 왼쪽 톱니바퀴의 오른쪽 비교점, 오른쪽 톱니바퀴의 왼쪽 비교점을 비교해서 같으면 false 이동 안함
            return false;
        }
        else return true;
    }

    private static void rotateArr(int num, int dir){    // 회전 메소드  
        if(dir==1){ // 시계 방향
            int temp = list.get(num-1)[7];
            for(int i=7; i>=1; i--){
                list.get(num-1)[i]=list.get(num-1)[i-1];
            }
            list.get(num-1)[0] = temp;
        }else{  // 반 시계 방향
            int temp = list.get(num-1)[0];
            for(int i=0; i<7; i++){
                list.get(num-1)[i]=list.get(num-1)[i+1];
            }
            list.get(num-1)[7] = temp;
        }
    }
}