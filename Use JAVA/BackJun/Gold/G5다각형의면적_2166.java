package BackJun.Gold;

import java.io.*;
import java.util.*;
public class G5다각형의면적_2166 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
        double[] xArr = new double[N];
        double[] yArr = new double[N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            xArr[i] = x;
            yArr[i] = y;
        }
        double sum1 = 0;
        double sum2 = 0;
        for(int i=0; i<N; i++){
            if(i==N-1){
                sum1 += xArr[i] * yArr[0];
                sum2 += yArr[i] * xArr[0];
            }else{                
                sum1 += xArr[i] * yArr[i+1];
                sum2 += yArr[i] * xArr[i+1];
            }
        }
        double answer = Math.abs(sum1 - sum2) / 2;        
        bw.write(String.format("%.1f", answer));        
        bw.flush();
    }
}
// https://www.acmicpc.net/problem/2166
// 신발끈 공식 (좌표평면 상에서 꼭짓점의 좌표를 알 때 다각형의 면적을 구할 수 있는 방법이다.)
// https://ko.wikipedia.org/wiki/%EC%8B%A0%EB%B0%9C%EB%81%88_%EA%B3%B5%EC%8B%9D
/*
요약 
1. 첫번째 x좌표 * 2번째 y좌표 + 2번째 x좌표 3번째 y좌표 + n번째 x좌표 * 첫번째 y좌표
2. 첫번째 y좌표 * 2번째 x좌표 + 2번째 y좌표 3번째 x좌표 + n번째 y좌표 * 첫번째 x좌표

(1번결과 - 2번 결과) / 2
*/