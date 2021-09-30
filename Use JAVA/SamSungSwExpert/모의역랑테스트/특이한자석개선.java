package SamSungSwExpert.모의역랑테스트;

import java.io.*;
import java.util.*;

// N극은 0   S극은 1 -> 극이 같으면 회전X 다르면 반대 방향으로 회전
// 방향 : 1 = 시계방향 -1 반 시계 방향

public class 특이한자석개선 {
    static ArrayList<int[]> list;
    static int[] rotate;
    public static void main(String[] args) throws IOException{
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++){
            list = new ArrayList<>();
            list.add(new int[8]); // 쓰레기 값
            int order = Integer.parseInt(br.readLine());
            for(int i=1; i<=4; i++){
                st = new StringTokenizer(br.readLine());
                list.add(new int[8]); // 1~4 초기값
                for(int j=0; j<8; j++){
                    list.get(i)[j] = Integer.parseInt(st.nextToken());
                }
            }
            rotate = new int[5];
            for(int i=0; i<order; i++){
                st = new StringTokenizer(br.readLine());
                // 톱니바퀴 번호, 방향
                check(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
                for(int d=1; d<=4; d++){
                    if(rotate[d]!=0){
                        move(d, rotate[d]); // 회전하는 방향이 있으면 회전 실시
                    }
                }
                Arrays.fill(rotate, 0); // 이동 후 상태 초기화
            }

            int answer = 0;
            for(int i=1; i<=4; i++){
                int score = (int) Math.pow(2, i-1);
                if(list.get(i)[0]==1) answer += score;
            }
            bw.write("#"+t+" "+answer+"\n");
            bw.flush();
        }
        bw.close();
        br.close();

    }

    private static void move(int num, int dir) {
        if(dir==1){ // 시계 방향
            int temp = list.get(num)[7];
            for(int i=7; i>=1; i--){
                list.get(num)[i] = list.get(num)[i-1];
            }
            list.get(num)[0] = temp;
        }
        else{   // 반시계
            int temp = list.get(num)[0];
            for(int i=0; i<7; i++){
                list.get(num)[i] = list.get(num)[i+1];
            }
            list.get(num)[7] = temp;
        }
    }

    private static void check(int num, int dir) {   // 회전할지 안할지 체크용
        int temp = dir;
        rotate[num] = dir;
        for(int i=num; i<=3; i++){  // 오른쪽 자석 비교
            if(compare(i,i+1)){
                rotate[i+1] = dir*-1;
                dir *=-1;
            }
            else break;
        }
        dir = temp;
        for(int i=num; i>=2; i--){  // 왼쪽 자석 비교
            if(compare(i-1,i)){
                rotate[i-1] = dir*-1;
                dir *= -1;
            }
            else break;
        }


    }
    private static boolean compare(int left, int right) {
        if(list.get(left)[2]!=list.get(right)[6]){
            return true;
        }
        return false;
    }
}