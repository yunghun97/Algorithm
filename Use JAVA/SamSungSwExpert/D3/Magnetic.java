package SamSungSwExpert.D3;

import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;


public class Magnetic { //1이 N 2는 S  // 천장 N 바닥 S
    static int[][] map = new int[100][100];
    static int check,answer;
    static boolean N,S;
    static Deque<Integer> dq = new LinkedList<>();
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.setIn(new FileInputStream("Use JAVA\\inputTxt모음\\SWExpert\\D3\\Magnetic.txt"));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        for(int x=1; x<=10; x++){
        answer =0 ;
        int temp=0;
        br.readLine();
        for(int n=0; n<100; n++){
            st = new StringTokenizer(br.readLine()," ");
            for(int m=0; m<100; m++){
                map[n][m]=Integer.parseInt(st.nextToken());
            }
        }
        for(int i=0; i<100; i++){
            for(int j=0; j<100; j++){
                temp = map[j][i];
                if(temp==1){
                    N=true;
                    dq.add(j);
                }
                else if(temp==2){
                    S=true;
                    dq.add(j);
                }

        }
        if((N&&!S)||(S&&!N)){       // 한가지 종류면 큐 초기화 시키고 다른 열로 간다.
            while(!dq.isEmpty()){
                dq.clear();
                N=false; S=false;
            }
        }
        else{               // 무조견 교착상태가 발생하는 부분
            FirstNCheck(i);
            FirstSCheck(i);
            DeadLockCheck(i);
            N=false;
            S=false;
        }
        }
        bw.write("#"+x+" "+answer+"\r\n");
        bw.flush();
         
    } // 테케 끝
        bw.close();
        br.close();
}
    static void FirstNCheck(int R){         // N천장으로 이동하는 S극제거
        while(!dq.isEmpty()){
        int check = dq.getFirst();
        if(map[check][R]==2){
            dq.removeFirst();
        }
        else break;
    }
        return;
    }
    static void FirstSCheck(int R){         //  S바닥으로 이동하는 N극제거
        while(!dq.isEmpty()){
        int check = dq.getLast();
        if(map[check][R]==1){
            dq.removeLast();
        }
        else break;
    }
        return;
    }
    static void DeadLockCheck(int R){       // 교착상태 체크
            N=false; S=false;
            int temp;
            while(!dq.isEmpty()){
                temp = map[dq.poll()][R];
                if(temp==1){
                    N=true;
                }
                else{
                    S=true;
                }
                if(N&&S){
                    answer++;
                    if(!dq.isEmpty()){        // 같은 극의 자석이 나오는 부분 제거
                    if(temp==1){
                        while(map[dq.peek()][R]==1){        // 다른 값 나오면 처음으로 돌아감
                            dq.poll();
                            N=false; S=false;
                            if(dq.isEmpty()){
                                break;
                            }
                        }
                    }
                    else{
                        while(map[dq.peek()][R]==2){        // 다른 값 나오면 처음으로 돌아감
                            dq.poll();
                            N=false; S=false;
                            if(dq.isEmpty()){
                                break;
                            }
                        }
                    }
                }
                    N=false;
                    S=false;
                }
            }
            return;
    }
}
