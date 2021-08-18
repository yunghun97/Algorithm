package BackJun.Silver;

import java.io.*;
import java.util.StringTokenizer;


public class S1Z_1074 {
    static int N,R,C,count, sum,answer;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        count =0;
        sum = exp(2,N);
        cal(sum, R,C);
        bw.write(""+answer);
        bw.flush();
        bw.close();
        br.close();
    }
    // 분할 정복으로 구하기
    static int cal(int len, int r, int c){
        if(len==1) return answer; // 마지막 1칸이므로 answer을 리턴한다.
        len /=2; // 반으로 쪼개기
        if(r<len&&c<len) cal(len,r,c); // 범위 안이므로 더하지 않고 다시 호출
        else if(r<len&&c>=len){ // 오른쪽은 2^n-1이 넘어가야 나오는 수이므로 2^n-1만큼 더한다.
            c-=len;
            answer += len*len;  
            cal(len,r,c);
        }else if(r>=len&&c<len){ //왼쪽아래는 2^n-1이 2번된거 이상이므로
            r-=len;
            answer+=len*len*2;
            cal(len,r,c);
        }else{                  // 오른쪽 아래는 3번이다.
            r-=len; c-=len;
            answer+=len*len*3;
            cal(len,r,c);
        }
        return 0;
    }

//제곱 구하기
static int exp(int x, int y){
    if(y==1) return x;
    int r = exp(x,y/2);
    int res = r*r;
    if(y%2==1) res *=x;
    
    return res;
    }

}
//https://www.acmicpc.net/problem/1074