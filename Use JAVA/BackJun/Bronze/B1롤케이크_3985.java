package BackJun.Bronze;

import java.io.*;
import java.util.*;
public class B1롤케이크_3985 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int length = Integer.parseInt(br.readLine());
        int people = Integer.parseInt(br.readLine());
        int predict=0,real = 0, get=0, temp=0;
        boolean[] rollCake = new boolean[length+1];
        for(int i=1; i<=people; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(b-a>temp){   // 같으면 적은 번호 이므로 더 큰 경우에만 바꾸어준다.
                predict = i;
                temp = b-a;
            }
            int check = 0;
            for(int j=a; j<=b; j++){    // 케이크 개수 체크
                if(!rollCake[j]){
                    rollCake[j] =true;
                    check++;
                }
            }
            if(check>get){  // 더 크면 갱신
                get = check;
                real = i;
            }
        }
        bw.write(""+predict+"\n"+real);
        bw.flush();
        bw.close();
        br.close();
    }
}
//https://www.acmicpc.net/problem/3985

/**
입력
10
5
1 1
1 2
1 3
1 4
7 8
출력
4
5
 */