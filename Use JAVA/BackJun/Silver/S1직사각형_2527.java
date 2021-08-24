package BackJun.Silver;

import java.io.*;
import java.util.*;


public class S1직사각형_2527 {
    static int[] first, second;
    public static void main(String[] args) throws IOException{    // 직사각형 a 선분 b 점 c 공통부분 x = d
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringTokenizer st;
        for(int t=0; t<4; t++){
            first = new int[4];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<4; i++){
                first[i] = Integer.parseInt(st.nextToken());
            }
            second = new int[4];
            for(int i=0; i<4; i++){
                second[i] = Integer.parseInt(st.nextToken());
            }   
            if(first[2]<second[0]||second[2]<first[0]||first[3]<second[1]||first[1]>second[3]){ //안 겹침 
                System.out.println('d');
                continue;
            }
            // 점 -> 각각의 꼭짓점 좌표가 같은 경우
            if((first[0]==second[2]&&first[1]==second[3])||(first[2]==second[0]&&first[1]==second[3])||(first[2]==second[0]&&first[3]==second[1])||(first[0]==second[2]&&first[3]==second[1])){ //점
                System.out.println('c');
                continue;
            }
            // 선분 -> 각 변의 좌표가 같은 경우 -> 점은 다 제거 되었으므로 무조건 남은 부분은 선분이 된다.
            if((first[2]==second[0])||(first[0]==second[2])||(first[1]==second[3])||(first[3]==second[1])){ //선분
                System.out.println('b');
                continue;
            }
            // 다 옳지 않으면 직사각형인 경우
            System.out.println('a'); // 다 아니면 직사각형

        }
    }
}
