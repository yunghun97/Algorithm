package BackJun.Bronze;

import java.io.*;
import java.util.*;
public class B1딱지놀이_14696 {
    /*
    만약 두 딱지의 별의 개수가 다르다면, 별이 많은 쪽의 딱지가 이긴다.
    별의 개수가 같고 동그라미의 개수가 다르다면, 동그라미가 많은 쪽의 딱지가 이긴다.
    별, 동그라미의 개수가 각각 같고 네모의 개수가 다르다면, 네모가 많은 쪽의 딱지가 이긴다.
    별, 동그라미, 네모의 개수가 각각 같고 세모의 개수가 다르다면, 세모가 많은 쪽의 딱지가 이긴다.
    별, 동그라미, 네모, 세모의 개수가 각각 모두 같다면 무승부이다.
    */

    /// 별 4 : 동 3 네모 : 2 세모 : 1
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int size = Integer.parseInt(br.readLine());
        for(int i=0; i<size; i++){
            st = new StringTokenizer(br.readLine());
            int aSize = Integer.parseInt(st.nextToken());
            int[] aArr = new int[5];
            for(int x=0; x<aSize; x++){
                aArr[Integer.parseInt(st.nextToken())]++;
            }
            st = new StringTokenizer(br.readLine());
            int bSize = Integer.parseInt(st.nextToken());
            int[] bArr = new int[5];
            for(int x=0; x<bSize; x++){
                bArr[Integer.parseInt(st.nextToken())]++;
            }
            for(int y=4; y>=0; y--){
                if(y==0){ bw.write("D\n"); break;}
                if(aArr[y]>bArr[y]){
                    bw.write("A\n");
                    break;
                }else if(aArr[y]==bArr[y]){
                    continue;
                }else {
                    bw.write("B\n");
                    break;
                }
                
            }
        }
        bw.flush();
        bw.close();
        br.close();
        
    }
}
// https://www.acmicpc.net/problem/14696

/*
입력
4
4 4 3 2 1
4 1 4 3 2
4 3 3 2 1
4 4 3 3 3
4 4 3 3 3
4 3 4 3 2
4 3 2 1 1
3 3 2 1
출력
D
B
A
A
*/